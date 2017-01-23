/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.player;

import sul.utils.*;

public class UpdateLatency extends Packet {

	public final static byte ID = (byte)17;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int hubId;
	public int latency;

	public UpdateLatency() {}

	public UpdateLatency(int hubId, int latency) {
		this.hubId = hubId;
		this.latency = latency;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(hubId) + Buffer.varuintLength(latency) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(hubId);
		this.writeVaruint(latency);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hubId=this.readVaruint();
		latency=this.readVaruint();
	}

	public static UpdateLatency fromBuffer(byte[] buffer) {
		UpdateLatency ret = new UpdateLatency();
		ret.decode(buffer);
		return ret;
	}

}