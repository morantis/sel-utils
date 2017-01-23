/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import sul.utils.*;

public class EntityMetadata extends Packet {

	public final static int ID = (int)57;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public Metadata metadata;

	public EntityMetadata() {}

	public EntityMetadata(int entityId, Metadata metadata) {
		this.entityId = entityId;
		this.metadata = metadata;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + metadata.length();
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBytes(metadata.encode());
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		metadata=new Metadata(); metadata._index=this._index; metadata.decode(this._buffer); this._index=metadata._index;
	}

	public static EntityMetadata fromBuffer(byte[] buffer) {
		EntityMetadata ret = new EntityMetadata();
		ret.decode(buffer);
		return ret;
	}

}
