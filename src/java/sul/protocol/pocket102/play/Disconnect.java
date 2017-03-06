/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket102.xml
 */
package sul.protocol.pocket102.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Disconnects the player from the server.
 */
public class Disconnect extends Packet {

	public static final byte ID = (byte)5;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Indicates whether to display the main menu screen or a disconnection message.
	 */
	public boolean hideDisconnectionScreen;

	/**
	 * The message to display in the disconnection screen. If the message is in the game's
	 * language file it will be translated client-side.
	 */
	public String message;

	public Disconnect() {}

	public Disconnect(boolean hideDisconnectionScreen, String message) {
		this.hideDisconnectionScreen = hideDisconnectionScreen;
		this.message = message;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBool(hideDisconnectionScreen);
		if(hideDisconnectionScreen==false){ byte[] bvcfz=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bvcfz.length); this.writeBytes(bvcfz); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hideDisconnectionScreen=this.readBool();
		if(hideDisconnectionScreen==false){ int bvbvcfz=this.readVaruint(); message=new String(this.readBytes(bvbvcfz), StandardCharsets.UTF_8); }
	}

	public static Disconnect fromBuffer(byte[] buffer) {
		Disconnect ret = new Disconnect();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Disconnect(hideDisconnectionScreen: " + this.hideDisconnectionScreen + ", message: " + this.message + ")";
	}

}
