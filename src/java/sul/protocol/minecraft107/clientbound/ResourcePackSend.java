/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class ResourcePackSend extends Packet {

	public final static int ID = (int)50;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String url;
	public String hash;

	public ResourcePackSend() {}

	public ResourcePackSend(String url, String hash) {
		this.url = url;
		this.hash = hash;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(url.getBytes(StandardCharsets.UTF_8).length) + url.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(hash.getBytes(StandardCharsets.UTF_8).length) + hash.getBytes(StandardCharsets.UTF_8).length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] dxjs=url.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dxjs.length); this.writeBytes(dxjs);
		byte[] agfzaa=hash.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)agfzaa.length); this.writeBytes(agfzaa);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bgvudxjs=this.readVaruint(); url=new String(this.readBytes(bgvudxjs), StandardCharsets.UTF_8);
		int bgvuagfzaa=this.readVaruint(); hash=new String(this.readBytes(bgvuagfzaa), StandardCharsets.UTF_8);
	}

	public static ResourcePackSend fromBuffer(byte[] buffer) {
		ResourcePackSend ret = new ResourcePackSend();
		ret.decode(buffer);
		return ret;
	}

}
