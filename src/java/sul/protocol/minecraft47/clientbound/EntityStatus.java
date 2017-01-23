/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.clientbound;

import sul.utils.*;

public class EntityStatus extends Packet {

	public final static int ID = (int)26;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// status
	public final static byte SPAWN_TIPPED_ARROW_PARTICLE_EFFECTS = 0;
	public final static byte PLAY_JUMPING_ANIMATION_AND_PARTICLES = 1;
	public final static byte RESET_SPAWNER_DELAY = 1;
	public final static byte PLAY_HURT_ANIMATION_AND_SOUND = 2;
	public final static byte PLAY_DEATH_ANIMATION_AND_SOUND = 3;
	public final static byte PLAY_ATTACK_ANIMATION_AND_SOUND = 4;
	public final static byte SPAWN_SMOKE_PARTICLES = 6;
	public final static byte SPAWN_HEART_PARTICLES = 7;
	public final static byte PLAY_SHAKING_WATER_ANIMATION = 8;
	public final static byte FINISHED_CONSUMING = 9;
	public final static byte PLAY_EATING_GRASS_ANIMATION = 10;
	public final static byte IGNITE_MINECART_TNT = 10;
	public final static byte HOLD_POPPY = 11;
	public final static byte SPAWN_VILLAGER_MATING_HEART_PARTICLES = 12;
	public final static byte SPAWN_VILLAGER_ANGRY_PARTICLES = 13;
	public final static byte SPAWN_VILLAGER_HAPPY_PARTICLES = 14;
	public final static byte SPAWN_WITCH_MAGIC_PARTICLES = 15;
	public final static byte PLAY_ZOMBIE_CURE_FINISHED_SOUND = 16;
	public final static byte SPAWN_FIREWORK_EXPLOSION_EFFECT = 17;
	public final static byte SPAWN_LOVE_PARTICLES = 18;
	public final static byte RESET_SQUID_ROTATION = 19;
	public final static byte SPAWN_EXPLOSION_PARTICLES = 20;
	public final static byte PLAY_GUARDIAN_SOUND_EFFECT = 21;
	public final static byte ENABLE_REDUCED_DEBUG_SCREEN = 22;
	public final static byte DISABLE_REDUCED_DEBUG_SCREEN = 23;

	public int entityId;
	public byte status;

	public EntityStatus() {}

	public EntityStatus(int entityId, byte status) {
		this.entityId = entityId;
		this.status = status;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(entityId);
		this.writeBigEndianByte(status);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=readBigEndianInt();
		status=readBigEndianByte();
	}

	public static EntityStatus fromBuffer(byte[] buffer) {
		EntityStatus ret = new EntityStatus();
		ret.decode(buffer);
		return ret;
	}

}
