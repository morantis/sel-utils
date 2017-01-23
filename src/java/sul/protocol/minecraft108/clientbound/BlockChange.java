/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import sul.utils.*;

public class BlockChange extends Packet {

	public final static int ID = (int)11;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public long position;
	public int block;

	public BlockChange() {}

	public BlockChange(long position, int block) {
		this.position = position;
		this.block = block;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(block) + 8;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		this.writeVaruint(block);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		position=readBigEndianLong();
		block=varuint.decode(_buffer, _index);
	}

	public static BlockChange fromBuffer(byte[] buffer) {
		BlockChange ret = new BlockChange();
		ret.decode(buffer);
		return ret;
	}

}
