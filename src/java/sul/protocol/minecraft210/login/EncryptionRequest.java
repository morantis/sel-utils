/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.login;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class EncryptionRequest extends Packet {

	public final static int ID = (int)1;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String serverId;
	public byte[] publicKey;
	public byte[] verifyToken;

	public EncryptionRequest() {}

	public EncryptionRequest(String serverId, byte[] publicKey, byte[] verifyToken) {
		this.serverId = serverId;
		this.publicKey = publicKey;
		this.verifyToken = verifyToken;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(serverId.getBytes(StandardCharsets.UTF_8).length) + serverId.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(publicKey.length) + publicKey.length + Var.Uint.length(verifyToken.length) + verifyToken.length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] c2vydmvyswq=serverId.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c2vydmvyswq.length); this.writeBytes(c2vydmvyswq);
		this.writeVaruint((int)publicKey.length); this.writeBytes(publicKey);
		this.writeVaruint((int)verifyToken.length); this.writeBytes(verifyToken);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		int bgvuc2vydmvyswq=varuint.decode(_buffer, _index); serverId=new String(this.readBytes(bgvuc2vydmvyswq), StandardCharsets.UTF_8);
		int bhb1ymxpy0tleq=varuint.decode(_buffer, _index); publicKey=new byte[bhb1ymxpy0tleq]; publicKey=this.readBytes(bhb1ymxpy0tleq);
		int bhzlcmlmevrva2vu=varuint.decode(_buffer, _index); verifyToken=new byte[bhzlcmlmevrva2vu]; verifyToken=this.readBytes(bhzlcmlmevrva2vu);
	}

	public static EncryptionRequest fromBuffer(byte[] buffer) {
		EncryptionRequest ret = new EncryptionRequest();
		ret.decode(buffer);
		return ret;
	}

}
