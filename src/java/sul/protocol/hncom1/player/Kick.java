/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.player;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Kicks a player from the node and the whole server. When a player is disconnected
 * from the node using this packet the hub will not send the Remove packet.
 */
public class Kick extends Packet {

	public final static byte ID = (byte)13;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public int hubId;
	public String reason;
	public boolean translation;
	public String[] parameters;

	public Kick() {}

	public Kick(int hubId, String reason, boolean translation, String[] parameters) {
		this.hubId = hubId;
		this.reason = reason;
		this.translation = translation;
		this.parameters = parameters;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(hubId) + Buffer.varuintLength(reason.getBytes(StandardCharsets.UTF_8).length) + reason.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(parameters.length) + 2; for(String cgfyyw1ldgvycw:parameters){ length+=Buffer.varuintLength(cgfyyw1ldgvycw.getBytes(StandardCharsets.UTF_8).length)+cgfyyw1ldgvycw.getBytes(StandardCharsets.UTF_8).length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(hubId);
		byte[] cmvhc29u=reason.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cmvhc29u.length); this.writeBytes(cmvhc29u);
		this._buffer[this._index++]=(byte)(translation?1:0);
		if(translation==true){ this.writeVaruint((int)parameters.length); for(String cgfyyw1ldgvycw:parameters){ byte[] y2dmexl3mwxkz3z5=cgfyyw1ldgvycw.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y2dmexl3mwxkz3z5.length); this.writeBytes(y2dmexl3mwxkz3z5); } }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hubId=this.readVaruint();
		int bgvucmvhc29u=this.readVaruint(); reason=new String(this.readBytes(bgvucmvhc29u), StandardCharsets.UTF_8);
		translation=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
		if(translation==true){ int bhbhcmftzxrlcnm=this.readVaruint(); parameters=new String[bhbhcmftzxrlcnm]; for(int cgfyyw1ldgvycw=0;cgfyyw1ldgvycw<parameters.length;cgfyyw1ldgvycw++){ int bgvucgfyyw1ldgvy=this.readVaruint(); parameters[cgfyyw1ldgvycw]=new String(this.readBytes(bgvucgfyyw1ldgvy), StandardCharsets.UTF_8); } }
	}

	public static Kick fromBuffer(byte[] buffer) {
		Kick ret = new Kick();
		ret.decode(buffer);
		return ret;
	}

}