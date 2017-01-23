/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Statistic extends Packet {

	public String name;
	public int value;

	public Statistic() {}

	public Statistic(String name, int value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public int length() {
		return Var.Uint.length(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(value);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bmftzq=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bmftzq.length); this.writeBytes(bmftzq);
		this.writeVaruint(value);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bgvubmftzq=varuint.decode(_buffer, _index); name=new String(this.readBytes(bgvubmftzq), StandardCharsets.UTF_8);
		value=varuint.decode(_buffer, _index);
	}


}
