/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole1.xml
 */
package sul.protocol.externalconsole1.status;

import sul.utils.*;

/**
 * Keeps the connection alive and/or calculates the latency. This packet should be
 * sent at least every 5 seconds to avoid the disconnection caused by timeout and update
 * the latency. The external console can send this packet whenever it wants it and
 * the server must reply with the same packet with the same field's value.
 */
public class KeepAlive extends Packet {

	public final static byte ID = (byte)0;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = true;

	/**
	 * An identifier chosen by the external console to uniquely identify the packet.
	 */
	public int count;

	public KeepAlive() {}

	public KeepAlive(int count) {
		this.count = count;
	}

	@Override
	public int length() {
		return 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianInt(count);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		count=readBigEndianInt();
	}

	public static KeepAlive fromBuffer(byte[] buffer) {
		KeepAlive ret = new KeepAlive();
		ret.decode(buffer);
		return ret;
	}

}
