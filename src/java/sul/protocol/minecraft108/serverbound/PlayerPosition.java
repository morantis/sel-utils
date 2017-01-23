/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.serverbound;

import sul.utils.*;

public class PlayerPosition extends Packet {

	public final static int ID = (int)12;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public Tuples.DoubleXYZ position;
	public boolean onGround;

	public PlayerPosition() {}

	public PlayerPosition(Tuples.DoubleXYZ position, boolean onGround) {
		this.position = position;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 25;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
		this._buffer[this._index++]=(byte)(onGround?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		onGround=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static PlayerPosition fromBuffer(byte[] buffer) {
		PlayerPosition ret = new PlayerPosition();
		ret.decode(buffer);
		return ret;
	}

}