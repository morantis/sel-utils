/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.serverbound;

import sul.utils.*;

public class EntityAction extends Packet {

	public final static int ID = (int)20;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// action
	public final static int START_SNEAKING = 0;
	public final static int STOP_SNEAKING = 1;
	public final static int LEAVE_BED = 2;
	public final static int START_SPRINTING = 3;
	public final static int STOP_SPRINTING = 4;
	public final static int START_HORSE_JUMP = 5;
	public final static int STOP_HORSE_JUMP = 6;
	public final static int OPEN_HORSE_INVENTORY = 7;
	public final static int START_ELYTRA_FLYING = 8;

	public int entityId;
	public int action;
	public int jumpBoost;

	public EntityAction() {}

	public EntityAction(int entityId, int action, int jumpBoost) {
		this.entityId = entityId;
		this.action = action;
		this.jumpBoost = jumpBoost;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(entityId) + Var.Uint.length(action) + Var.Uint.length(jumpBoost);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeVaruint(action);
		if(action==5){ this.writeVaruint(jumpBoost); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		entityId=varuint.decode(_buffer, _index);
		action=varuint.decode(_buffer, _index);
		if(action==5){ jumpBoost=varuint.decode(_buffer, _index); }
	}

	public static EntityAction fromBuffer(byte[] buffer) {
		EntityAction ret = new EntityAction();
		ret.decode(buffer);
		return ret;
	}

}
