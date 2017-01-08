/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.serverbound;

import java.util.UUID;

import sul.protocol.minecraft316.types.*;
import sul.utils.*;

class KeepAlive extends Packet {

	public final static int ID = (int)11;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public int id;

	@Override
	public int length() {
		return Var.Uint.length(id);
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
