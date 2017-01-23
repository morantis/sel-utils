/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.serverbound;

import sul.utils.*;

public class KeepAlive extends Packet {

	public final static int ID = (int)0;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public int id;

	public KeepAlive() {}

	public KeepAlive(int id) {
		this.id = id;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(id);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(id);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		id=this.readVaruint();
	}

	public static KeepAlive fromBuffer(byte[] buffer) {
		KeepAlive ret = new KeepAlive();
		ret.decode(buffer);
		return ret;
	}

}
