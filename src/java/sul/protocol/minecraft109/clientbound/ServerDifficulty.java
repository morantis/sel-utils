/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import sul.utils.*;

public class ServerDifficulty extends Packet {

	public final static int ID = (int)13;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// difficulty
	public final static byte PEACEFUL = 0;
	public final static byte EASY = 1;
	public final static byte NORMAL = 2;
	public final static byte HARD = 3;

	public byte difficulty;

	public ServerDifficulty() {}

	public ServerDifficulty(byte difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(difficulty);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		difficulty=readBigEndianByte();
	}

	public static ServerDifficulty fromBuffer(byte[] buffer) {
		ServerDifficulty ret = new ServerDifficulty();
		ret.decode(buffer);
		return ret;
	}

}
