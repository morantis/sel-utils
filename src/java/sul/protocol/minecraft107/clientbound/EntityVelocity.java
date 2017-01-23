/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import sul.utils.*;

public class EntityVelocity extends Packet {

	public final static int ID = (int)59;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public Tuples.ShortXYZ velocity;

	public EntityVelocity() {}

	public EntityVelocity(int entityId, Tuples.ShortXYZ velocity) {
		this.entityId = entityId;
		this.velocity = velocity;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + 6;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianShort(velocity.x); this.writeBigEndianShort(velocity.y); this.writeBigEndianShort(velocity.z);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		velocity.x=readBigEndianShort(); velocity.y=readBigEndianShort(); velocity.z=readBigEndianShort();
	}

	public static EntityVelocity fromBuffer(byte[] buffer) {
		EntityVelocity ret = new EntityVelocity();
		ret.decode(buffer);
		return ret;
	}

}