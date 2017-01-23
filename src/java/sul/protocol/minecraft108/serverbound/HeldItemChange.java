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

public class HeldItemChange extends Packet {

	public final static int ID = (int)23;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public short slot;

	public HeldItemChange() {}

	public HeldItemChange(short slot) {
		this.slot = slot;
	}

	@Override
	public int length() {
		return Var.Uint.length() + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianShort(slot);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		slot=readBigEndianShort();
	}

	public static HeldItemChange fromBuffer(byte[] buffer) {
		HeldItemChange ret = new HeldItemChange();
		ret.decode(buffer);
		return ret;
	}

}
