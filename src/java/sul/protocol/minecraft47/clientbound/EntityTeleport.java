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

public class EntityTeleport extends Packet {

	public final static int ID = (int)24;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public Tuples.IntXYZ position;
	public byte yaw;
	public byte pitch;
	public boolean onGround;

	public EntityTeleport() {}

	public EntityTeleport(int entityId, Tuples.IntXYZ position, byte yaw, byte pitch, boolean onGround) {
		this.entityId = entityId;
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + 15;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianInt(position.x); this.writeBigEndianInt(position.y); this.writeBigEndianInt(position.z);
		this.writeBigEndianByte(yaw);
		this.writeBigEndianByte(pitch);
		this._buffer[this._index++]=(byte)(onGround?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		position.x=readBigEndianInt(); position.y=readBigEndianInt(); position.z=readBigEndianInt();
		yaw=readBigEndianByte();
		pitch=readBigEndianByte();
		onGround=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static EntityTeleport fromBuffer(byte[] buffer) {
		EntityTeleport ret = new EntityTeleport();
		ret.decode(buffer);
		return ret;
	}

}
