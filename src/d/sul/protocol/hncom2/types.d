/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
module sul.protocol.hncom2.types;

import std.bitmanip : write, peek;
static import std.conv;
import std.system : Endian;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.buffer;
import sul.utils.var;

static if(__traits(compiles, { import sul.metadata.hncom2; })) import sul.metadata.hncom2;

/**
 * Internet protocol address. Could be either version 4 or 6.
 */
struct Address {

	public enum string[] FIELDS = ["bytes", "port"];

	/**
	 * Bytes of the address. The length may be 4 (for ipv4 addresses) or 16 (for ipv6 addresses).
	 * The byte order is always big-endian (network order).
	 */
	public ubyte[] bytes;

	/**
	 * Port of the address.
	 */
	public ushort port;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBytes(varuint.encode(cast(uint)bytes.length)); writeBytes(bytes);
			writeLittleEndianUshort(port);
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			bytes.length=varuint.decode(_buffer, &_index); if(_buffer.length>=_index+bytes.length){ bytes=_buffer[_index.._index+bytes.length].dup; _index+=bytes.length; }
			port=readLittleEndianUshort();
		}
	}

	public string toString() {
		return "Address(bytes: " ~ std.conv.to!string(this.bytes) ~ ", port: " ~ std.conv.to!string(this.port) ~ ")";
	}

}

/**
 * Indicates a game and informations about its accepted protocols.
 */
struct Game {

	// type
	public enum ubyte POCKET = 1;
	public enum ubyte MINECRAFT = 2;
	public enum ubyte CONSOLE = 3;

	public enum string[] FIELDS = ["type", "protocols"];

	/**
	 * Identifier of the game.
	 */
	public ubyte type;

	/**
	 * Protocols accepted by the server for the game. They should be ordered from oldest
	 * to newest.
	 */
	public uint[] protocols;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBigEndianUbyte(type);
			writeBytes(varuint.encode(cast(uint)protocols.length)); foreach(cjd9bx;protocols){ writeBytes(varuint.encode(cjd9bx)); }
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			type=readBigEndianUbyte();
			protocols.length=varuint.decode(_buffer, &_index); foreach(ref cjd9bx;protocols){ cjd9bx=varuint.decode(_buffer, &_index); }
		}
	}

	public string toString() {
		return "Game(type: " ~ std.conv.to!string(this.type) ~ ", protocols: " ~ std.conv.to!string(this.protocols) ~ ")";
	}

}

/**
 * Indicates a game and informations about it.
 */
struct GameInfo {

	public enum string[] FIELDS = ["game", "motd", "port"];

	/**
	 * Informations about the the game and the protocols used.
	 */
	public sul.protocol.hncom2.types.Game game;

	/**
	 * "Message of the day" which is displayed in the game's server list. It may contain
	 * Minecraft formatting codes.
	 */
	public string motd;

	/**
	 * Port, or main port if the server allows the connection from multiple ports, where
	 * the socket is listening for connections.
	 */
	public ushort port;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			game.encode(bufferInstance);
			writeBytes(varuint.encode(cast(uint)motd.length)); writeString(motd);
			writeLittleEndianUshort(port);
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			game.decode(bufferInstance);
			uint b9z=varuint.decode(_buffer, &_index); motd=readString(b9z);
			port=readLittleEndianUshort();
		}
	}

	public string toString() {
		return "GameInfo(game: " ~ std.conv.to!string(this.game) ~ ", motd: " ~ std.conv.to!string(this.motd) ~ ", port: " ~ std.conv.to!string(this.port) ~ ")";
	}

}

/**
 * A plugin loaded on the node. It may be used by the hub to display the plugins loaded
 * on the server in queries.
 */
struct Plugin {

	public enum string[] FIELDS = ["name", "vers"];

	/**
	 * Name of the plugin.
	 */
	public string name;

	/**
	 * Version of the plugin, usually in the format `major.minor[.release] [alpha|beta]`.
	 */
	public string vers;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBytes(varuint.encode(cast(uint)name.length)); writeString(name);
			writeBytes(varuint.encode(cast(uint)vers.length)); writeString(vers);
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			uint bfz=varuint.decode(_buffer, &_index); name=readString(bfz);
			uint dvc=varuint.decode(_buffer, &_index); vers=readString(dvc);
		}
	}

	public string toString() {
		return "Plugin(name: " ~ std.conv.to!string(this.name) ~ ", vers: " ~ std.conv.to!string(this.vers) ~ ")";
	}

}

struct Motd {

	// type
	public enum ubyte POCKET = 1;
	public enum ubyte MINECRAFT = 2;
	public enum ubyte CONSOLE = 3;

	public enum string[] FIELDS = ["type", "motd"];

	public ubyte type;
	public string motd;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBigEndianUbyte(type);
			writeBytes(varuint.encode(cast(uint)motd.length)); writeString(motd);
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			type=readBigEndianUbyte();
			uint b9z=varuint.decode(_buffer, &_index); motd=readString(b9z);
		}
	}

	public string toString() {
		return "Motd(type: " ~ std.conv.to!string(this.type) ~ ", motd: " ~ std.conv.to!string(this.motd) ~ ")";
	}

}

/**
 * Player's skin that will be sent to Minecraft: Pocket Edition clients.
 * If the server only allows Minecraft players this type's fields should be empty.
 */
struct Skin {

	public enum string[] FIELDS = ["name", "data"];

	/**
	 * Name of the skin.
	 */
	public string name;

	/**
	 * RGBA map of the skin colours. Length should be, if the skin is not empty, 8192 (64x32)
	 * or 16384 (64x64) bytes.
	 */
	public ubyte[] data;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBytes(varuint.encode(cast(uint)name.length)); writeString(name);
			writeBytes(varuint.encode(cast(uint)data.length)); writeBytes(data);
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			uint bfz=varuint.decode(_buffer, &_index); name=readString(bfz);
			data.length=varuint.decode(_buffer, &_index); if(_buffer.length>=_index+data.length){ data=_buffer[_index.._index+data.length].dup; _index+=data.length; }
		}
	}

	public string toString() {
		return "Skin(name: " ~ std.conv.to!string(this.name) ~ ", data: " ~ std.conv.to!string(this.data) ~ ")";
	}

}