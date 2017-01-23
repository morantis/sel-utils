/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.serverbound;

import sul.utils.*;

public class SteerBoat extends Packet {

	public final static int ID = (int)17;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public boolean rightPaddleTurning;
	public boolean leftPaddleTurning;

	public SteerBoat() {}

	public SteerBoat(boolean rightPaddleTurning, boolean leftPaddleTurning) {
		this.rightPaddleTurning = rightPaddleTurning;
		this.leftPaddleTurning = leftPaddleTurning;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this._buffer[this._index++]=(byte)(rightPaddleTurning?1:0);
		this._buffer[this._index++]=(byte)(leftPaddleTurning?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		rightPaddleTurning=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
		leftPaddleTurning=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static SteerBoat fromBuffer(byte[] buffer) {
		SteerBoat ret = new SteerBoat();
		ret.decode(buffer);
		return ret;
	}

}