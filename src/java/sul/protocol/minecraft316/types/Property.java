/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Property extends Packet {

	public String name;
	public String value;
	public boolean signed;
	public String signature;

	public Property() {}

	public Property(String name, String value, boolean signed, String signature) {
		this.name = name;
		this.value = value;
		this.signed = signed;
		this.signature = signature;
	}

	@Override
	public int length() {
		return Var.Uint.length(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(value.getBytes(StandardCharsets.UTF_8).length) + value.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(signature.getBytes(StandardCharsets.UTF_8).length) + signature.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bmftzq=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bmftzq.length); this.writeBytes(bmftzq);
		byte[] dmfsdwu=value.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dmfsdwu.length); this.writeBytes(dmfsdwu);
		this._buffer[this._index++]=(byte)(signed?1:0);
		if(signed==true){ byte[] c2lnbmf0dxjl=signature.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c2lnbmf0dxjl.length); this.writeBytes(c2lnbmf0dxjl); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bgvubmftzq=varuint.decode(_buffer, _index); name=new String(this.readBytes(bgvubmftzq), StandardCharsets.UTF_8);
		int bgvudmfsdwu=varuint.decode(_buffer, _index); value=new String(this.readBytes(bgvudmfsdwu), StandardCharsets.UTF_8);
		signed=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
		if(signed==true){ int bgvuc2lnbmf0dxjl=varuint.decode(_buffer, _index); signature=new String(this.readBytes(bgvuc2lnbmf0dxjl), StandardCharsets.UTF_8); }
	}


}
