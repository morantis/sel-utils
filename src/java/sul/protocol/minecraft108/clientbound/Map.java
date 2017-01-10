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

class Map extends Packet {

	public final static int ID = (int)36;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int mapId;
	public byte scale;
	public boolean showIcons;
	public Icon[] icons;
	public byte colums;
	public byte rows;
	public Tuples.ByteXZ offset;
	public byte[] data;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeVaruint(ID);
		this.writeVaruint(mapId);
		this.writeByteB(scale);
		this.writeBoolB(showIcons);
		this.writeVaruint((int)icons.length); for(icon awnvbnm:icons){ this.writeBytes(awnvbnm.encode()); }
		this.writeByteB(colums);
		this.writeByteB(rows);
		this.writeByteB(offset.x);this.writeByteB(offset.z);
		this.writeVaruint((int)data.length); for(ubyte zgf0yq:data){ this.writeByteB(zgf0yq); }
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}
