/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class SoundEffect extends Packet {

	public final static int ID = (int)41;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String soundName;
	public Tuples.IntXYZ position;
	public float volume;
	public byte pitch;

	public SoundEffect() {}

	public SoundEffect(String soundName, Tuples.IntXYZ position, float volume, byte pitch) {
		this.soundName = soundName;
		this.position = position;
		this.volume = volume;
		this.pitch = pitch;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(soundName.getBytes(StandardCharsets.UTF_8).length) + soundName.getBytes(StandardCharsets.UTF_8).length + 17;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] c291bmroyw1l=soundName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c291bmroyw1l.length); this.writeBytes(c291bmroyw1l);
		this.writeBigEndianInt(position.x); this.writeBigEndianInt(position.y); this.writeBigEndianInt(position.z);
		this.writeBigEndianFloat(volume);
		this.writeBigEndianByte(pitch);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bgvuc291bmroyw1l=this.readVaruint(); soundName=new String(this.readBytes(bgvuc291bmroyw1l), StandardCharsets.UTF_8);
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