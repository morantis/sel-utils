/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.serverbound;

import sul.utils.*;

public class PlayerBlockPlacement extends Packet {

	public final static int ID = (int)28;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// hand
	public final static int MAIN_HAND = 0;
	public final static int OFF_HAND = 1;

	public long position;
	public int face;
	public int hand;
	public Tuples.ByteXYZ cursorPosition;

	public PlayerBlockPlacement() {}

	public PlayerBlockPlacement(long position, int face, int hand, Tuples.ByteXYZ cursorPosition) {
		this.position = position;
		this.face = face;
		this.hand = hand;
		this.cursorPosition = cursorPosition;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(face) + Buffer.varuintLength(hand) + 11;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		this.writeVaruint(face);
		this.writeVaruint(hand);
		this.writeBigEndianByte(cursorPosition.x); this.writeBigEndianByte(cursorPosition.y); this.writeBigEndianByte(cursorPosition.z);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianLong();
		face=this.readVaruint();
		hand=this.readVaruint();
		cursorPosition.x=readBigEndianByte(); cursorPosition.y=readBigEndianByte(); cursorPosition.z=readBigEndianByte();
	}

	public static PlayerBlockPlacement fromBuffer(byte[] buffer) {
		PlayerBlockPlacement ret = new PlayerBlockPlacement();
		ret.decode(buffer);
		return ret;
	}

}
