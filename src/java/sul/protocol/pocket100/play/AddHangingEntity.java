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

public class AddHangingEntity extends Packet {

	public final static byte ID = (byte)17;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public long entityId;
	public long runtimeId;
	public BlockPosition position;
	public int unknown3;

	public AddHangingEntity() {}

	public AddHangingEntity(long entityId, long runtimeId, BlockPosition position, int unknown3) {
		this.entityId = entityId;
		this.runtimeId = runtimeId;
		this.position = position;
		this.unknown3 = unknown3;
	}

	@Override
	public int length() {
		return Var.Long.length(entityId) + Var.Long.length(runtimeId) + position.length() + Var.Int.length(?) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeVarlong(runtimeId);
		this.writeBytes(position.encode());
		this.writeVarint(unknown3);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=varlong.decode(_buffer, _index);
		runtimeId=varlong.decode(_buffer, _index);
		position=new BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
		unknown3=varint.decode(_buffer, _index);
	}

	public static AddHangingEntity fromBuffer(byte[] buffer) {
		AddHangingEntity ret = new AddHangingEntity();
		ret.decode(buffer);
		return ret;
	}

}
