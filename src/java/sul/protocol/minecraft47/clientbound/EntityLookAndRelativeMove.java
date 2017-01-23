/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.clientbound;

import sul.utils.*;

public class EntityLookAndRelativeMove extends Packet {

	public final static int ID = (int)23;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public Tuples.ByteXYZ delta;
	public byte yaw;
	public byte pitch;
	public boolean onGround;

	public EntityLookAndRelativeMove() {}

	public EntityLookAndRelativeMove(int entityId, Tuples.ByteXYZ delta, byte yaw, byte pitch, boolean onGround) {
		this.entityId = entityId;
		this.delta = delta;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(entityId) + delta.length() + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianByte(delta.x);this.writeBigEndianByte(delta.y);this.writeBigEndianByte(delta.z);
		this.writeBigEndianByte(yaw);
		this.writeBigEndianByte(pitch);
		this._buffer[this._index++]=(byte)(onGround?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		entityId=varuint.decode(_buffer, _index);
		delta.x=readBigEndianByte(); delta.y=readBigEndianByte(); delta.z=readBigEndianByte();
		yaw=readBigEndianByte();
		pitch=readBigEndianByte();
		onGround=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static EntityLookAndRelativeMove fromBuffer(byte[] buffer) {
		EntityLookAndRelativeMove ret = new EntityLookAndRelativeMove();
		ret.decode(buffer);
		return ret;
	}

}
