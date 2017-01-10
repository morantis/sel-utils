/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
module sul.protocol.hncom1.types;

import std.bitmanip : write, peek;
import std.conv : to;
import std.system : Endian;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.buffer;
import sul.utils.var;

struct Plugin {

	public string name;
	public string vers;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBytes(varuint.encode(cast(uint)name.length)); writeString(name);
			writeBytes(varuint.encode(cast(uint)vers.length)); writeString(vers);
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			uint bmftzq=varuint.decode(_buffer, &_index); name=readString(bmftzq);
			uint dmvycw=varuint.decode(_buffer, &_index); vers=readString(dmvycw);
		}
	}

}

/**
 * Internet protocol address. Could be either version 4 and 6.
 */
struct Address {

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
			writeBigEndianUshort(port);
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			bytes.length=varuint.decode(_buffer, &_index); if(_buffer.length>=_index+bytes.length){ bytes=_buffer[_index.._index+bytes.length].dup; _index+=bytes.length; }
			port=readBigEndianUshort();
		}
	}

}

struct Game {

	// type
	public enum ubyte POCKET = 1;
	public enum ubyte MINECRAFT = 2;

	public ubyte type;
	public uint[] protocols;
	public string motd;
	public ushort port;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBigEndianUbyte(type);
			writeBytes(varuint.encode(cast(uint)protocols.length)); foreach(chjvdg9jb2xz;protocols){ writeBytes(varuint.encode(chjvdg9jb2xz)); }
			writeBytes(varuint.encode(cast(uint)motd.length)); writeString(motd);
			writeBigEndianUshort(port);
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			type=readBigEndianUbyte();
			protocols.length=varuint.decode(_buffer, &_index); foreach(ref chjvdg9jb2xz;protocols){ chjvdg9jb2xz=varuint.decode(_buffer, &_index); }
			uint bw90za=varuint.decode(_buffer, &_index); motd=readString(bw90za);
			port=readBigEndianUshort();
		}
	}

}

struct Skin {

	public string name;
	public ubyte[] data;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBytes(varuint.encode(cast(uint)name.length)); writeString(name);
			writeBytes(varuint.encode(cast(uint)data.length)); writeBytes(data);
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			uint bmftzq=varuint.decode(_buffer, &_index); name=readString(bmftzq);
			data.length=varuint.decode(_buffer, &_index); if(_buffer.length>=_index+data.length){ data=_buffer[_index.._index+data.length].dup; _index+=data.length; }
		}
	}

}

struct Log {

	public ulong timestamp;
	public string logger;
	public string message;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeLittleEndianUlong(timestamp);
			writeBytes(varuint.encode(cast(uint)logger.length)); writeString(logger);
			writeBytes(varuint.encode(cast(uint)message.length)); writeString(message);
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			timestamp=readLittleEndianUlong();
			uint bg9nz2vy=varuint.decode(_buffer, &_index); logger=readString(bg9nz2vy);
			uint bwvzc2fnzq=varuint.decode(_buffer, &_index); message=readString(bwvzc2fnzq);
		}
	}

}
