/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import java.util.UUID;

import sul.utils.*;

public class PlayerListItem extends Packet {

	public final static int ID = (int)45;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int action;

	public PlayerListItem() {}

	public PlayerListItem(int action) {
		this.action = action;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(action);
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(action);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		action=this.readVaruint();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static PlayerListItem fromBuffer(byte[] buffer) {
		PlayerListItem ret = new PlayerListItem();
		ret.decode(buffer);
		return ret;
	}

	public class AddPlayer extends Packet {

		public final static int ACTION = (int)0;

		public sul.protocol.minecraft108.types.ListAddPlayer[] players;

		public AddPlayer() {}

		public AddPlayer(sul.protocol.minecraft108.types.ListAddPlayer[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length) + 0; for(sul.protocol.minecraft108.types.ListAddPlayer cgxhewvycw:players){ length+=cgxhewvycw.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.minecraft108.types.ListAddPlayer cgxhewvycw:players){ this.writeBytes(cgxhewvycw.encode()); }
			return this._buffer;
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bhbsyxllcnm=this.readVaruint(); players=new sul.protocol.minecraft108.types.ListAddPlayer[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ players[cgxhewvycw]=new sul.protocol.minecraft108.types.ListAddPlayer(); players[cgxhewvycw]._index=this._index; players[cgxhewvycw].decode(this._buffer); this._index=players[cgxhewvycw]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class UpdateGamemode extends Packet {

		public final static int ACTION = (int)1;

		public sul.protocol.minecraft108.types.ListUpdateGamemode[] players;

		public UpdateGamemode() {}

		public UpdateGamemode(sul.protocol.minecraft108.types.ListUpdateGamemode[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length) + 0; for(sul.protocol.minecraft108.types.ListUpdateGamemode cgxhewvycw:players){ length+=cgxhewvycw.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.minecraft108.types.ListUpdateGamemode cgxhewvycw:players){ this.writeBytes(cgxhewvycw.encode()); }
			return this._buffer;
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bhbsyxllcnm=this.readVaruint(); players=new sul.protocol.minecraft108.types.ListUpdateGamemode[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ players[cgxhewvycw]=new sul.protocol.minecraft108.types.ListUpdateGamemode(); players[cgxhewvycw]._index=this._index; players[cgxhewvycw].decode(this._buffer); this._index=players[cgxhewvycw]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class UpdateLatency extends Packet {

		public final static int ACTION = (int)2;

		public sul.protocol.minecraft108.types.ListUpdateLatency[] players;

		public UpdateLatency() {}

		public UpdateLatency(sul.protocol.minecraft108.types.ListUpdateLatency[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length) + 0; for(sul.protocol.minecraft108.types.ListUpdateLatency cgxhewvycw:players){ length+=cgxhewvycw.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.minecraft108.types.ListUpdateLatency cgxhewvycw:players){ this.writeBytes(cgxhewvycw.encode()); }
			return this._buffer;
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bhbsyxllcnm=this.readVaruint(); players=new sul.protocol.minecraft108.types.ListUpdateLatency[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ players[cgxhewvycw]=new sul.protocol.minecraft108.types.ListUpdateLatency(); players[cgxhewvycw]._index=this._index; players[cgxhewvycw].decode(this._buffer); this._index=players[cgxhewvycw]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class UpdateDisplayName extends Packet {

		public final static int ACTION = (int)3;

		public sul.protocol.minecraft108.types.ListUpdateDisplayName[] players;

		public UpdateDisplayName() {}

		public UpdateDisplayName(sul.protocol.minecraft108.types.ListUpdateDisplayName[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length) + 0; for(sul.protocol.minecraft108.types.ListUpdateDisplayName cgxhewvycw:players){ length+=cgxhewvycw.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.minecraft108.types.ListUpdateDisplayName cgxhewvycw:players){ this.writeBytes(cgxhewvycw.encode()); }
			return this._buffer;
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bhbsyxllcnm=this.readVaruint(); players=new sul.protocol.minecraft108.types.ListUpdateDisplayName[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ players[cgxhewvycw]=new sul.protocol.minecraft108.types.ListUpdateDisplayName(); players[cgxhewvycw]._index=this._index; players[cgxhewvycw].decode(this._buffer); this._index=players[cgxhewvycw]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class RemovePlayer extends Packet {

		public final static int ACTION = (int)4;

		public UUID[] players;

		public RemovePlayer() {}

		public RemovePlayer(UUID[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(players.length) + players.length*16;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(UUID cgxhewvycw:players){ this.writeBigEndianLong(cgxhewvycw.getLeastSignificantBits()); this.writeBigEndianLong(cgxhewvycw.getMostSignificantBits()); }
			return this._buffer;
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bhbsyxllcnm=this.readVaruint(); players=new UUID[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ long bxbsyxllcnnby2d4=readBigEndianLong(); long bhbsyxllcnnby2d4=readBigEndianLong(); players[cgxhewvycw]=new UUID(bxbsyxllcnnby2d4,bhbsyxllcnnby2d4); }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

}