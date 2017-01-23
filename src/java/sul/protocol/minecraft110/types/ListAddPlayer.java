/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.types;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import sul.utils.*;

public class ListAddPlayer extends Packet {

	// gamemode
	public final static int SURVIVAL = 0;
	public final static int CREATIVE = 1;
	public final static int ADVENTURE = 2;
	public final static int SPECTATOR = 3;

	public UUID uuid;
	public String name;
	public Property[] properties;
	public int gamemode;
	public int latency;
	public boolean hasDisplayName;
	public String displayName;

	public ListAddPlayer() {}

	public ListAddPlayer(UUID uuid, String name, Property[] properties, int gamemode, int latency, boolean hasDisplayName, String displayName) {
		this.uuid = uuid;
		this.name = name;
		this.properties = properties;
		this.gamemode = gamemode;
		this.latency = latency;
		this.hasDisplayName = hasDisplayName;
		this.displayName = displayName;
	}

	@Override
	public int length() {
		int length=Var.Uint.length(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(properties.length) + Var.Uint.length(gamemode) + Var.Uint.length(latency) + Var.Uint.length(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + 17; for(Property chjvcgvydgllcw:properties){ length+=chjvcgvydgllcw.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		byte[] bmftzq=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bmftzq.length); this.writeBytes(bmftzq);
		this.writeVaruint((int)properties.length); for(Property chjvcgvydgllcw:properties){ this.writeBytes(chjvcgvydgllcw.encode()); }
		this.writeVaruint(gamemode);
		this.writeVaruint(latency);
		this._buffer[this._index++]=(byte)(hasDisplayName?1:0);
		if(has_display_name==true){ byte[] zglzcgxheu5hbwu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zglzcgxheu5hbwu.length); this.writeBytes(zglzcgxheu5hbwu); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		long bxv1awq=readBigEndianLong();long bhv1awq=readBigEndianLong();return new UUID(bxv1awq,bhv1awq);
		int bgvubmftzq=varuint.decode(_buffer, _index); name=new String(this.readBytes(bgvubmftzq), StandardCharsets.UTF_8);
		int bhbyb3blcnrpzxm=varuint.decode(_buffer, _index); properties=new Property[bhbyb3blcnrpzxm]; for(int chjvcgvydgllcw=0;chjvcgvydgllcw<properties.length;chjvcgvydgllcw++){ properties[chjvcgvydgllcw]=new Property(); properties[chjvcgvydgllcw]._index=this._index; properties[chjvcgvydgllcw].decode(this._buffer); this._index=properties[chjvcgvydgllcw]._index; }
		gamemode=varuint.decode(_buffer, _index);
		latency=varuint.decode(_buffer, _index);
		hasDisplayName=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
		if(has_display_name==true){ int bgvuzglzcgxheu5h=varuint.decode(_buffer, _index); displayName=new String(this.readBytes(bgvuzglzcgxheu5h), StandardCharsets.UTF_8); }
	}


}
