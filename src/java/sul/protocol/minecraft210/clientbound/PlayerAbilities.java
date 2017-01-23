/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import sul.utils.*;

public class PlayerAbilities extends Packet {

	public final static int ID = (int)43;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// flags
	public final static byte INVULNERABLE = 1;
	public final static byte FLYING = 2;
	public final static byte ALLOW_FLYING = 4;
	public final static byte CREATIVE_MODE = 8;

	public byte flags;
	public float flyingSpeed;
	public float fovModifier;

	public PlayerAbilities() {}

	public PlayerAbilities(byte flags, float flyingSpeed, float fovModifier) {
		this.flags = flags;
		this.flyingSpeed = flyingSpeed;
		this.fovModifier = fovModifier;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(flags);
		this.writeBigEndianFloat(flyingSpeed);
		this.writeBigEndianFloat(fovModifier);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		flags=readBigEndianByte();
		flyingSpeed=readBigEndianFloat();
		fovModifier=readBigEndianFloat();
	}

	public static PlayerAbilities fromBuffer(byte[] buffer) {
		PlayerAbilities ret = new PlayerAbilities();
		ret.decode(buffer);
		return ret;
	}

}