/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import sul.utils.*;

public class SpawnPainting extends Packet {

	public final static int ID = (int)4;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// direction
	public final static byte SOUTH = 0;
	public final static byte WEST = 1;
	public final static byte NORTH = 2;
	public final static byte EAST = 3;

	public int entityId;
	public UUID uuid;
	public String title;
	public long position;
	public byte direction;

	public SpawnPainting() {}

	public SpawnPainting(int entityId, UUID uuid, String title, long position, byte direction) {
		this.entityId = entityId;
		this.uuid = uuid;
		this.title = title;
		this.position = position;
		this.direction = direction;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + Buffer.varuintLength(title.getBytes(StandardCharsets.UTF_8).length) + title.getBytes(StandardCharsets.UTF_8).length + 25;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		byte[] dgl0bgu=title.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dgl0bgu.length); this.writeBytes(dgl0bgu);
		this.writeBigEndianLong(position);
		this.writeBigEndianByte(direction);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		long bxv1awq=readBigEndianLong(); long bhv1awq=readBigEndianLong(); uuid=new UUID(bxv1awq,bhv1awq);
		int bgvudgl0bgu=this.readVaruint(); title=new String(this.readBytes(bgvudgl0bgu), StandardCharsets.UTF_8);
		position=readBigEndianLong();
		direction=readBigEndianByte();
	}

	public static SpawnPainting fromBuffer(byte[] buffer) {
		SpawnPainting ret = new SpawnPainting();
		ret.decode(buffer);
		return ret;
	}

}
