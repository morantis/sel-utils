/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class MobEffect extends Packet {

	public final static byte ID = (byte)30;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// event id
	public final static byte ADD = 1;
	public final static byte MODIFY = 2;
	public final static byte REMOVE = 3;

	public long entityId;
	public byte eventId;
	public int effect;
	public int amplifier;
	public boolean particles;
	public int duration;

	public MobEffect() {}

	public MobEffect(long entityId, byte eventId, int effect, int amplifier, boolean particles, int duration) {
		this.entityId = entityId;
		this.eventId = eventId;
		this.effect = effect;
		this.amplifier = amplifier;
		this.particles = particles;
		this.duration = duration;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varintLength(effect) + Buffer.varintLength(amplifier) + Buffer.varintLength(duration) + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeBigEndianByte(eventId);
		this.writeVarint(effect);
		this.writeVarint(amplifier);
		this._buffer[this._index++]=(byte)(particles?1:0);
		this.writeVarint(duration);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		eventId=readBigEndianByte();
		effect=this.readVarint();
		amplifier=this.readVarint();
		particles=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
		duration=this.readVarint();
	}

	public static MobEffect fromBuffer(byte[] buffer) {
		MobEffect ret = new MobEffect();
		ret.decode(buffer);
		return ret;
	}

}
