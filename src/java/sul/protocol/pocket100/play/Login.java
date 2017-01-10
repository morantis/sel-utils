/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.util.UUID;

import sul.protocol.pocket100.types.*;
import sul.utils.*;

class Login extends Packet {

	public final static byte ID = (byte)1;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// edition
	public static immutable byte CLASSIC = 0;
	public static immutable byte EDUCATION = 1;

	public int protocol;
	public byte edition;
	public byte[] body;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeByteB(ID);
		this.writeIntB(protocol);
		this.writeByteB(edition);
		this.writeVaruint((int)body.length); for(ubyte ym9keq:body){ this.writeByteB(ym9keq); }
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}
