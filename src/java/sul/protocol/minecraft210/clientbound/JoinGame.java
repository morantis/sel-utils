/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class JoinGame extends Packet {

	public final static int ID = (int)35;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// gamemode
	public final static byte SURVIVAL = 0;
	public final static byte CREATIVE = 1;
	public final static byte ADVENTURE = 2;
	public final static byte SPECTATOR = 3;

	// dimension
	public final static int NETHER = -1;
	public final static int OVERWORLD = 0;
	public final static int END = 1;

	// difficulty
	public final static byte PEACEFUL = 0;
	public final static byte EASY = 1;
	public final static byte NORMAL = 2;
	public final static byte HARD = 3;

	// level type
	public final static String INFINITY = "default";
	public final static String FLAT = "flat";
	public final static String AMPLIFIED = "amplified";
	public final static String LARGE_BIOMES = "largeBiomes";

	public int entityId;
	public byte gamemode;
	public int dimension;
	public byte difficulty;
	public byte maxPlayers;
	public String levelType;
	public boolean reducedDebug;

	public JoinGame() {}

	public JoinGame(int entityId, byte gamemode, int dimension, byte difficulty, byte maxPlayers, String levelType, boolean reducedDebug) {
		this.entityId = entityId;
		this.gamemode = gamemode;
		this.dimension = dimension;
		this.difficulty = difficulty;
		this.maxPlayers = maxPlayers;
		this.levelType = levelType;
		this.reducedDebug = reducedDebug;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(levelType.getBytes(StandardCharsets.UTF_8).length) + levelType.getBytes(StandardCharsets.UTF_8).length + 12;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(entityId);
		this.writeBigEndianByte(gamemode);
		this.writeBigEndianInt(dimension);
		this.writeBigEndianByte(difficulty);
		this.writeBigEndianByte(maxPlayers);
		byte[] bgv2zwxuexbl=levelType.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bgv2zwxuexbl.length); this.writeBytes(bgv2zwxuexbl);
		this._buffer[this._index++]=(byte)(reducedDebug?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=readBigEndianInt();
		gamemode=readBigEndianByte();
		dimension=readBigEndianInt();
		difficulty=readBigEndianByte();
		maxPlayers=readBigEndianByte();
		int bgvubgv2zwxuexbl=this.readVaruint(); levelType=new String(this.readBytes(bgvubgv2zwxuexbl), StandardCharsets.UTF_8);
		reducedDebug=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static JoinGame fromBuffer(byte[] buffer) {
		JoinGame ret = new JoinGame();
		ret.decode(buffer);
		return ret;
	}

}
