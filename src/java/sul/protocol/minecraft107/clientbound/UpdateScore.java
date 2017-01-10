/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import java.util.UUID;

import sul.protocol.minecraft107.types.*;
import sul.utils.*;

class UpdateScore extends Packet {

	public final static int ID = (int)66;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// action
	public static immutable byte UPDATE = 0;
	public static immutable byte REMOVE = 1;

	public String scoreName;
	public byte action;
	public String objectiveName;
	public int value;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeVaruint(ID);
		byte[] c2nvcmvoyw1l=scoreName.getBytes("UTF-8"); this.writeVaruint((int)c2nvcmvoyw1l.length); this.writeBytes(c2nvcmvoyw1l);
		this.writeByteB(action);
		byte[] b2jqzwn0axzltmft=objectiveName.getBytes("UTF-8"); this.writeVaruint((int)b2jqzwn0axzltmft.length); this.writeBytes(b2jqzwn0axzltmft);
		if(action==0){ this.writeVaruint(value); }
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}
