/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket102.xml
 */
package sul.protocol.pocket102.play;

import sul.utils.*;

public class UpdateBlock extends Packet {

	public static final byte ID = (byte)23;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// flags and meta
	public static final int NEIGHBORS = 1;
	public static final int NETWORK = 2;
	public static final int NO_GRAPHIC = 4;
	public static final int PRIORITY = 8;

	public sul.protocol.pocket102.types.BlockPosition position;
	public int block;
	public int flagsAndMeta;

	public UpdateBlock() {}

	public UpdateBlock(sul.protocol.pocket102.types.BlockPosition position, int block, int flagsAndMeta) {
		this.position = position;
		this.block = block;
		this.flagsAndMeta = flagsAndMeta;
	}

	@Override
	public int length() {
		return position.length() + Buffer.varuintLength(block) + Buffer.varuintLength(flagsAndMeta) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(position.encode());
		this.writeVaruint(block);
		this.writeVaruint(flagsAndMeta);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		position=new sul.protocol.pocket102.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
		block=this.readVaruint();
		flagsAndMeta=this.readVaruint();
	}

	public static UpdateBlock fromBuffer(byte[] buffer) {
		UpdateBlock ret = new UpdateBlock();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateBlock(position: " + this.position.toString() + ", block: " + this.block + ", flagsAndMeta: " + this.flagsAndMeta + ")";
	}

}
