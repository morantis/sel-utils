/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import sul.utils.*;

public class OpenSignEditor extends Packet {

	public final static int ID = (int)42;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public long position;

	public OpenSignEditor() {}

	public OpenSignEditor(long position) {
		this.position = position;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 8;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianLong();
	}

	public static OpenSignEditor fromBuffer(byte[] buffer) {
		OpenSignEditor ret = new OpenSignEditor();
		ret.decode(buffer);
		return ret;
	}

}
