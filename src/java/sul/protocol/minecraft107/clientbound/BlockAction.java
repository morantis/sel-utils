/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import sul.utils.*;

public class BlockAction extends Packet {

	public final static int ID = (int)10;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// action
	public final static byte NOTE_BLOCK_HARP = 0;
	public final static byte NOTE_BLOCK_BASS_DRUM = 1;
	public final static byte NOTE_BLOCK_SNARE_DRUM = 2;
	public final static byte NOTE_BLOCK_CLICKS = 3;
	public final static byte NOTE_BLOCK_STICKS = 3;
	public final static byte NOTE_BLOCK_BASS_GUITAR = 4;
	public final static byte PISTON_EXTEND = 0;
	public final static byte PISTON_RETRACT = 1;
	public final static byte CHEST_WATCHERS = 1;
	public final static byte BEACON_RECALCULATE = 1;
	public final static byte MOB_SPAWNER_RESET_DELAY = 1;
	public final static byte END_GATEWAY_YELLOW_BEAM = 1;

	// parameter
	public final static byte PISTON_DOWN = 0;
	public final static byte PISTON_UP = 1;
	public final static byte PISTON_SOUTH = 2;
	public final static byte PISTON_WEST = 3;
	public final static byte PISTON_NORTH = 4;
	public final static byte PISTON_EAST = 5;

	public long position;
	public byte action;
	public byte parameter;
	public int blockType;

	public BlockAction() {}

	public BlockAction(long position, byte action, byte parameter, int blockType) {
		this.position = position;
		this.action = action;
		this.parameter = parameter;
		this.blockType = blockType;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(blockType) + 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		this.writeBigEndianByte(action);
		this.writeBigEndianByte(parameter);
		this.writeVaruint(blockType);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		position=readBigEndianLong();
		action=readBigEndianByte();
		parameter=readBigEndianByte();
		blockType=varuint.decode(_buffer, _index);
	}

	public static BlockAction fromBuffer(byte[] buffer) {
		BlockAction ret = new BlockAction();
		ret.decode(buffer);
		return ret;
	}

}
