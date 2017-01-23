/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.clientbound;

import sul.utils.*;

public class Animation extends Packet {

	public final static int ID = (int)6;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// animation
	public final static byte SWING_MAIN_ARM = 0;
	public final static byte TAKE_DAMAGE = 1;
	public final static byte LEAVE_BED = 2;
	public final static byte SWING_OFFHAND = 3;
	public final static byte CRITICAL_EFFECT = 4;
	public final static byte MAGICAL_CRITICAL_EFFECT = 5;

	public int entityId;
	public byte animation;

	public Animation() {}

	public Animation(int entityId, byte animation) {
		this.entityId = entityId;
		this.animation = animation;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(entityId) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianByte(animation);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		entityId=varuint.decode(_buffer, _index);
		animation=readBigEndianByte();
	}

	public static Animation fromBuffer(byte[] buffer) {
		Animation ret = new Animation();
		ret.decode(buffer);
		return ret;
	}

}
