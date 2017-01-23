/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import sul.protocol.minecraft107.types.*;
import sul.utils.*;

public class Map extends Packet {

	public final static int ID = (int)36;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int mapId;
	public byte scale;
	public boolean showIcons;
	public Icon[] icons;
	public byte colums;
	public byte rows;
	public Tuples.ByteXZ offset;
	public byte[] data;

	public Map() {}

	public Map(int mapId, byte scale, boolean showIcons, Icon[] icons, byte colums, byte rows, Tuples.ByteXZ offset, byte[] data) {
		this.mapId = mapId;
		this.scale = scale;
		this.showIcons = showIcons;
		this.icons = icons;
		this.colums = colums;
		this.rows = rows;
		this.offset = offset;
		this.data = data;
	}

	@Override
	public int length() {
		int length=Var.Uint.length() + Var.Uint.length(mapId) + Var.Uint.length(icons.length) + offset.length() + Var.Uint.length(data.length) + data.length + 4; for(Icon awnvbnm:icons){ length+=awnvbnm.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(mapId);
		this.writeBigEndianByte(scale);
		this._buffer[this._index++]=(byte)(showIcons?1:0);
		this.writeVaruint((int)icons.length); for(Icon awnvbnm:icons){ this.writeBytes(awnvbnm.encode()); }
		this.writeBigEndianByte(colums);
		this.writeBigEndianByte(rows);
		this.writeBigEndianByte(offset.x);this.writeBigEndianByte(offset.z);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		mapId=varuint.decode(_buffer, _index);
		scale=readBigEndianByte();
		showIcons=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
		int bgljb25z=varuint.decode(_buffer, _index); icons=new Icon[bgljb25z]; for(int awnvbnm=0;awnvbnm<icons.length;awnvbnm++){ icons[awnvbnm]=new Icon(); icons[awnvbnm]._index=this._index; icons[awnvbnm].decode(this._buffer); this._index=icons[awnvbnm]._index; }
		colums=readBigEndianByte();
		rows=readBigEndianByte();
		offset.x=readBigEndianByte(); offset.z=readBigEndianByte();
		int bgrhdge=varuint.decode(_buffer, _index); data=new byte[bgrhdge]; data=this.readBytes(bgrhdge);
	}

	public static Map fromBuffer(byte[] buffer) {
		Map ret = new Map();
		ret.decode(buffer);
		return ret;
	}

}
