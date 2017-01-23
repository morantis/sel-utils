/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class PlayerListHeaderAndFooter extends Packet {

	public final static int ID = (int)72;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String header;
	public String footer;

	public PlayerListHeaderAndFooter() {}

	public PlayerListHeaderAndFooter(String header, String footer) {
		this.header = header;
		this.footer = footer;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(header.getBytes(StandardCharsets.UTF_8).length) + header.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(footer.getBytes(StandardCharsets.UTF_8).length) + footer.getBytes(StandardCharsets.UTF_8).length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] agvhzgvy=header.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)agvhzgvy.length); this.writeBytes(agvhzgvy);
		byte[] zm9vdgvy=footer.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zm9vdgvy.length); this.writeBytes(zm9vdgvy);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		int bgvuagvhzgvy=varuint.decode(_buffer, _index); header=new String(this.readBytes(bgvuagvhzgvy), StandardCharsets.UTF_8);
		int bgvuzm9vdgvy=varuint.decode(_buffer, _index); footer=new String(this.readBytes(bgvuzm9vdgvy), StandardCharsets.UTF_8);
	}

	public static PlayerListHeaderAndFooter fromBuffer(byte[] buffer) {
		PlayerListHeaderAndFooter ret = new PlayerListHeaderAndFooter();
		ret.decode(buffer);
		return ret;
	}

}
