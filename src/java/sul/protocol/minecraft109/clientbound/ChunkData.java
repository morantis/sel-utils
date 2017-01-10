/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import java.util.UUID;

import sul.protocol.minecraft109.types.*;
import sul.utils.*;

class ChunkData extends Packet {

	public final static int ID = (int)32;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public Tuples.IntXZ position;
	public boolean full;
	public int sections;
	public byte[] data;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeVaruint(ID);
		this.writeIntB(position.x);this.writeIntB(position.z);
		this.writeBoolB(full);
		this.writeVaruint(sections);
		this.writeVaruint((int)data.length); for(ubyte zgf0yq:data){ this.writeByteB(zgf0yq); }
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}
