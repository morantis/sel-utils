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

public class WindowProperty extends Packet {

	public final static int ID = (int)49;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// property
	public final static short FURNANCE_FIRE_ICON = 0;
	public final static short FURNACE_MAX_FUEL_BURN_TIME = 1;
	public final static short FURNACE_PROGRESS_ARROW = 2;
	public final static short FURNCE_MAX_PROGRESS = 3;
	public final static short ENCHANTMENT_LEVEL_REQUIREMENT_TOP = 0;
	public final static short ENCHANTMENT_LEVEL_REQUIREMENT_MIDDLE = 1;
	public final static short ENCHANTMENT_LEVEL_REQUIREMENT_BOTTOM = 2;
	public final static short ENCHANTMENT_SEED = 3;
	public final static short ENCHANTMENT_ID_TOP = 4;
	public final static short ENCHANTMENT_ID_MIDDLE = 5;
	public final static short ENCHANTMENT_ID_BOTTOM = 6;
	public final static short ENCHANTMENT_LEVEL_TOP = 7;
	public final static short ENCHANTMENT_LEVEL_MIDDLE = 8;
	public final static short ENCHANTMENT_LEVEL_BOTTOM = 9;
	public final static short BEACON_POWER_LEVEL = 0;
	public final static short BEACON_FIRST_EFFECT = 1;
	public final static short BEACON_SECOND_EFFECT = 2;
	public final static short ANVIL_REPAIR_COST = 0;
	public final static short BREWING_STAND_BREW_TIME = 0;

	public byte window;
	public short property;
	public short value;

	public WindowProperty() {}

	public WindowProperty(byte window, short property, short value) {
		this.window = window;
		this.property = property;
		this.value = value;
	}

	@Override
	public int length() {
		return Var.Uint.length() + 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianShort(property);
		this.writeBigEndianShort(value);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		window=readBigEndianByte();
		property=readBigEndianShort();
		value=readBigEndianShort();
	}

	public static WindowProperty fromBuffer(byte[] buffer) {
		WindowProperty ret = new WindowProperty();
		ret.decode(buffer);
		return ret;
	}

}
