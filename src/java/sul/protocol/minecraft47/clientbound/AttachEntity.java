/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.clientbound;

import sul.utils.*;

public class AttachEntity extends Packet {

	public final static int ID = (int)27;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int target;
	public int holder;
	public boolean leash;

	public AttachEntity() {}

	public AttachEntity(int target, int holder, boolean leash) {
		this.target = target;
		this.holder = holder;
		this.leash = leash;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(target);
		this.writeBigEndianInt(holder);
		this._buffer[this._index++]=(byte)(leash?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		target=readBigEndianInt();
		holder=readBigEndianInt();
		leash=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static AttachEntity fromBuffer(byte[] buffer) {
		AttachEntity ret = new AttachEntity();
		ret.decode(buffer);
		return ret;
	}

}
