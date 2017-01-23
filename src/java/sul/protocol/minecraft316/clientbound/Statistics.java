/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import sul.protocol.minecraft316.types.*;
import sul.utils.*;

public class Statistics extends Packet {

	public final static int ID = (int)7;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public Statistic[] statistics;

	public Statistics() {}

	public Statistics(Statistic[] statistics) {
		this.statistics = statistics;
	}

	@Override
	public int length() {
		int length=Var.Uint.length() + Var.Uint.length(statistics.length) + 0; for(Statistic c3rhdglzdgljcw:statistics){ length+=c3rhdglzdgljcw.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)statistics.length); for(Statistic c3rhdglzdgljcw:statistics){ this.writeBytes(c3rhdglzdgljcw.encode()); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		int bhn0yxrpc3rpy3m=varuint.decode(_buffer, _index); statistics=new Statistic[bhn0yxrpc3rpy3m]; for(int c3rhdglzdgljcw=0;c3rhdglzdgljcw<statistics.length;c3rhdglzdgljcw++){ statistics[c3rhdglzdgljcw]=new Statistic(); statistics[c3rhdglzdgljcw]._index=this._index; statistics[c3rhdglzdgljcw].decode(this._buffer); this._index=statistics[c3rhdglzdgljcw]._index; }
	}

	public static Statistics fromBuffer(byte[] buffer) {
		Statistics ret = new Statistics();
		ret.decode(buffer);
		return ret;
	}

}
