/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.serverbound;

import sul.utils.*;

public class ClientStatus extends Packet {

	public final static int ID = (int)3;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// action
	public final static int RESPAWN = 0;
	public final static int REQUEST_STATS = 1;
	public final static int OPEN_INVENTORY = 2;

	public int action;

	public ClientStatus() {}

	public ClientStatus(int action) {
		this.action = action;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(action);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(action);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		action=varuint.decode(_buffer, _index);
	}

	public static ClientStatus fromBuffer(byte[] buffer) {
		ClientStatus ret = new ClientStatus();
		ret.decode(buffer);
		return ret;
	}

}
