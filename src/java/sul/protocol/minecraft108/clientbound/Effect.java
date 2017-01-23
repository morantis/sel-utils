/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import sul.utils.*;

public class Effect extends Packet {

	public final static int ID = (int)33;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// effect id
	public final static int DISPENSER_DISPENSE = 1000;
	public final static int DISPENSER_FAIL_DISPENSE = 1001;
	public final static int DISPENSER_SHOOT = 1002;
	public final static int DOOR_OPEN_OR_CLOSE = 1003;
	public final static int FIREWORK_SHOT = 1004;
	public final static int PLAY_DISC = 1005;
	public final static int GHAST_WARN = 1007;
	public final static int GHAST_SHOOT = 1008;
	public final static int ZOMBIE_ATTACK_WOOD_DOOR = 1010;
	public final static int ZOMBIE_ATTACK_IRON_DOOR = 1011;
	public final static int ZOMBIE_BREAK_WOOD_DOOR = 1012;
	public final static int WITHER_SPAWN = 1013;
	public final static int WITHER_SHOOT = 1014;
	public final static int BAT_TAKE_OFF = 1015;
	public final static int ZOMBIE_INFECT_VILLAGER = 1016;
	public final static int ZOMBIE_VILLAGER_CONVERT = 1017;
	public final static int ANVIL_BREAK = 1019;
	public final static int ANVIL_USE = 1020;
	public final static int ANVIL_LAND = 1021;
	public final static int SPAWN_10_SMOKE_PARTICLES = 2000;
	public final static int BREAK_BREAK_PARTICLES = 2001;
	public final static int SPLASH_POTION_PARTICLES_AND_SOUND = 2002;
	public final static int ENDER_EYE_BREAK_PARTICLES_AND_SOUND = 2003;
	public final static int MOB_SPAWN_PARTICLES = 2004;
	public final static int BONEMEAL_PARTICLES = 2005;

	public int effectId;
	public long position;
	public int data;
	public boolean disableVolume;

	public Effect() {}

	public Effect(int effectId, long position, int data, boolean disableVolume) {
		this.effectId = effectId;
		this.position = position;
		this.data = data;
		this.disableVolume = disableVolume;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 17;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(effectId);
		this.writeBigEndianLong(position);
		this.writeBigEndianInt(data);
		this._buffer[this._index++]=(byte)(disableVolume?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		effectId=readBigEndianInt();
		position=readBigEndianLong();
		data=readBigEndianInt();
		disableVolume=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static Effect fromBuffer(byte[] buffer) {
		Effect ret = new Effect();
		ret.decode(buffer);
		return ret;
	}

}
