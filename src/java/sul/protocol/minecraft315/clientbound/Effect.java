/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import sul.utils.*;

public class Effect extends Packet {

	public final static int ID = (int)33;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// effect id
	public final static int DISPENSER_DISPENSE = 1000;
	public final static int DISPENSER_FAIL_DISPENSE = 1001;
	public final static int DISPENSER_SHOOT = 1002;
	public final static int ENDER_EYE_LAUNCH = 1003;
	public final static int FIREWORK_SHOT = 1004;
	public final static int IRON_DOOR_OPEN = 1005;
	public final static int WOODEN_DOOR_OPEN = 1006;
	public final static int WOODEN_TRAPDOOR_OPEN = 1007;
	public final static int FENCE_GATE_OPEN = 1008;
	public final static int FIRE_EXTINGUISH = 1009;
	public final static int PLAY_RECORD = 1010;
	public final static int IRON_DOOR_CLOSE = 1011;
	public final static int WOODEN_DOOR_CLOSE = 1012;
	public final static int WOODEN_TRAPDOOR_CLOSE = 1013;
	public final static int FENCE_GATE_CLOSE = 1014;
	public final static int GHAST_WARN = 1015;
	public final static int GHAST_SHOOT = 1016;
	public final static int ENDERDRAGON_SHOOT = 1017;
	public final static int BLAZE_SHOOT = 1018;
	public final static int ZOMBIE_ATTACK_WOOD_DOOR = 1019;
	public final static int ZOMBIE_ATTACK_IRON_DOOR = 1020;
	public final static int ZOMBIE_BREAK_WOOD_DOOR = 1021;
	public final static int WITHER_BREAK_BLOCK = 1022;
	public final static int WITHER_SPAWN = 1023;
	public final static int WITHER_SHOOT = 1024;
	public final static int BAT_TAKE_OFF = 1025;
	public final static int ZOMBIE_INFECT_VILLAGER = 1026;
	public final static int ZOMBIE_VILLAGER_CONVERT = 1027;
	public final static int ENDER_DRAGON_BREATH = 1028;
	public final static int ANVIL_BREAK = 1029;
	public final static int ANVIL_USE = 1030;
	public final static int ANVIL_LAND = 1031;
	public final static int PORTAL_TRAVEL = 1032;
	public final static int CHORUS_FLOWER_GROW = 1033;
	public final static int CHORUS_FLOWER_DIE = 1034;
	public final static int BREWING_STAND_BREW = 1035;
	public final static int IRON_TRAPDOOR_OPEN = 1036;
	public final static int IRON_TRAPDOOR_CLOSE = 1037;
	public final static int SPAWN_10_SMOKE_PARTICLES = 2000;
	public final static int BREAK_BREAK_PARTICLES_AND_SOUND = 2001;
	public final static int SPLASH_POTION_PARTICLES_AND_SOUND = 2002;
	public final static int ENDER_EYE_BREAK_PARTICLES_AND_SOUND = 2003;
	public final static int MOB_SPAWN_PARTICLES = 2004;
	public final static int BONEMEAL_PARTICLES = 2005;
	public final static int DRAGON_BREATH = 2006;
	public final static int END_GATEWAY_SPAWN = 3000;
	public final static int ENDERDRAGON_GROWL = 3001;

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
		return Var.Uint.length() + 17;
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
		varuint.decode(_buffer, _index);
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
