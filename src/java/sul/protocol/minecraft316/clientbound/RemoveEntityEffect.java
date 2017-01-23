/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import sul.utils.*;

public class RemoveEntityEffect extends Packet {

	public final static int ID = (int)49;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public byte effectId;

	public RemoveEntityEffect() {}

	public RemoveEntityEffect(int entityId, byte effectId) {
		this.entityId = entityId;
		this.effectId = effectId;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianByte(effectId);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		effectId=readBigEndianByte();
	}

	public static RemoveEntityEffect fromBuffer(byte[] buffer) {
		RemoveEntityEffect ret = new RemoveEntityEffect();
		ret.decode(buffer);
		return ret;
	}

}
