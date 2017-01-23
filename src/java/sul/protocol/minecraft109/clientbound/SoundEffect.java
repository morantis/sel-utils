/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import sul.utils.*;

public class SoundEffect extends Packet {

	public final static int ID = (int)71;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int soundId;
	public int category;
	public Tuples.IntXYZ position;
	public float volume;
	public byte pitch;

	public SoundEffect() {}

	public SoundEffect(int soundId, int category, Tuples.IntXYZ position, float volume, byte pitch) {
		this.soundId = soundId;
		this.category = category;
		this.position = position;
		this.volume = volume;
		this.pitch = pitch;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(soundId) + Buffer.varuintLength(category) + 17;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(soundId);
		this.writeVaruint(category);
		this.writeBigEndianInt(position.x); this.writeBigEndianInt(position.y); this.writeBigEndianInt(position.z);
		this.writeBigEndianFloat(volume);
		this.writeBigEndianByte(pitch);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		soundId=this.readVaruint();
		category=this.readVaruint();
		position.x=readBigEndianInt(); position.y=readBigEndianInt(); position.z=readBigEndianInt();
		volume=readBigEndianFloat();
		pitch=readBigEndianByte();
	}

	public static SoundEffect fromBuffer(byte[] buffer) {
		SoundEffect ret = new SoundEffect();
		ret.decode(buffer);
		return ret;
	}

}
