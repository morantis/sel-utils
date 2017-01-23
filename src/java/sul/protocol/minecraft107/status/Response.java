/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.status;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Response extends Packet {

	public final static int ID = (int)0;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String json;

	public Response() {}

	public Response(String json) {
		this.json = json;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(json.getBytes(StandardCharsets.UTF_8).length) + json.getBytes(StandardCharsets.UTF_8).length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] annvbg=json.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)annvbg.length); this.writeBytes(annvbg);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		int bgvuannvbg=varuint.decode(_buffer, _index); json=new String(this.readBytes(bgvuannvbg), StandardCharsets.UTF_8);
	}

	public static Response fromBuffer(byte[] buffer) {
		Response ret = new Response();
		ret.decode(buffer);
		return ret;
	}

}
