/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.types;

import sul.utils.*;

public class Icon extends Packet {

	// direction and type
	public final static byte WHITE_ARROW = 0;
	public final static byte GREEN_ARROW = 1;
	public final static byte RED_ARROW = 2;
	public final static byte BLUE_ARROW = 3;
	public final static byte WHITE_CROSS = 4;
	public final static byte RED_POINTER = 5;
	public final static byte WHITE_CIRCLE = 6;

	public byte directionAndType;
	public Tuples.ByteXZ position;

	public Icon() {}

	public Icon(byte directionAndType, Tuples.ByteXZ position) {
		this.directionAndType = directionAndType;
		this.position = position;
	}

	@Override
	public int length() {
		return 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(directionAndType);
		this.writeBigEndianByte(position.x); this.writeBigEndianByte(position.z);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		directionAndType=readBigEndianByte();
		position.x=readBigEndianByte(); position.z=readBigEndianByte();
	}


}
