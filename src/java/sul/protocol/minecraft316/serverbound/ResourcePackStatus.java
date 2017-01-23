/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.serverbound;

import sul.utils.*;

public class ResourcePackStatus extends Packet {

	public final static int ID = (int)22;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// result
	public final static int LOADED = 0;
	public final static int DECLINED = 1;
	public final static int FAILED = 2;
	public final static int ACCEPTED = 3;

	public int result;

	public ResourcePackStatus() {}

	public ResourcePackStatus(int result) {
		this.result = result;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(result);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(result);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		result=this.readVaruint();
	}

	public static ResourcePackStatus fromBuffer(byte[] buffer) {
		ResourcePackStatus ret = new ResourcePackStatus();
		ret.decode(buffer);
		return ret;
	}

}
