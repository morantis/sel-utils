/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.serverbound;

import sul.utils.*;

public class Animation extends Packet {

	public final static int ID = (int)26;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// hand
	public final static int MAIN_HAND = 0;
	public final static int OFF_HAND = 1;

	public int hand;

	public Animation() {}

	public Animation(int hand) {
		this.hand = hand;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(hand);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(hand);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		hand=varuint.decode(_buffer, _index);
	}

	public static Animation fromBuffer(byte[] buffer) {
		Animation ret = new Animation();
		ret.decode(buffer);
		return ret;
	}

}
