/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.clientbound;

import sul.utils.*;

public class EntityEffect extends Packet {

	public final static int ID = (int)75;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public byte effectId;
	public byte amplifier;
	public int duration;
	public boolean showParticles;

	public EntityEffect() {}

	public EntityEffect(int entityId, byte effectId, byte amplifier, int duration, boolean showParticles) {
		this.entityId = entityId;
		this.effectId = effectId;
		this.amplifier = amplifier;
		this.duration = duration;
		this.showParticles = showParticles;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + Buffer.varuintLength(duration) + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianByte(effectId);
		this.writeBigEndianByte(amplifier);
		this.writeVaruint(duration);
		this._buffer[this._index++]=(byte)(showParticles?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		effectId=readBigEndianByte();
		amplifier=readBigEndianByte();
		duration=this.readVaruint();
		showParticles=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static EntityEffect fromBuffer(byte[] buffer) {
		EntityEffect ret = new EntityEffect();
		ret.decode(buffer);
		return ret;
	}

}
