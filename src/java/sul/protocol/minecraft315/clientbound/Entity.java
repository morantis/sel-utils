/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import sul.utils.*;

public class Entity extends Packet {

	public final static int ID = (int)40;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;

	public Entity() {}

	public Entity(int entityId) {
		this.entityId = entityId;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(entityId);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		entityId=varuint.decode(_buffer, _index);
	}

	public static Entity fromBuffer(byte[] buffer) {
		Entity ret = new Entity();
		ret.decode(buffer);
		return ret;
	}

}
