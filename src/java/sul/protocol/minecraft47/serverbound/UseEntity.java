/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.serverbound;

import sul.utils.*;

public class UseEntity extends Packet {

	public final static int ID = (int)2;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// type
	public final static int INTERACT = 0;
	public final static int ATTACK = 1;
	public final static int INTERACT_AT = 2;

	public int target;
	public int type;
	public Tuples.FloatXYZ targetPosition;

	public UseEntity() {}

	public UseEntity(int target, int type, Tuples.FloatXYZ targetPosition) {
		this.target = target;
		this.type = type;
		this.targetPosition = targetPosition;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(target) + Var.Uint.length(type) + targetPosition.length();
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(target);
		this.writeVaruint(type);
		if(type==2){ this.writeBigEndianFloat(targetPosition.x);this.writeBigEndianFloat(targetPosition.y);this.writeBigEndianFloat(targetPosition.z); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		target=varuint.decode(_buffer, _index);
		type=varuint.decode(_buffer, _index);
		if(type==2){ targetPosition.x=readBigEndianFloat(); targetPosition.y=readBigEndianFloat(); targetPosition.z=readBigEndianFloat(); }
	}

	public static UseEntity fromBuffer(byte[] buffer) {
		UseEntity ret = new UseEntity();
		ret.decode(buffer);
		return ret;
	}

}
