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

public class CollectItem extends Packet {

	public final static int ID = (int)73;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int collected;
	public int collector;

	public CollectItem() {}

	public CollectItem(int collected, int collector) {
		this.collected = collected;
		this.collector = collector;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(collected) + Var.Uint.length(collector);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(collected);
		this.writeVaruint(collector);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		collected=varuint.decode(_buffer, _index);
		collector=varuint.decode(_buffer, _index);
	}

	public static CollectItem fromBuffer(byte[] buffer) {
		CollectItem ret = new CollectItem();
		ret.decode(buffer);
		return ret;
	}

}
