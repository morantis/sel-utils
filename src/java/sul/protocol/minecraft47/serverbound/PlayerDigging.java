/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.serverbound;

import sul.utils.*;

public class PlayerDigging extends Packet {

	public final static int ID = (int)7;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// status
	public final static byte START_DIGGING = 0;
	public final static byte CANCEL_DIGGING = 1;
	public final static byte FINISH_DIGGING = 2;
	public final static byte DROP_ITEM_STACK = 3;
	public final static byte DROP_ITEM = 4;
	public final static byte SHOOT_ARROW = 5;
	public final static byte FINISH_EATING = 5;

	public byte status;
	public long position;
	public byte face;

	public PlayerDigging() {}

	public PlayerDigging(byte status, long position, byte face) {
		this.status = status;
		this.position = position;
		this.face = face;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(status);
		this.writeBigEndianLong(position);
		this.writeBigEndianByte(face);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		status=readBigEndianByte();
		position=readBigEndianLong();
		face=readBigEndianByte();
	}

	public static PlayerDigging fromBuffer(byte[] buffer) {
		PlayerDigging ret = new PlayerDigging();
		ret.decode(buffer);
		return ret;
	}

}
