/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import java.util.UUID;

import sul.utils.*;

public class SpawnObject extends Packet {

	public final static int ID = (int)0;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public UUID uuid;
	public byte type;
	public Tuples.DoubleXYZ position;
	public byte pitch;
	public byte yaw;
	public int data;
	public Tuples.ShortXYZ velocity;

	public SpawnObject() {}

	public SpawnObject(int entityId, UUID uuid, byte type, Tuples.DoubleXYZ position, byte pitch, byte yaw, int data, Tuples.ShortXYZ velocity) {
		this.entityId = entityId;
		this.uuid = uuid;
		this.type = type;
		this.position = position;
		this.pitch = pitch;
		this.yaw = yaw;
		this.data = data;
		this.velocity = velocity;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(entityId) + position.length() + velocity.length() + 23;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeBigEndianByte(type);
		this.writeBigEndianDouble(position.x);this.writeBigEndianDouble(position.y);this.writeBigEndianDouble(position.z);
		this.writeBigEndianByte(pitch);
		this.writeBigEndianByte(yaw);
		this.writeBigEndianInt(data);
		this.writeBigEndianShort(velocity.x);this.writeBigEndianShort(velocity.y);this.writeBigEndianShort(velocity.z);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		entityId=varuint.decode(_buffer, _index);
		long bxv1awq=readBigEndianLong();long bhv1awq=readBigEndianLong();return new UUID(bxv1awq,bhv1awq);
		type=readBigEndianByte();
		position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		pitch=readBigEndianByte();
		yaw=readBigEndianByte();
		data=readBigEndianInt();
		velocity.x=readBigEndianShort(); velocity.y=readBigEndianShort(); velocity.z=readBigEndianShort();
	}

	public static SpawnObject fromBuffer(byte[] buffer) {
		SpawnObject ret = new SpawnObject();
		ret.decode(buffer);
		return ret;
	}

}
