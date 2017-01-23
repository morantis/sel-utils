/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class Animate extends Packet {

	public final static byte ID = (byte)44;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = true;

	// action
	public final static int BREAKING = 1;
	public final static int WAKE_UP = 3;

	public int action;
	public long entityId;

	public Animate() {}

	public Animate(int action, long entityId) {
		this.action = action;
		this.entityId = entityId;
	}

	@Override
	public int length() {
		return Var.Int.length(action) + Var.Long.length(entityId) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(action);
		this.writeVarlong(entityId);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		action=varint.decode(_buffer, _index);
		entityId=varlong.decode(_buffer, _index);
	}

	public static Animate fromBuffer(byte[] buffer) {
		Animate ret = new Animate();
		ret.decode(buffer);
		return ret;
	}

}
