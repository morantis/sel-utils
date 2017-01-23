/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class ScoreboardObjective extends Packet {

	public final static int ID = (int)63;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// mode
	public final static byte CREATE = 0;
	public final static byte REMOVE = 1;
	public final static byte UPDATE = 2;

	// type
	public final static String NUMERIC = "integer";
	public final static String GRAPHIC = "hearts";

	public String name;
	public byte mode;
	public String value;
	public String type;

	public ScoreboardObjective() {}

	public ScoreboardObjective(String name, byte mode, String value, String type) {
		this.name = name;
		this.mode = mode;
		this.value = value;
		this.type = type;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(value.getBytes(StandardCharsets.UTF_8).length) + value.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(type.getBytes(StandardCharsets.UTF_8).length) + type.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] bmftzq=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bmftzq.length); this.writeBytes(bmftzq);
		this.writeBigEndianByte(mode);
		if(mode!=1){ byte[] dmfsdwu=value.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dmfsdwu.length); this.writeBytes(dmfsdwu); }
		if(mode!=1){ byte[] dhlwzq=type.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dhlwzq.length); this.writeBytes(dhlwzq); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bgvubmftzq=this.readVaruint(); name=new String(this.readBytes(bgvubmftzq), StandardCharsets.UTF_8);
		mode=readBigEndianByte();
		if(mode!=1){ int bgvudmfsdwu=this.readVaruint(); value=new String(this.readBytes(bgvudmfsdwu), StandardCharsets.UTF_8); }
		if(mode!=1){ int bgvudhlwzq=this.readVaruint(); type=new String(this.readBytes(bgvudhlwzq), StandardCharsets.UTF_8); }
	}

	public static ScoreboardObjective fromBuffer(byte[] buffer) {
		ScoreboardObjective ret = new ScoreboardObjective();
		ret.decode(buffer);
		return ret;
	}

}
