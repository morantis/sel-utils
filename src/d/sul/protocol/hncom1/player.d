/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
module sul.protocol.hncom1.player;

import std.bitmanip : write, peek;
import std.conv : to;
import std.system : Endian;
import std.typetuple : TypeTuple;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.buffer;
import sul.utils.var;

static import sul.protocol.hncom1.types;

alias Packets = TypeTuple!(Add, Remove, Kick, Transfer, UpdateLanguage, UpdateDisplayName, UpdateLatency, UpdatePacketLoss, GamePacket, OrderedGamePacket);

/**
 * Adds a player to the node.
 */
class Add : Buffer {

	public enum ubyte ID = 11;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	// reason
	public enum ubyte FIRST_JOIN = 0;
	public enum ubyte TRANSFERRED = 1;
	public enum ubyte FORCIBLY_TRANSFERRED = 2;

	public enum string[] FIELDS = ["hubId", "reason", "type", "protocol", "username", "displayName", "address", "uuid", "skin", "latency", "language"];

	/**
	 * A unique identifier given by the hub that is never changed while the player is connected.
	 */
	public uint hubId;

	/**
	 * Reason why the player has joined the node.
	 */
	public ubyte reason;

	/**
	 * Game of the client, which could either be Minecraft or Minecraft: Pocket Edition.
	 */
	public ubyte type;

	/**
	 * Version of the protocol used by the client.
	 */
	public uint protocol;

	/**
	 * Username of the player.
	 */
	public string username;

	/**
	 * Display name of the player, which can contain formatting codes. It can be updated
	 * by the node.
	 */
	public string displayName;
	public sul.protocol.hncom1.types.Address address;
	public UUID uuid;
	public sul.protocol.hncom1.types.Skin skin;
	public uint latency;
	public string language;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint hubId, ubyte reason=ubyte.init, ubyte type=ubyte.init, uint protocol=uint.init, string username=string.init, string displayName=string.init, sul.protocol.hncom1.types.Address address=sul.protocol.hncom1.types.Address.init, UUID uuid=UUID.init, sul.protocol.hncom1.types.Skin skin=sul.protocol.hncom1.types.Skin.init, uint latency=uint.init, string language=string.init) {
		this.hubId = hubId;
		this.reason = reason;
		this.type = type;
		this.protocol = protocol;
		this.username = username;
		this.displayName = displayName;
		this.address = address;
		this.uuid = uuid;
		this.skin = skin;
		this.latency = latency;
		this.language = language;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(hubId));
		writeBigEndianUbyte(reason);
		writeBigEndianUbyte(type);
		writeBytes(varuint.encode(protocol));
		writeBytes(varuint.encode(cast(uint)username.length)); writeString(username);
		writeBytes(varuint.encode(cast(uint)displayName.length)); writeString(displayName);
		address.encode(bufferInstance);
		writeBytes(uuid.data);
		skin.encode(bufferInstance);
		writeBytes(varuint.encode(latency));
		writeBytes(varuint.encode(cast(uint)language.length)); writeString(language);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hubId=varuint.decode(_buffer, &_index);
		reason=readBigEndianUbyte();
		type=readBigEndianUbyte();
		protocol=varuint.decode(_buffer, &_index);
		uint dxnlcm5hbwu=varuint.decode(_buffer, &_index); username=readString(dxnlcm5hbwu);
		uint zglzcgxheu5hbwu=varuint.decode(_buffer, &_index); displayName=readString(zglzcgxheu5hbwu);
		address.decode(bufferInstance);
		if(_buffer.length>=_index+16){ ubyte[16] dxvpza=_buffer[_index.._index+16].dup; _index+=16; uuid=UUID(dxvpza); }
		skin.decode(bufferInstance);
		latency=varuint.decode(_buffer, &_index);
		uint bgfuz3vhz2u=varuint.decode(_buffer, &_index); language=readString(bgfuz3vhz2u);
	}

	public static pure nothrow @safe Add fromBuffer(bool readId=true)(ubyte[] buffer) {
		Add ret = new Add();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	alias _encode = encode;

	enum string variantField = "type";

	alias Variants = TypeTuple!(Pocket, Minecraft);

	public class Pocket {

		public enum typeof(type) TYPE = 1;

		public enum string[] FIELDS = ["xuid", "edu", "packetLoss"];

		public long xuid;
		public bool edu;
		public float packetLoss;

		public pure nothrow @safe @nogc this() {}

		public pure nothrow @safe @nogc this(long xuid, bool edu=bool.init, float packetLoss=float.init) {
			this.xuid = xuid;
			this.edu = edu;
			this.packetLoss = packetLoss;
		}

		public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
			type = 1;
			_encode!writeId();
			writeBytes(varlong.encode(xuid));
			writeBigEndianBool(edu);
			writeBigEndianFloat(packetLoss);
			return _buffer;
		}

		public pure nothrow @safe void decode() {
			xuid=varlong.decode(_buffer, &_index);
			edu=readBigEndianBool();
			packetLoss=readBigEndianFloat();
		}

	}

	public class Minecraft {

		public enum typeof(type) TYPE = 2;

		public enum string[] FIELDS = [];

		public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
			type = 2;
			_encode!writeId();
			return _buffer;
		}

		public pure nothrow @safe void decode() {
		}

	}

}

/**
 * Removes a player from the node.
 */
class Remove : Buffer {

	public enum ubyte ID = 12;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	// reason
	public enum ubyte LEFT = 0;
	public enum ubyte TIMED_OUT = 1;
	public enum ubyte KICKED = 2;
	public enum ubyte TRANSFERRED = 3;

	public enum string[] FIELDS = ["hubId", "reason"];

	public uint hubId;
	public ubyte reason;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint hubId, ubyte reason=ubyte.init) {
		this.hubId = hubId;
		this.reason = reason;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(hubId));
		writeBigEndianUbyte(reason);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hubId=varuint.decode(_buffer, &_index);
		reason=readBigEndianUbyte();
	}

	public static pure nothrow @safe Remove fromBuffer(bool readId=true)(ubyte[] buffer) {
		Remove ret = new Remove();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

/**
 * Kicks a player from the node and the whole server. When a player is disconnected
 * from the node using this packet the hub will not send the Remove packet.
 */
class Kick : Buffer {

	public enum ubyte ID = 13;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["hubId", "reason", "translation", "parameters"];

	public uint hubId;
	public string reason;
	public bool translation;
	public string[] parameters;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint hubId, string reason=string.init, bool translation=bool.init, string[] parameters=(string[]).init) {
		this.hubId = hubId;
		this.reason = reason;
		this.translation = translation;
		this.parameters = parameters;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(hubId));
		writeBytes(varuint.encode(cast(uint)reason.length)); writeString(reason);
		writeBigEndianBool(translation);
		if(translation==true){ writeBytes(varuint.encode(cast(uint)parameters.length)); foreach(cgfyyw1ldgvycw;parameters){ writeBytes(varuint.encode(cast(uint)cgfyyw1ldgvycw.length)); writeString(cgfyyw1ldgvycw); } }
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hubId=varuint.decode(_buffer, &_index);
		uint cmvhc29u=varuint.decode(_buffer, &_index); reason=readString(cmvhc29u);
		translation=readBigEndianBool();
		if(translation==true){ parameters.length=varuint.decode(_buffer, &_index); foreach(ref cgfyyw1ldgvycw;parameters){ uint y2dmexl3mwxkz3z5=varuint.decode(_buffer, &_index); cgfyyw1ldgvycw=readString(y2dmexl3mwxkz3z5); } }
	}

	public static pure nothrow @safe Kick fromBuffer(bool readId=true)(ubyte[] buffer) {
		Kick ret = new Kick();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

/**
 * Transfers a player to another node. When a player is transferred from the node the
 * hub will not send the Remove packet and there's no way, for the node, to know whether
 * the player was disconnected or successfully transferred.
 */
class Transfer : Buffer {

	public enum ubyte ID = 14;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["hubId", "node"];

	public uint hubId;
	public string node;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint hubId, string node=string.init) {
		this.hubId = hubId;
		this.node = node;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(hubId));
		writeBytes(varuint.encode(cast(uint)node.length)); writeString(node);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hubId=varuint.decode(_buffer, &_index);
		uint bm9kzq=varuint.decode(_buffer, &_index); node=readString(bm9kzq);
	}

	public static pure nothrow @safe Transfer fromBuffer(bool readId=true)(ubyte[] buffer) {
		Transfer ret = new Transfer();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

/**
 * Updates the player language after the client has changed it.
 */
class UpdateLanguage : Buffer {

	public enum ubyte ID = 15;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["hubId", "language"];

	public uint hubId;
	public string language;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint hubId, string language=string.init) {
		this.hubId = hubId;
		this.language = language;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(hubId));
		writeBytes(varuint.encode(cast(uint)language.length)); writeString(language);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hubId=varuint.decode(_buffer, &_index);
		uint bgfuz3vhz2u=varuint.decode(_buffer, &_index); language=readString(bgfuz3vhz2u);
	}

	public static pure nothrow @safe UpdateLanguage fromBuffer(bool readId=true)(ubyte[] buffer) {
		UpdateLanguage ret = new UpdateLanguage();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class UpdateDisplayName : Buffer {

	public enum ubyte ID = 16;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["hubId", "displayName"];

	public uint hubId;
	public string displayName;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint hubId, string displayName=string.init) {
		this.hubId = hubId;
		this.displayName = displayName;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(hubId));
		writeBytes(varuint.encode(cast(uint)displayName.length)); writeString(displayName);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hubId=varuint.decode(_buffer, &_index);
		uint zglzcgxheu5hbwu=varuint.decode(_buffer, &_index); displayName=readString(zglzcgxheu5hbwu);
	}

	public static pure nothrow @safe UpdateDisplayName fromBuffer(bool readId=true)(ubyte[] buffer) {
		UpdateDisplayName ret = new UpdateDisplayName();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class UpdateLatency : Buffer {

	public enum ubyte ID = 17;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["hubId", "latency"];

	public uint hubId;
	public uint latency;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint hubId, uint latency=uint.init) {
		this.hubId = hubId;
		this.latency = latency;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(hubId));
		writeBytes(varuint.encode(latency));
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hubId=varuint.decode(_buffer, &_index);
		latency=varuint.decode(_buffer, &_index);
	}

	public static pure nothrow @safe UpdateLatency fromBuffer(bool readId=true)(ubyte[] buffer) {
		UpdateLatency ret = new UpdateLatency();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class UpdatePacketLoss : Buffer {

	public enum ubyte ID = 18;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["hubId", "packetLoss"];

	public uint hubId;
	public float packetLoss;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint hubId, float packetLoss=float.init) {
		this.hubId = hubId;
		this.packetLoss = packetLoss;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(hubId));
		writeBigEndianFloat(packetLoss);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hubId=varuint.decode(_buffer, &_index);
		packetLoss=readBigEndianFloat();
	}

	public static pure nothrow @safe UpdatePacketLoss fromBuffer(bool readId=true)(ubyte[] buffer) {
		UpdatePacketLoss ret = new UpdatePacketLoss();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

/**
 * Sends data to client or handles data received from the client.
 */
class GamePacket : Buffer {

	public enum ubyte ID = 19;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["hubId", "packet"];

	public uint hubId;
	public ubyte[] packet;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint hubId, ubyte[] packet=(ubyte[]).init) {
		this.hubId = hubId;
		this.packet = packet;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(hubId));
		writeBytes(packet);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hubId=varuint.decode(_buffer, &_index);
		packet=_buffer[_index..$].dup; _index=_buffer.length;
	}

	public static pure nothrow @safe GamePacket fromBuffer(bool readId=true)(ubyte[] buffer) {
		GamePacket ret = new GamePacket();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

/**
 * Sends data to the client but order it because it could be sent by the node unordered,
 * due to compressed packet sent delayed.
 */
class OrderedGamePacket : Buffer {

	public enum ubyte ID = 20;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["hubId", "order", "packet"];

	public uint hubId;
	public uint order;
	public ubyte[] packet;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint hubId, uint order=uint.init, ubyte[] packet=(ubyte[]).init) {
		this.hubId = hubId;
		this.order = order;
		this.packet = packet;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(hubId));
		writeBytes(varuint.encode(order));
		writeBytes(packet);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hubId=varuint.decode(_buffer, &_index);
		order=varuint.decode(_buffer, &_index);
		packet=_buffer[_index..$].dup; _index=_buffer.length;
	}

	public static pure nothrow @safe OrderedGamePacket fromBuffer(bool readId=true)(ubyte[] buffer) {
		OrderedGamePacket ret = new OrderedGamePacket();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}
