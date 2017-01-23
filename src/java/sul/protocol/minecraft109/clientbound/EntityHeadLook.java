/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import sul.utils.*;

public class EntityHeadLook extends Packet {

	public final static int ID = (int)52;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public byte headYaw;

	public EntityHeadLook() {}

	public EntityHeadLook(int entityId, byte headYaw) {
		this.entityId = entityId;
		this.headYaw = headYaw;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(entityId) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianByte(headYaw);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		entityId=varuint.decode(_buffer, _index);
		headYaw=readBigEndianByte();
	}

	public static EntityHeadLook fromBuffer(byte[] buffer) {
		EntityHeadLook ret = new EntityHeadLook();
		ret.decode(buffer);
		return ret;
	}

}
