/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import sul.utils.*;

public class DestroyEntities extends Packet {

	public final static int ID = (int)48;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int[] entityIds;

	public DestroyEntities() {}

	public DestroyEntities(int[] entityIds) {
		this.entityIds = entityIds;
	}

	@Override
	public int length() {
		int length=Var.Uint.length() + Var.Uint.length(entityIds.length) + 0; for(int zw50axr5swrz:entityIds){ length+=Var.Uint.length(zw50axr5swrz); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)entityIds.length); for(int zw50axr5swrz:entityIds){ this.writeVaruint(zw50axr5swrz); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		int bgvudgl0eulkcw=varuint.decode(_buffer, _index); entityIds=new int[bgvudgl0eulkcw]; for(int zw50axr5swrz=0;zw50axr5swrz<entityIds.length;zw50axr5swrz++){ entityIds[zw50axr5swrz]=varuint.decode(_buffer, _index); }
	}

	public static DestroyEntities fromBuffer(byte[] buffer) {
		DestroyEntities ret = new DestroyEntities();
		ret.decode(buffer);
		return ret;
	}

}
