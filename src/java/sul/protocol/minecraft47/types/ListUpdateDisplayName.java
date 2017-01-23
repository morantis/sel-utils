/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.types;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import sul.utils.*;

public class ListUpdateDisplayName extends Packet {

	public UUID uuid;
	public boolean hasDisplayName;
	public String displayName;

	public ListUpdateDisplayName() {}

	public ListUpdateDisplayName(UUID uuid, boolean hasDisplayName, String displayName) {
		this.uuid = uuid;
		this.hasDisplayName = hasDisplayName;
		this.displayName = displayName;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + 17;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this._buffer[this._index++]=(byte)(hasDisplayName?1:0);
		if(hasDisplayName==true){ byte[] zglzcgxheu5hbwu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zglzcgxheu5hbwu.length); this.writeBytes(zglzcgxheu5hbwu); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		long bxv1awq=readBigEndianLong(); long bhv1awq=readBigEndianLong(); uuid=new UUID(bxv1awq,bhv1awq);
		hasDisplayName=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
		if(hasDisplayName==true){ int bgvuzglzcgxheu5h=this.readVaruint(); displayName=new String(this.readBytes(bgvuzglzcgxheu5h), StandardCharsets.UTF_8); }
	}


}