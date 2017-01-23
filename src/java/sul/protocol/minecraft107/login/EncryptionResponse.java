/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.login;

import sul.utils.*;

public class EncryptionResponse extends Packet {

	public final static int ID = (int)1;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public byte[] sharedSecret;
	public byte[] verifyToken;

	public EncryptionResponse() {}

	public EncryptionResponse(byte[] sharedSecret, byte[] verifyToken) {
		this.sharedSecret = sharedSecret;
		this.verifyToken = verifyToken;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(sharedSecret.length) + sharedSecret.length + Var.Uint.length(verifyToken.length) + verifyToken.length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)sharedSecret.length); this.writeBytes(sharedSecret);
		this.writeVaruint((int)verifyToken.length); this.writeBytes(verifyToken);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		int bhnoyxjlzfnly3jl=varuint.decode(_buffer, _index); sharedSecret=new byte[bhnoyxjlzfnly3jl]; sharedSecret=this.readBytes(bhnoyxjlzfnly3jl);
		int bhzlcmlmevrva2vu=varuint.decode(_buffer, _index); verifyToken=new byte[bhzlcmlmevrva2vu]; verifyToken=this.readBytes(bhzlcmlmevrva2vu);
	}

	public static EncryptionResponse fromBuffer(byte[] buffer) {
		EncryptionResponse ret = new EncryptionResponse();
		ret.decode(buffer);
		return ret;
	}

}
