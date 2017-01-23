/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.clientbound;

import sul.utils.*;

public class Statistics extends Packet {

	public final static int ID = (int)55;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public sul.protocol.minecraft47.types.Statistic[] statistics;

	public Statistics() {}

	public Statistics(sul.protocol.minecraft47.types.Statistic[] statistics) {
		this.statistics = statistics;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(ID) + Buffer.varuintLength(statistics.length) + 0; for(sul.protocol.minecraft47.types.Statistic c3rhdglzdgljcw:statistics){ length+=c3rhdglzdgljcw.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)statistics.length); for(sul.protocol.minecraft47.types.Statistic c3rhdglzdgljcw:statistics){ this.writeBytes(c3rhdglzdgljcw.encode()); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bhn0yxrpc3rpy3m=this.readVaruint(); statistics=new sul.protocol.minecraft47.types.Statistic[bhn0yxrpc3rpy3m]; for(int c3rhdglzdgljcw=0;c3rhdglzdgljcw<statistics.length;c3rhdglzdgljcw++){ statistics[c3rhdglzdgljcw]=new sul.protocol.minecraft47.types.Statistic(); statistics[c3rhdglzdgljcw]._index=this._index; statistics[c3rhdglzdgljcw].decode(this._buffer); this._index=statistics[c3rhdglzdgljcw]._index; }
	}

	public static Statistics fromBuffer(byte[] buffer) {
		Statistics ret = new Statistics();
		ret.decode(buffer);
		return ret;
	}

}
