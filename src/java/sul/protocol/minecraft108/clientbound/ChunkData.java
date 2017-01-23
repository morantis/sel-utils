/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import sul.utils.*;

public class ChunkData extends Packet {

	public final static int ID = (int)32;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public Tuples.IntXZ position;
	public boolean full;
	public int sections;
	public byte[] data;

	public ChunkData() {}

	public ChunkData(Tuples.IntXZ position, boolean full, int sections, byte[] data) {
		this.position = position;
		this.full = full;
		this.sections = sections;
		this.data = data;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(sections) + Buffer.varuintLength(data.length) + data.length + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(position.x); this.writeBigEndianInt(position.z);
		this._buffer[this._index++]=(byte)(full?1:0);
		this.writeVaruint(sections);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position.x=readBigEndianInt(); position.z=readBigEndianInt();
		full=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
		sections=this.readVaruint();
		int bgrhdge=this.readVaruint(); data=new byte[bgrhdge]; data=this.readBytes(bgrhdge);
	}

	public static ChunkData fromBuffer(byte[] buffer) {
		ChunkData ret = new ChunkData();
		ret.decode(buffer);
		return ret;
	}

}
