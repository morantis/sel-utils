/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.login;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * First real packet sent by the client with its informations.
 */
public class ConnectionRequest extends Packet {

	public final static byte ID = (byte)0;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	/**
	 * Version of the protocol used by the client that must match the hub's one
	 */
	public int protocol;

	/**
	 * Password, if the hub requires one, or an empty string.
	 */
	public String password;

	/**
	 * Name of the node that will be validated by the hub. It should always be lowercase
	 * and only contain letters, numbers and basic punctuation symbols.
	 */
	public String name;

	/**
	 * Indicates whether the node accepts clients when they first connect to the hub or
	 * exclusively when they are manually transferred.
	 */
	public boolean main;

	public ConnectionRequest() {}

	public ConnectionRequest(int protocol, String password, String name, boolean main) {
		this.protocol = protocol;
		this.password = password;
		this.name = name;
		this.main = main;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(protocol) + Buffer.varuintLength(password.getBytes(StandardCharsets.UTF_8).length) + password.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(protocol);
		byte[] cgfzc3dvcmq=password.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cgfzc3dvcmq.length); this.writeBytes(cgfzc3dvcmq);
		byte[] bmftzq=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bmftzq.length); this.writeBytes(bmftzq);
		this._buffer[this._index++]=(byte)(main?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		protocol=this.readVaruint();
		int bgvucgfzc3dvcmq=this.readVaruint(); password=new String(this.readBytes(bgvucgfzc3dvcmq), StandardCharsets.UTF_8);
		int bgvubmftzq=this.readVaruint(); name=new String(this.readBytes(bgvubmftzq), StandardCharsets.UTF_8);
		main=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static ConnectionRequest fromBuffer(byte[] buffer) {
		ConnectionRequest ret = new ConnectionRequest();
		ret.decode(buffer);
		return ret;
	}

}
