/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.protocol.pocket100.types.*;
import sul.utils.*;

public class UseItem extends Packet {

	public final static byte ID = (byte)35;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public BlockPosition blockPosition;
	public int hotbarSlot;
	public int face;
	public Tuples.FloatXYZ facePosition;
	public Tuples.FloatXYZ position;
	public int slot;
	public Slot item;

	public UseItem() {}

	public UseItem(BlockPosition blockPosition, int hotbarSlot, int face, Tuples.FloatXYZ facePosition, Tuples.FloatXYZ position, int slot, Slot item) {
		this.blockPosition = blockPosition;
		this.hotbarSlot = hotbarSlot;
		this.face = face;
		this.facePosition = facePosition;
		this.position = position;
		this.slot = slot;
		this.item = item;
	}

	@Override
	public int length() {
		return blockPosition.length() + Var.Uint.length(hotbarSlot) + Var.Int.length(face) + facePosition.length() + position.length() + Var.Int.length(slot) + item.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(blockPosition.encode());
		this.writeVaruint(hotbarSlot);
		this.writeVarint(face);
		this.writeLittleEndianFloat(facePosition.x);this.writeLittleEndianFloat(facePosition.y);this.writeLittleEndianFloat(facePosition.z);
		this.writeLittleEndianFloat(position.x);this.writeLittleEndianFloat(position.y);this.writeLittleEndianFloat(position.z);
		this.writeVarint(slot);
		this.writeBytes(item.encode());
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		blockPosition=new BlockPosition(); blockPosition._index=this._index; blockPosition.decode(this._buffer); this._index=blockPosition._index;
		hotbarSlot=varuint.decode(_buffer, _index);
		face=varint.decode(_buffer, _index);
		facePosition.x=readLittleEndianFloat(); facePosition.y=readLittleEndianFloat(); facePosition.z=readLittleEndianFloat();
		position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		slot=varint.decode(_buffer, _index);
		item=new Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
	}

	public static UseItem fromBuffer(byte[] buffer) {
		UseItem ret = new UseItem();
		ret.decode(buffer);
		return ret;
	}

}
