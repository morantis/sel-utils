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

public class BlockBreakAnimation extends Packet {

	public final static int ID = (int)8;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public long position;
	public byte stage;

	public BlockBreakAnimation() {}

	public BlockBreakAnimation(int entityId, long position, byte stage) {
		this.entityId = entityId;
		this.position = position;
		this.stage = stage;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(entityId) + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianLong(position);
		this.writeBigEndianByte(stage);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		entityId=varuint.decode(_buffer, _index);
		position=readBigEndianLong();
		stage=readBigEndianByte();
	}

	public static BlockBreakAnimation fromBuffer(byte[] buffer) {
		BlockBreakAnimation ret = new BlockBreakAnimation();
		ret.decode(buffer);
		return ret;
	}

}
