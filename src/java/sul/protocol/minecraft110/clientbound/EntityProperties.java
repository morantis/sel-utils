/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.clientbound;

import sul.protocol.minecraft110.types.*;
import sul.utils.*;

public class EntityProperties extends Packet {

	public final static int ID = (int)74;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public Attributes attributes;

	public EntityProperties() {}

	public EntityProperties(int entityId, Attributes attributes) {
		this.entityId = entityId;
		this.attributes = attributes;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(entityId) + attributes.length();
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianInt((int)attributes.length); for(Attribute yxr0cmlidxrlcw:attributes){ this.writeBytes(yxr0cmlidxrlcw.encode()); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		entityId=varuint.decode(_buffer, _index);
		int bgf0dhjpynv0zxm=readBigEndianInt(); attributes=new Attribute[bgf0dhjpynv0zxm]; for(int yxr0cmlidxrlcw=0;yxr0cmlidxrlcw<attributes.length;yxr0cmlidxrlcw++){ attributes[yxr0cmlidxrlcw]=new Attribute(); attributes[yxr0cmlidxrlcw]._index=this._index; attributes[yxr0cmlidxrlcw].decode(this._buffer); this._index=attributes[yxr0cmlidxrlcw]._index; }
	}

	public static EntityProperties fromBuffer(byte[] buffer) {
		EntityProperties ret = new EntityProperties();
		ret.decode(buffer);
		return ret;
	}

}
