/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import sul.utils.*;

public class EntityRelativeMove extends Packet {

	public final static int ID = (int)37;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public Tuples.ShortXYZ delta;
	public boolean onGround;

	public EntityRelativeMove() {}

	public EntityRelativeMove(int entityId, Tuples.ShortXYZ delta, boolean onGround) {
		this.entityId = entityId;
		this.delta = delta;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(entityId) + delta.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianShort(delta.x);this.writeBigEndianShort(delta.y);this.writeBigEndianShort(delta.z);
		this._buffer[this._index++]=(byte)(onGround?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		entityId=varuint.decode(_buffer, _index);
		delta.x=readBigEndianShort(); delta.y=readBigEndianShort(); delta.z=readBigEndianShort();
		onGround=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static EntityRelativeMove fromBuffer(byte[] buffer) {
		EntityRelativeMove ret = new EntityRelativeMove();
		ret.decode(buffer);
		return ret;
	}

}
