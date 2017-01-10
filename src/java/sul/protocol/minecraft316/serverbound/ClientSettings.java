/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.serverbound;

import java.util.UUID;

import sul.protocol.minecraft316.types.*;
import sul.utils.*;

class ClientSettings extends Packet {

	public final static int ID = (int)4;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// chat mode
	public static immutable int ENABLED = 0;
	public static immutable int COMMANDS_ONLY = 1;
	public static immutable int DISABLED = 2;

	// displayed skin parts
	public static immutable byte CAPE = 1;
	public static immutable byte JACKET = 2;
	public static immutable byte LEFT_SLEEVE = 4;
	public static immutable byte RIGHT_SLEEVE = 8;
	public static immutable byte LEFT_PANTS = 16;
	public static immutable byte RIGHT_PANTS = 32;
	public static immutable byte HAT = 64;

	// main hand
	public static immutable byte RIGHT = 0;
	public static immutable byte LEFT = 1;

	public String language;
	public byte viewDistance;
	public int chatMode;
	public boolean chatColors;
	public byte displayedSkinParts;
	public byte mainHand;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeVaruint(ID);
		byte[] bgfuz3vhz2u=language.getBytes("UTF-8"); this.writeVaruint((int)bgfuz3vhz2u.length); this.writeBytes(bgfuz3vhz2u);
		this.writeByteB(viewDistance);
		this.writeVaruint(chatMode);
		this.writeBoolB(chatColors);
		this.writeByteB(displayedSkinParts);
		this.writeByteB(mainHand);
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}
