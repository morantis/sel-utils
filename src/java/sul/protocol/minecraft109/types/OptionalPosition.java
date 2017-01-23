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

public class OptionalPosition extends Packet {

	public boolean hasPosition;
	public long position;

	public OptionalPosition() {}

	public OptionalPosition(boolean hasPosition, long position) {
		this.hasPosition = hasPosition;
		this.position = position;
	}

	@Override
	public int length() {
		return 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this._buffer[this._index++]=(byte)(hasPosition?1:0);
		if(has_position==true){ this.writeBigEndianLong(position); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		hasPosition=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
		if(has_position==true){ position=readBigEndianLong(); }
	}


}
