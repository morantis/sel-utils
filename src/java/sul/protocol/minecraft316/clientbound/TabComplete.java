/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import java.util.UUID;

import sul.protocol.minecraft316.types.*;
import sul.utils.*;

class TabComplete extends Packet {

	public final static int ID = (int)14;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String[] matches;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeVaruint(ID);
		this.writeVaruint((int)matches.length); for(string bwf0y2hlcw:matches){ byte[] yndmmhkyagxjdw=bwf0y2hlcw.getBytes("UTF-8"); this.writeVaruint((int)yndmmhkyagxjdw.length); this.writeBytes(yndmmhkyagxjdw); }
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}
