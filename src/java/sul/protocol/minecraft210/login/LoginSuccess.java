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

public class LoginSuccess extends Packet {

	public final static int ID = (int)2;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String uuid;
	public String username;

	public LoginSuccess() {}

	public LoginSuccess(String uuid, String username) {
		this.uuid = uuid;
		this.username = username;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(uuid.getBytes(StandardCharsets.UTF_8).length) + uuid.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(username.getBytes(StandardCharsets.UTF_8).length) + username.getBytes(StandardCharsets.UTF_8).length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] dxvpza=uuid.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dxvpza.length); this.writeBytes(dxvpza);
		byte[] dxnlcm5hbwu=username.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dxnlcm5hbwu.length); this.writeBytes(dxnlcm5hbwu);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		int bgvudxvpza=varuint.decode(_buffer, _index); uuid=new String(this.readBytes(bgvudxvpza), StandardCharsets.UTF_8);
		int bgvudxnlcm5hbwu=varuint.decode(_buffer, _index); username=new String(this.readBytes(bgvudxnlcm5hbwu), StandardCharsets.UTF_8);
	}

	public static LoginSuccess fromBuffer(byte[] buffer) {
		LoginSuccess ret = new LoginSuccess();
		ret.decode(buffer);
		return ret;
	}

}
