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

public class VehicleMove extends Packet {

	public final static int ID = (int)41;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public Tuples.DoubleXYZ position;
	public float yaw;
	public float pitch;

	public VehicleMove() {}

	public VehicleMove(Tuples.DoubleXYZ position, float yaw, float pitch) {
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
	}

	@Override
	public int length() {
		return Var.Uint.length() + position.length() + 8;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianDouble(position.x);this.writeBigEndianDouble(position.y);this.writeBigEndianDouble(position.z);
		this.writeBigEndianFloat(yaw);
		this.writeBigEndianFloat(pitch);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		yaw=readBigEndianFloat();
		pitch=readBigEndianFloat();
	}

	public static VehicleMove fromBuffer(byte[] buffer) {
		VehicleMove ret = new VehicleMove();
		ret.decode(buffer);
		return ret;
	}

}
