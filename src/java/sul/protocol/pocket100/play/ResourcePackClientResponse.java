/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class ResourcePackClientResponse extends Packet {

	public final static byte ID = (byte)9;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public byte status;
	public short resourcePackVersion;

	public ResourcePackClientResponse() {}

	public ResourcePackClientResponse(byte status, short resourcePackVersion) {
		this.status = status;
		this.resourcePackVersion = resourcePackVersion;
	}

	@Override
	public int length() {
		return 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(status);
		this.writeBigEndianShort(resourcePackVersion);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		status=readBigEndianByte();
		resourcePackVersion=readBigEndianShort();
	}

	public static ResourcePackClientResponse fromBuffer(byte[] buffer) {
		ResourcePackClientResponse ret = new ResourcePackClientResponse();
		ret.decode(buffer);
		return ret;
	}

}
