/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import java.util.UUID;

import sul.protocol.minecraft108.types.*;
import sul.utils.*;

class OpenWindow extends Packet {

	public final static int ID = (int)19;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public byte window;
	public String type;
	public String title;
	public byte slots;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeVaruint(ID);
		this.writeByteB(window);
		byte[] dhlwzq=type.getBytes("UTF-8"); this.writeVaruint((int)dhlwzq.length); this.writeBytes(dhlwzq);
		byte[] dgl0bgu=title.getBytes("UTF-8"); this.writeVaruint((int)dgl0bgu.length); this.writeBytes(dgl0bgu);
		this.writeByteB(slots);
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}
