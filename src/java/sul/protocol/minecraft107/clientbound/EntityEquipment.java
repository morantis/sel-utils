/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import sul.protocol.minecraft107.types.*;
import sul.utils.*;

public class EntityEquipment extends Packet {

	public final static int ID = (int)60;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public int slot;
	public Slot item;

	public EntityEquipment() {}

	public EntityEquipment(int entityId, int slot, Slot item) {
		this.entityId = entityId;
		this.slot = slot;
		this.item = item;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(entityId) + Var.Uint.length(slot) + item.length();
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeVaruint(slot);
		this.writeBytes(item.encode());
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		entityId=varuint.decode(_buffer, _index);
		slot=varuint.decode(_buffer, _index);
		item=new Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
	}

	public static EntityEquipment fromBuffer(byte[] buffer) {
		EntityEquipment ret = new EntityEquipment();
		ret.decode(buffer);
		return ret;
	}

}
