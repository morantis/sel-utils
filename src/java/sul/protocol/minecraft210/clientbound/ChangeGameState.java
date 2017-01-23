/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import sul.utils.*;

public class ChangeGameState extends Packet {

	public final static int ID = (int)30;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// reason
	public final static byte INVALID_BED = 0;
	public final static byte END_RAINING = 1;
	public final static byte BEGIN_RAINING = 2;
	public final static byte CHANGE_GAMEMODE = 3;
	public final static byte EXIT_END = 4;
	public final static byte DEMO_MESSAGE = 5;
	public final static byte ARROW_HITTING_PLAYER = 6;
	public final static byte FADE_VALUE = 7;
	public final static byte FADE_TIME = 8;
	public final static byte PLAY_ELDER_GUARDIAN_MOB_APPEARANCE = 10;

	// value
	public final static float SURVIVAL = 0;
	public final static float CREATIVE = 1;
	public final static float ADVENTURE = 2;
	public final static float SPECTATOR = 3;
	public final static float RESPAWN_IMMEDIATELY = 0;
	public final static float RESPAWN_AFTER_CREDITS = 1;
	public final static float SHOW_DEMO_SCREEN = 0;
	public final static float TELL_MOVEMENT_CONTROLS = 101;
	public final static float TELL_JUMP_CONTROLS = 102;
	public final static float TELL_INVENTORY_CONTROLS = 103;
	public final static float BRIGHT = 0;
	public final static float DARK = 1;

	public byte reason;
	public float value;

	public ChangeGameState() {}

	public ChangeGameState(byte reason, float value) {
		this.reason = reason;
		this.value = value;
	}

	@Override
	public int length() {
		return Var.Uint.length() + 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(reason);
		this.writeBigEndianFloat(value);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		reason=readBigEndianByte();
		value=readBigEndianFloat();
	}

	public static ChangeGameState fromBuffer(byte[] buffer) {
		ChangeGameState ret = new ChangeGameState();
		ret.decode(buffer);
		return ret;
	}

}
