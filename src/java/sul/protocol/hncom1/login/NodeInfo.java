/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.login;

import sul.protocol.hncom1.types.*;
import sul.utils.*;

/**
 * Informations about the node.
 */
public class NodeInfo extends Packet {

	public final static byte ID = (byte)3;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// max
	public final static int UNLIMITED = 0;

	public long time;
	public int max;
	public Plugin[] plugins;

	public NodeInfo() {}

	public NodeInfo(long time, int max, Plugin[] plugins) {
		this.time = time;
		this.max = max;
		this.plugins = plugins;
	}

	@Override
	public int length() {
		int length=Var.Ulong.length(time) + Var.Uint.length(max) + Var.Uint.length(plugins.length) + 1; for(Plugin cgx1z2lucw:plugins){ length+=cgx1z2lucw.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarulong(time);
		this.writeVaruint(max);
		this.writeVaruint((int)plugins.length); for(Plugin cgx1z2lucw:plugins){ this.writeBytes(cgx1z2lucw.encode()); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		time=varulong.decode(_buffer, _index);
		max=varuint.decode(_buffer, _index);
		int bhbsdwdpbnm=varuint.decode(_buffer, _index); plugins=new Plugin[bhbsdwdpbnm]; for(int cgx1z2lucw=0;cgx1z2lucw<plugins.length;cgx1z2lucw++){ plugins[cgx1z2lucw]=new Plugin(); plugins[cgx1z2lucw]._index=this._index; plugins[cgx1z2lucw].decode(this._buffer); this._index=plugins[cgx1z2lucw]._index; }
	}

	public static NodeInfo fromBuffer(byte[] buffer) {
		NodeInfo ret = new NodeInfo();
		ret.decode(buffer);
		return ret;
	}

}
