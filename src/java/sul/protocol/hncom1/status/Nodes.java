/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.status;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Adds or remove a node.
 */
public class Nodes extends Packet {

	public final static byte ID = (byte)5;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// action
	public final static byte ADD = 0;
	public final static byte REMOVE = 1;

	public byte action;
	public String node;

	public Nodes() {}

	public Nodes(byte action, String node) {
		this.action = action;
		this.node = node;
	}

	@Override
	public int length() {
		return Var.Uint.length(node.getBytes(StandardCharsets.UTF_8).length) + node.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(action);
		byte[] bm9kzq=node.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bm9kzq.length); this.writeBytes(bm9kzq);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		action=readBigEndianByte();
		int bgvubm9kzq=varuint.decode(_buffer, _index); node=new String(this.readBytes(bgvubm9kzq), StandardCharsets.UTF_8);
	}

	public static Nodes fromBuffer(byte[] buffer) {
		Nodes ret = new Nodes();
		ret.decode(buffer);
		return ret;
	}

}
