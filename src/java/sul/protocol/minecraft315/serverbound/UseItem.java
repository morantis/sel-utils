/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.serverbound;

import sul.utils.*;

public class UseItem extends Packet {

	public final static int ID = (int)29;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// hand
	public final static int MAIN_HAND = 0;
	public final static int OFF_HAND = 1;

	public int hand;

	public UseItem() {}

	public UseItem(int hand) {
		this.hand = hand;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(hand);
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
		this.readVaruint();
		hand=this.readVaruint();
	}

	public static UseItem fromBuffer(byte[] buffer) {
		UseItem ret = new UseItem();
		ret.decode(buffer);
		return ret;
	}

}
