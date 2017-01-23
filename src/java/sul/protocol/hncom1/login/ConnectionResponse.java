/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.login;

import sul.utils.*;

/**
 * Reply always sent after the ConnectionRequest packet. It indicates the status of
 * the connection, which is accepted only when every field of the packet is true.
 */
public class ConnectionResponse extends Packet {

	public final static byte ID = (byte)1;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// status
	public final static byte OK = 0;
	public final static byte OUTDATED_HUB = 1;
	public final static byte OUTDATED_NODE = 2;
	public final static byte PASSWORD_REQUIRED = 3;
	public final static byte WRONG_PASSWORD = 4;
	public final static byte INVALID_NAME_LENGTH = 5;
	public final static byte INVALID_NAME_CHARACTERS = 6;
	public final static byte NAME_ALREADY_USED = 7;
	public final static byte NAME_RESERVED = 8;

	/**
	 * Protocol used by the hub. It must match the node's one otherwise the connection
	 * cannot be established.
	 */
	public int protocol;

	/**
	 * Indicates the status of connection. If not 0, it indicates an error.
	 */
	public byte status;

	public ConnectionResponse() {}

	public ConnectionResponse(int protocol, byte status) {
		this.protocol = protocol;
		this.status = status;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(protocol) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(protocol);
		this.writeBigEndianByte(status);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		protocol=this.readVaruint();
		status=readBigEndianByte();
	}

	public static ConnectionResponse fromBuffer(byte[] buffer) {
		ConnectionResponse ret = new ConnectionResponse();
		ret.decode(buffer);
		return ret;
	}

}