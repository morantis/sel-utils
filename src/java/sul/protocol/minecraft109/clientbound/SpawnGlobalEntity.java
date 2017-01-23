/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import sul.utils.*;

public class SpawnGlobalEntity extends Packet {

	public final static int ID = (int)2;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// type
	public final static byte THUNDERBOLT = 1;

	public int entityId;
	public byte type;
	public Tuples.DoubleXYZ position;

	public SpawnGlobalEntity() {}

	public SpawnGlobalEntity(int entityId, byte type, Tuples.DoubleXYZ position) {
		this.entityId = entityId;
		this.type = type;
		this.position = position;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(entityId) + position.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianByte(type);
		this.writeBigEndianDouble(position.x);this.writeBigEndianDouble(position.y);this.writeBigEndianDouble(position.z);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		entityId=varuint.decode(_buffer, _index);
		type=readBigEndianByte();
		position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
	}

	public static SpawnGlobalEntity fromBuffer(byte[] buffer) {
		SpawnGlobalEntity ret = new SpawnGlobalEntity();
		ret.decode(buffer);
		return ret;
	}

}
