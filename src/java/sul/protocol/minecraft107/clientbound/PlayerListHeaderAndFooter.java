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

class PlayerListHeaderAndFooter extends Packet {

	public final static int ID = (int)72;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String header;
	public String footer;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeVaruint(ID);
		byte[] agvhzgvy=header.getBytes("UTF-8"); this.writeVaruint((int)agvhzgvy.length); this.writeBytes(agvhzgvy);
		byte[] zm9vdgvy=footer.getBytes("UTF-8"); this.writeVaruint((int)zm9vdgvy.length); this.writeBytes(zm9vdgvy);
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}
