/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.protocol.pocket100.types.*;
import sul.utils.*;

public class PlayerAction extends Packet {

	public final static byte ID = (byte)36;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// action
	public final static int START_BREAK = 0;
	public final static int ABORT_BREAK = 1;
	public final static int STOP_BREAK = 2;
	public final static int RELEASE_ITEM = 5;
	public final static int STOP_SLEEPING = 6;
	public final static int RESPAWN = 7;
	public final static int JUMP = 8;
	public final static int START_SPRINT = 9;
	public final static int STOP_SPRINT = 10;
	public final static int START_SNEAK = 11;
	public final static int STOP_SNEAK = 12;
	public final static int DIMENSION_CHANGE = 13;
	public final static int ABORT_DIMENSION_CHANGE = 14;
	public final static int START_GLIDING = 15;
	public final static int STOP_GLIDING = 16;

	public long entityId;
	public int action;
	public BlockPosition position;
	public int face;

	public PlayerAction() {}

	public PlayerAction(long entityId, int action, BlockPosition position, int face) {
		this.entityId = entityId;
		this.action = action;
		this.position = position;
		this.face = face;
	}

	@Override
	public int length() {
		return Var.Long.length(entityId) + Var.Int.length(action) + position.length() + Var.Int.length(face) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeVarint(action);
		this.writeBytes(position.encode());
		this.writeVarint(face);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=varlong.decode(_buffer, _index);
		action=varint.decode(_buffer, _index);
		position=new BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
		face=varint.decode(_buffer, _index);
	}

	public static PlayerAction fromBuffer(byte[] buffer) {
		PlayerAction ret = new PlayerAction();
		ret.decode(buffer);
		return ret;
	}

}
