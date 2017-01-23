/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.encapsulated;

import sul.utils.*;

public class ClientConnect extends Packet {

	public final static byte ID = (byte)9;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public long clientId;
	public long pingId;

	public ClientConnect() {}

	public ClientConnect(long clientId, long pingId) {
		this.clientId = clientId;
		this.pingId = pingId;
	}

	@Override
	public int length() {
		return 17;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianLong(clientId);
		this.writeBigEndianLong(pingId);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		clientId=readBigEndianLong();
		pingId=readBigEndianLong();
	}

	public static ClientConnect fromBuffer(byte[] buffer) {
		ClientConnect ret = new ClientConnect();
		ret.decode(buffer);
		return ret;
	}

}