/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Skin extends Packet {

	public String name;
	public byte[] data;

	public Skin() {}

	public Skin(String name, byte[] data) {
		this.name = name;
		this.data = data;
	}

	@Override
	public int length() {
		return Var.Uint.length(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(data.length) + data.length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bmftzq=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bmftzq.length); this.writeBytes(bmftzq);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bgvubmftzq=varuint.decode(_buffer, _index); name=new String(this.readBytes(bgvubmftzq), StandardCharsets.UTF_8);
		int bgrhdge=varuint.decode(_buffer, _index); data=new byte[bgrhdge]; data=this.readBytes(bgrhdge);
	}


}
