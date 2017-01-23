/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.util.UUID;

import sul.utils.*;

public class CraftingEvent extends Packet {

	public final static byte ID = (byte)54;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public byte window;
	public int type;
	public UUID uuid;
	public sul.protocol.pocket100.types.Slot[] input;
	public sul.protocol.pocket100.types.Slot[] output;

	public CraftingEvent() {}

	public CraftingEvent(byte window, int type, UUID uuid, sul.protocol.pocket100.types.Slot[] input, sul.protocol.pocket100.types.Slot[] output) {
		this.window = window;
		this.type = type;
		this.uuid = uuid;
		this.input = input;
		this.output = output;
	}

	@Override
	public int length() {
		int length=Buffer.varintLength(type) + Buffer.varuintLength(input.length) + Buffer.varuintLength(output.length) + 18; for(sul.protocol.pocket100.types.Slot aw5wdxq:input){ length+=aw5wdxq.length(); };for(sul.protocol.pocket100.types.Slot b3v0chv0:output){ length+=b3v0chv0.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(window);
		this.writeVarint(type);
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeVaruint((int)input.length); for(sul.protocol.pocket100.types.Slot aw5wdxq:input){ this.writeBytes(aw5wdxq.encode()); }
		this.writeVaruint((int)output.length); for(sul.protocol.pocket100.types.Slot b3v0chv0:output){ this.writeBytes(b3v0chv0.encode()); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		window=readBigEndianByte();
		type=this.readVarint();
		long bxv1awq=readBigEndianLong(); long bhv1awq=readBigEndianLong(); uuid=new UUID(bxv1awq,bhv1awq);
		int bgluchv0=this.readVaruint(); input=new sul.protocol.pocket100.types.Slot[bgluchv0]; for(int aw5wdxq=0;aw5wdxq<input.length;aw5wdxq++){ input[aw5wdxq]=new sul.protocol.pocket100.types.Slot(); input[aw5wdxq]._index=this._index; input[aw5wdxq].decode(this._buffer); this._index=input[aw5wdxq]._index; }
		int bg91dhb1da=this.readVaruint(); output=new sul.protocol.pocket100.types.Slot[bg91dhb1da]; for(int b3v0chv0=0;b3v0chv0<output.length;b3v0chv0++){ output[b3v0chv0]=new sul.protocol.pocket100.types.Slot(); output[b3v0chv0]._index=this._index; output[b3v0chv0].decode(this._buffer); this._index=output[b3v0chv0]._index; }
	}

	public static CraftingEvent fromBuffer(byte[] buffer) {
		CraftingEvent ret = new CraftingEvent();
		ret.decode(buffer);
		return ret;
	}

}
