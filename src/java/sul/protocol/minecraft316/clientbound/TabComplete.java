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

public class TabComplete extends Packet {

	public final static int ID = (int)14;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String[] matches;

	public TabComplete() {}

	public TabComplete(String[] matches) {
		this.matches = matches;
	}

	@Override
	public int length() {
		int length=Var.Uint.length() + Var.Uint.length(matches.length) + 0; for(String bwf0y2hlcw:matches){ length+=Var.Uint.length(bwf0y2hlcw.getBytes(StandardCharsets.UTF_8).length)+bwf0y2hlcw.getBytes(StandardCharsets.UTF_8).length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)matches.length); for(String bwf0y2hlcw:matches){ byte[] yndmmhkyagxjdw=bwf0y2hlcw.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yndmmhkyagxjdw.length); this.writeBytes(yndmmhkyagxjdw); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		int bg1hdgnozxm=varuint.decode(_buffer, _index); matches=new String[bg1hdgnozxm]; for(int bwf0y2hlcw=0;bwf0y2hlcw<matches.length;bwf0y2hlcw++){ int bgvubwf0y2hlc1ti=varuint.decode(_buffer, _index); matches[bwf0y2hlcw]=new String(this.readBytes(bgvubwf0y2hlc1ti), StandardCharsets.UTF_8); }
	}

	public static TabComplete fromBuffer(byte[] buffer) {
		TabComplete ret = new TabComplete();
		ret.decode(buffer);
		return ret;
	}

}
