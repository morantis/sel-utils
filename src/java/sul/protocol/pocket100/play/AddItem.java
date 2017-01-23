/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class AddItem extends Packet {

	public final static byte ID = (byte)74;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public sul.protocol.pocket100.types.Slot item;

	public AddItem() {}

	public AddItem(sul.protocol.pocket100.types.Slot item) {
		this.item = item;
	}

	@Override
	public int length() {
		return item.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(item.encode());
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		item=new sul.protocol.pocket100.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
	}

	public static AddItem fromBuffer(byte[] buffer) {
		AddItem ret = new AddItem();
		ret.decode(buffer);
		return ret;
	}

}
