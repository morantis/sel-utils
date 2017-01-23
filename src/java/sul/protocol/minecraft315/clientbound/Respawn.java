/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Respawn extends Packet {

	public final static int ID = (int)51;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// dimension
	public final static int NETHER = -1;
	public final static int OVERWORLD = 0;
	public final static int END = 1;

	// difficulty
	public final static byte PEACEFUL = 0;
	public final static byte EASY = 1;
	public final static byte NORMAL = 2;
	public final static byte HARD = 3;

	// gamemode
	public final static byte SURVIVAL = 0;
	public final static byte CREATIVE = 1;
	public final static byte ADVENTURE = 2;
	public final static byte SPECTATOR = 3;

	// level type
	public final static String INFINITY = "default";
	public final static String FLAT = "flat";
	public final static String AMPLIFIED = "amplified";
	public final static String LARGE_BIOMES = "largeBiomes";

	public int dimension;
	public byte difficulty;
	public byte gamemode;
	public String levelType;

	public Respawn() {}

	public Respawn(int dimension, byte difficulty, byte gamemode, String levelType) {
		this.dimension = dimension;
		this.difficulty = difficulty;
		this.gamemode = gamemode;
		this.levelType = levelType;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(levelType.getBytes(StandardCharsets.UTF_8).length) + levelType.getBytes(StandardCharsets.UTF_8).length + 6;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(dimension);
		this.writeBigEndianByte(difficulty);
		this.writeBigEndianByte(gamemode);
		byte[] bgv2zwxuexbl=levelType.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bgv2zwxuexbl.length); this.writeBytes(bgv2zwxuexbl);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		dimension=readBigEndianInt();
		difficulty=readBigEndianByte();
		gamemode=readBigEndianByte();
		int bgvubgv2zwxuexbl=this.readVaruint(); levelType=new String(this.readBytes(bgvubgv2zwxuexbl), StandardCharsets.UTF_8);
	}

	public static Respawn fromBuffer(byte[] buffer) {
		Respawn ret = new Respawn();
		ret.decode(buffer);
		return ret;
	}

}
