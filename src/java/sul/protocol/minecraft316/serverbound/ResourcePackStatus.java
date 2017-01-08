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

class ResourcePackStatus extends Packet {

	public final static int ID = (int)22;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// result
	public final static int LOADED = (int)0;
	public final static int DECLINED = (int)1;
	public final static int FAILED = (int)2;
	public final static int ACCEPTED = (int)3;

	public int result;

	@Override
	public int length() {
		return Var.Uint.length(result);
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
