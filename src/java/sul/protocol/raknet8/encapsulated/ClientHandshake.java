/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.encapsulated;

import sul.protocol.raknet8.types.*;
import sul.utils.*;

public class ClientHandshake extends Packet {

	public final static byte ID = (byte)19;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public Address clientAddress;
	public Address[] systemAddresses = new Address[10];
	public long pingId;
	public long clientId;

	public ClientHandshake() {}

	public ClientHandshake(Address clientAddress, Address[] systemAddresses, long pingId, long clientId) {
		this.clientAddress = clientAddress;
		this.systemAddresses = systemAddresses;
		this.pingId = pingId;
		this.clientId = clientId;
	}

	@Override
	public int length() {
		int length=clientAddress.length() + 17; for(Address c3lzdgvtqwrkcmvz:systemAddresses){ length+=c3lzdgvtqwrkcmvz.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(clientAddress.encode());
		for(Address c3lzdgvtqwrkcmvz:systemAddresses){ this.writeBytes(c3lzdgvtqwrkcmvz.encode()); }
		this.writeBigEndianLong(pingId);
		this.writeBigEndianLong(clientId);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		clientAddress=new Address(); clientAddress._index=this._index; clientAddress.decode(this._buffer); this._index=clientAddress._index;
		final int bhn5c3rlbufkzhjl=10; systemAddresses=new Address[bhn5c3rlbufkzhjl]; for(int c3lzdgvtqwrkcmvz=0;c3lzdgvtqwrkcmvz<systemAddresses.length;c3lzdgvtqwrkcmvz++){ systemAddresses[c3lzdgvtqwrkcmvz]=new Address(); systemAddresses[c3lzdgvtqwrkcmvz]._index=this._index; systemAddresses[c3lzdgvtqwrkcmvz].decode(this._buffer); this._index=systemAddresses[c3lzdgvtqwrkcmvz]._index; }
		pingId=readBigEndianLong();
		clientId=readBigEndianLong();
	}

	public static ClientHandshake fromBuffer(byte[] buffer) {
		ClientHandshake ret = new ClientHandshake();
		ret.decode(buffer);
		return ret;
	}

}
