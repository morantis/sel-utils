/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.protocol.pocket100.types.*;
import sul.utils.*;

public class RemoveBlock extends Packet {

	public final static byte ID = (byte)22;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public BlockPosition position;

	public RemoveBlock() {}

	public RemoveBlock(BlockPosition position) {
		this.position = position;
	}

	@Override
	public int length() {
		return position.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(position.encode());
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		position=new BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
	}

	public static RemoveBlock fromBuffer(byte[] buffer) {
		RemoveBlock ret = new RemoveBlock();
		ret.decode(buffer);
		return ret;
	}

}
