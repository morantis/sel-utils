/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class DisplayScoreboard extends Packet {

	public final static int ID = (int)56;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// position
	public final static byte LIST = 0;
	public final static byte SIDEBAR = 1;
	public final static byte BELOW_NAME = 2;

	public byte position;
	public String scoreName;

	public DisplayScoreboard() {}

	public DisplayScoreboard(byte position, String scoreName) {
		this.position = position;
		this.scoreName = scoreName;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(scoreName.getBytes(StandardCharsets.UTF_8).length) + scoreName.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(position);
		byte[] c2nvcmvoyw1l=scoreName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c2nvcmvoyw1l.length); this.writeBytes(c2nvcmvoyw1l);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		position=readBigEndianByte();
		int bgvuc2nvcmvoyw1l=varuint.decode(_buffer, _index); scoreName=new String(this.readBytes(bgvuc2nvcmvoyw1l), StandardCharsets.UTF_8);
	}

	public static DisplayScoreboard fromBuffer(byte[] buffer) {
		DisplayScoreboard ret = new DisplayScoreboard();
		ret.decode(buffer);
		return ret;
	}

}
