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

public class PlayerPositionAndLook extends Packet {

	public final static int ID = (int)46;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// flags
	public final static byte X = 1;
	public final static byte Y = 2;
	public final static byte Z = 4;
	public final static byte Y_ROTATION = 8;
	public final static byte X_ROTATION = 16;

	public Tuples.DoubleXYZ position;
	public float yaw;
	public float pitch;
	public byte flags;
	public int teleportId;

	public PlayerPositionAndLook() {}

	public PlayerPositionAndLook(Tuples.DoubleXYZ position, float yaw, float pitch, byte flags, int teleportId) {
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
		this.flags = flags;
		this.teleportId = teleportId;
	}

	@Override
	public int length() {
		return Var.Uint.length() + position.length() + Var.Uint.length(teleportId) + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianDouble(position.x);this.writeBigEndianDouble(position.y);this.writeBigEndianDouble(position.z);
		this.writeBigEndianFloat(yaw);
		this.writeBigEndianFloat(pitch);
		this.writeBigEndianByte(flags);
		this.writeVaruint(teleportId);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		yaw=readBigEndianFloat();
		pitch=readBigEndianFloat();
		flags=readBigEndianByte();
		teleportId=varuint.decode(_buffer, _index);
	}

	public static PlayerPositionAndLook fromBuffer(byte[] buffer) {
		PlayerPositionAndLook ret = new PlayerPositionAndLook();
		ret.decode(buffer);
		return ret;
	}

}
