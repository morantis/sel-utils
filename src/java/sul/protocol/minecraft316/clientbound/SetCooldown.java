/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import sul.utils.*;

public class SetCooldown extends Packet {

	public final static int ID = (int)23;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int item;
	public int cooldown;

	public SetCooldown() {}

	public SetCooldown(int item, int cooldown) {
		this.item = item;
		this.cooldown = cooldown;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(item) + Var.Uint.length(cooldown);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(item);
		this.writeVaruint(cooldown);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		item=varuint.decode(_buffer, _index);
		cooldown=varuint.decode(_buffer, _index);
	}

	public static SetCooldown fromBuffer(byte[] buffer) {
		SetCooldown ret = new SetCooldown();
		ret.decode(buffer);
		return ret;
	}

}
