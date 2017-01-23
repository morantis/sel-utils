/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class OpenWindow extends Packet {

	public final static int ID = (int)19;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public byte window;
	public String type;
	public String title;
	public byte slots;

	public OpenWindow() {}

	public OpenWindow(byte window, String type, String title, byte slots) {
		this.window = window;
		this.type = type;
		this.title = title;
		this.slots = slots;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(type.getBytes(StandardCharsets.UTF_8).length) + type.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(title.getBytes(StandardCharsets.UTF_8).length) + title.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		byte[] dhlwzq=type.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dhlwzq.length); this.writeBytes(dhlwzq);
		byte[] dgl0bgu=title.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dgl0bgu.length); this.writeBytes(dgl0bgu);
		this.writeBigEndianByte(slots);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
		int bgvudhlwzq=this.readVaruint(); type=new String(this.readBytes(bgvudhlwzq), StandardCharsets.UTF_8);
		int bgvudgl0bgu=this.readVaruint(); title=new String(this.readBytes(bgvudgl0bgu), StandardCharsets.UTF_8);
		slots=readBigEndianByte();
	}

	public static OpenWindow fromBuffer(byte[] buffer) {
		OpenWindow ret = new OpenWindow();
		ret.decode(buffer);
		return ret;
	}

}
