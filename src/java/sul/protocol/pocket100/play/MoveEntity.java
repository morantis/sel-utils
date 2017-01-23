/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class MoveEntity extends Packet {

	public final static byte ID = (byte)19;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public long entityId;
	public Tuples.FloatXYZ position;
	public byte pitch;
	public byte headYaw;
	public byte yaw;

	public MoveEntity() {}

	public MoveEntity(long entityId, Tuples.FloatXYZ position, byte pitch, byte headYaw, byte yaw) {
		this.entityId = entityId;
		this.position = position;
		this.pitch = pitch;
		this.headYaw = headYaw;
		this.yaw = yaw;
	}

	@Override
	public int length() {
		return Var.Long.length(entityId) + position.length() + 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeLittleEndianFloat(position.x);this.writeLittleEndianFloat(position.y);this.writeLittleEndianFloat(position.z);
		this.writeBigEndianByte(pitch);
		this.writeBigEndianByte(headYaw);
		this.writeBigEndianByte(yaw);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=varlong.decode(_buffer, _index);
		position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		pitch=readBigEndianByte();
		headYaw=readBigEndianByte();
		yaw=readBigEndianByte();
	}

	public static MoveEntity fromBuffer(byte[] buffer) {
		MoveEntity ret = new MoveEntity();
		ret.decode(buffer);
		return ret;
	}

}
