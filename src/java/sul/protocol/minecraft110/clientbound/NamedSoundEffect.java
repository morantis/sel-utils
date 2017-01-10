/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.clientbound;

import java.util.UUID;

import sul.protocol.minecraft110.types.*;
import sul.utils.*;

class NamedSoundEffect extends Packet {

	public final static int ID = (int)25;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String name;
	public int category;
	public Tuples.IntXYZ position;
	public float volume;
	public byte pitch;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeVaruint(ID);
		byte[] bmftzq=name.getBytes("UTF-8"); this.writeVaruint((int)bmftzq.length); this.writeBytes(bmftzq);
		this.writeVaruint(category);
		this.writeIntB(position.x);this.writeIntB(position.y);this.writeIntB(position.z);
		this.writeFloatB(volume);
		this.writeByteB(pitch);
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}
