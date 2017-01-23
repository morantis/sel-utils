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

public class InventoryAction extends Packet {

	public final static byte ID = (byte)47;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public int action;
	public sul.protocol.pocket100.types.Slot item;

	public InventoryAction() {}

	public InventoryAction(int action, sul.protocol.pocket100.types.Slot item) {
		this.action = action;
		this.item = item;
	}

	@Override
	public int length() {
		return Buffer.varintLength(action) + item.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(action);
		this.writeBytes(item.encode());
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		action=this.readVarint();
		item=new sul.protocol.pocket100.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
	}

	public static InventoryAction fromBuffer(byte[] buffer) {
		InventoryAction ret = new InventoryAction();
		ret.decode(buffer);
		return ret;
	}

}
