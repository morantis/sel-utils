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

public class Particle extends Packet {

	public final static int ID = (int)34;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// particle id
	public final static int EXPLODE = 0;
	public final static int LARGE_EXPLOSION = 1;
	public final static int HUGE_EXPLOSION = 2;
	public final static int FIREWORK_SPARK = 3;
	public final static int BUBBLE = 4;
	public final static int SPLASH = 5;
	public final static int WAKE = 6;
	public final static int SUSPENDED = 7;
	public final static int DEPTH_SUSPEND = 8;
	public final static int CRIT = 9;
	public final static int MAGIC_CRIT = 10;
	public final static int SMOKE = 11;
	public final static int LARGE_SMOKE = 12;
	public final static int SPELL = 13;
	public final static int INSTANT_SPELL = 14;
	public final static int MOB_SPELL = 15;
	public final static int MOB_SPELL_AMBIENT = 16;
	public final static int WITCH_MAGIC = 17;
	public final static int DRIP_WATER = 18;
	public final static int DRIP_LAVA = 19;
	public final static int ANGRY_VILLAGER = 20;
	public final static int HAPPY_VILLAGER = 21;
	public final static int TOWN_AURA = 22;
	public final static int NOTE = 23;
	public final static int PORTAL = 24;
	public final static int ENCHANTMENT_TABLE = 25;
	public final static int FLAME = 26;
	public final static int LAVA = 27;
	public final static int FOOTSTEP = 28;
	public final static int CLOUD = 29;
	public final static int RED_DUST = 30;
	public final static int SNOWBALL_POOF = 31;
	public final static int SNOW_SHOVEL = 32;
	public final static int SLIME = 33;
	public final static int HEART = 34;
	public final static int BARRIER = 35;
	public final static int ITEM_CRACK = 36;
	public final static int BLOCK_CRACK = 37;
	public final static int BLOCK_DUST = 38;
	public final static int DROPLET = 39;
	public final static int TAKE = 40;
	public final static int MOB_APPEARANCE = 41;
	public final static int DRAGON_BREATH = 42;
	public final static int ENDROD = 43;
	public final static int DAMAGE_INDICATOR = 44;
	public final static int SWEEP_ATTACK = 45;

	public int particleId;
	public boolean longDistance;
	public Tuples.FloatXYZ position;
	public Tuples.FloatXYZ offset;
	public float data;
	public int count;
	public int[] additionalData = new int[2];

	public Particle() {}

	public Particle(int particleId, boolean longDistance, Tuples.FloatXYZ position, Tuples.FloatXYZ offset, float data, int count, int[] additionalData) {
		this.particleId = particleId;
		this.longDistance = longDistance;
		this.position = position;
		this.offset = offset;
		this.data = data;
		this.count = count;
		this.additionalData = additionalData;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(ID) + 37; for(int ywrkaxrpb25hberh:additionalData){ length+=Buffer.varuintLength(ywrkaxrpb25hberh); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(particleId);
		this._buffer[this._index++]=(byte)(longDistance?1:0);
		this.writeBigEndianFloat(position.x); this.writeBigEndianFloat(position.y); this.writeBigEndianFloat(position.z);
		this.writeBigEndianFloat(offset.x); this.writeBigEndianFloat(offset.y); this.writeBigEndianFloat(offset.z);
		this.writeBigEndianFloat(data);
		this.writeBigEndianInt(count);
		for(int ywrkaxrpb25hberh:additionalData){ this.writeVaruint(ywrkaxrpb25hberh); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		particleId=readBigEndianInt();
		longDistance=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
		position.x=readBigEndianFloat(); position.y=readBigEndianFloat(); position.z=readBigEndianFloat();
		offset.x=readBigEndianFloat(); offset.y=readBigEndianFloat(); offset.z=readBigEndianFloat();
		data=readBigEndianFloat();
		count=readBigEndianInt();
		final int bgfkzgl0aw9uywxe=2; additionalData=new int[bgfkzgl0aw9uywxe]; for(int ywrkaxrpb25hberh=0;ywrkaxrpb25hberh<additionalData.length;ywrkaxrpb25hberh++){ additionalData[ywrkaxrpb25hberh]=this.readVaruint(); }
	}

	public static Particle fromBuffer(byte[] buffer) {
		Particle ret = new Particle();
		ret.decode(buffer);
		return ret;
	}

}
