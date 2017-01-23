/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.serverbound;

import sul.utils.*;

public class Player extends Packet {

	public final static int ID = (int)15;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public boolean onGround;

	public Player() {}

	public Player(boolean onGround) {
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this._buffer[this._index++]=(byte)(onGround?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		onGround=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static Player fromBuffer(byte[] buffer) {
		Player ret = new Player();
		ret.decode(buffer);
		return ret;
	}

}
