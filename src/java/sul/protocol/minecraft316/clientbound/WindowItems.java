/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import sul.protocol.minecraft316.types.*;
import sul.utils.*;

public class WindowItems extends Packet {

	public final static int ID = (int)20;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public byte window;
	public Slots slots;

	public WindowItems() {}

	public WindowItems(byte window, Slots slots) {
		this.window = window;
		this.slots = slots;
	}

	@Override
	public int length() {
		return Var.Uint.length() + slots.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianShort((short)slots.length); for(Slot c2xvdhm:slots){ this.writeBytes(c2xvdhm.encode()); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		window=readBigEndianByte();
		int bhnsb3rz=readBigEndianShort(); slots=new Slot[bhnsb3rz]; for(int c2xvdhm=0;c2xvdhm<slots.length;c2xvdhm++){ slots[c2xvdhm]=new Slot(); slots[c2xvdhm]._index=this._index; slots[c2xvdhm].decode(this._buffer); this._index=slots[c2xvdhm]._index; }
	}

	public static WindowItems fromBuffer(byte[] buffer) {
		WindowItems ret = new WindowItems();
		ret.decode(buffer);
		return ret;
	}

}
