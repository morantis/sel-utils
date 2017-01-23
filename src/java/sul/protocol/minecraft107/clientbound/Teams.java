/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Teams extends Packet {

	public final static int ID = (int)65;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String name;
	public byte mode;

	public Teams() {}

	public Teams(String name, byte mode) {
		this.name = name;
		this.mode = mode;
	}

	@Override
	public int length() {
		return Var.Uint.length() + Var.Uint.length(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] bmftzq=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bmftzq.length); this.writeBytes(bmftzq);
		this.writeBigEndianByte(mode);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		varuint.decode(_buffer, _index);
		int bgvubmftzq=varuint.decode(_buffer, _index); name=new String(this.readBytes(bgvubmftzq), StandardCharsets.UTF_8);
		mode=readBigEndianByte();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static Teams fromBuffer(byte[] buffer) {
		Teams ret = new Teams();
		ret.decode(buffer);
		return ret;
	}

	public class CreateTeam extends Packet {

		public final static byte MODE = (byte)0;

		// friendly flags
		public final static byte FRIENDLY_FIRE = 1;
		public final static byte SEE_TEAM_INVISIBLE_PLAYERS = 2;

		// nametag visibility
		public final static String ALWAYS_HIDE = "always";
		public final static String HIDE_OTHER_TEAMS = "hideOtherTeams";
		public final static String HIDE_OWN_TEAM = "hideOwnTeam";
		public final static String NEVER_HIDE = "never";

		// collision rule
		public final static String ALWAYS_PUSH = "always";
		public final static String PUSH_OTHER_TEAMS = "pushOtherTeams";
		public final static String PUSH_OWN_TEAM = "pushOwnTeam";
		public final static String NEVER_PUSH = "never";

		public String displayName;
		public String prefix;
		public String suffix;
		public byte friendlyFlags;
		public String nametagVisibility;
		public String collisionRule;
		public byte color;
		public String[] players;

		public CreateTeam() {}

		public CreateTeam(String displayName, String prefix, String suffix, byte friendlyFlags, String nametagVisibility, String collisionRule, byte color, String[] players) {
			this.displayName = displayName;
			this.prefix = prefix;
			this.suffix = suffix;
			this.friendlyFlags = friendlyFlags;
			this.nametagVisibility = nametagVisibility;
			this.collisionRule = collisionRule;
			this.color = color;
			this.players = players;
		}

		@Override
		public int length() {
			int length=Var.Uint.length(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(prefix.getBytes(StandardCharsets.UTF_8).length) + prefix.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(suffix.getBytes(StandardCharsets.UTF_8).length) + suffix.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(nametagVisibility.getBytes(StandardCharsets.UTF_8).length) + nametagVisibility.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(collisionRule.getBytes(StandardCharsets.UTF_8).length) + collisionRule.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(players.length) + 2; for(String cgxhewvycw:players){ length+=Var.Uint.length(cgxhewvycw.getBytes(StandardCharsets.UTF_8).length)+cgxhewvycw.getBytes(StandardCharsets.UTF_8).length; } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] zglzcgxheu5hbwu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zglzcgxheu5hbwu.length); this.writeBytes(zglzcgxheu5hbwu);
			byte[] chjlzml4=prefix.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)chjlzml4.length); this.writeBytes(chjlzml4);
			byte[] c3vmzml4=suffix.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c3vmzml4.length); this.writeBytes(c3vmzml4);
			this.writeBigEndianByte(friendlyFlags);
			byte[] bmftzxrhz1zpc2li=nametagVisibility.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bmftzxrhz1zpc2li.length); this.writeBytes(bmftzxrhz1zpc2li);
			byte[] y29sbglzaw9uunvs=collisionRule.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y29sbglzaw9uunvs.length); this.writeBytes(y29sbglzaw9uunvs);
			this.writeBigEndianByte(color);
			this.writeVaruint((int)players.length); for(String cgxhewvycw:players){ byte[] y2d4agv3dnljdw=cgxhewvycw.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y2d4agv3dnljdw.length); this.writeBytes(y2d4agv3dnljdw); }
			return this._buffer;
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bgvuzglzcgxheu5h=varuint.decode(_buffer, _index); displayName=new String(this.readBytes(bgvuzglzcgxheu5h), StandardCharsets.UTF_8);
			int bgvuchjlzml4=varuint.decode(_buffer, _index); prefix=new String(this.readBytes(bgvuchjlzml4), StandardCharsets.UTF_8);
			int bgvuc3vmzml4=varuint.decode(_buffer, _index); suffix=new String(this.readBytes(bgvuc3vmzml4), StandardCharsets.UTF_8);
			friendlyFlags=readBigEndianByte();
			int bgvubmftzxrhz1zp=varuint.decode(_buffer, _index); nametagVisibility=new String(this.readBytes(bgvubmftzxrhz1zp), StandardCharsets.UTF_8);
			int bgvuy29sbglzaw9u=varuint.decode(_buffer, _index); collisionRule=new String(this.readBytes(bgvuy29sbglzaw9u), StandardCharsets.UTF_8);
			color=readBigEndianByte();
			int bhbsyxllcnm=varuint.decode(_buffer, _index); players=new String[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ int bgvucgxhewvyc1tj=varuint.decode(_buffer, _index); players[cgxhewvycw]=new String(this.readBytes(bgvucgxhewvyc1tj), StandardCharsets.UTF_8); }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class RemoveTeam extends Packet {

		public final static byte MODE = (byte)1;

		@Override
		public int length() {
			return 0;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			return this._buffer;
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class UpdateTeamInfo extends Packet {

		public final static byte MODE = (byte)2;

		// friendly flags
		public final static byte FRIENDLY_FIRE = 1;
		public final static byte SEE_TEAM_INVISIBLE_PLAYERS = 2;

		// nametag visibility
		public final static String ALWAYS_HIDE = "always";
		public final static String HIDE_OTHER_TEAMS = "hideOtherTeams";
		public final static String HIDE_OWN_TEAM = "hideOwnTeam";
		public final static String NEVER_HIDE = "never";

		// collision rule
		public final static String ALWAYS_PUSH = "always";
		public final static String PUSH_OTHER_TEAMS = "pushOtherTeams";
		public final static String PUSH_OWN_TEAM = "pushOwnTeam";
		public final static String NEVER_PUSH = "never";

		public String displayName;
		public String prefix;
		public String suffix;
		public byte friendlyFlags;
		public String nametagVisibility;
		public String collisionRule;
		public byte color;

		public UpdateTeamInfo() {}

		public UpdateTeamInfo(String displayName, String prefix, String suffix, byte friendlyFlags, String nametagVisibility, String collisionRule, byte color) {
			this.displayName = displayName;
			this.prefix = prefix;
			this.suffix = suffix;
			this.friendlyFlags = friendlyFlags;
			this.nametagVisibility = nametagVisibility;
			this.collisionRule = collisionRule;
			this.color = color;
		}

		@Override
		public int length() {
			return Var.Uint.length(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(prefix.getBytes(StandardCharsets.UTF_8).length) + prefix.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(suffix.getBytes(StandardCharsets.UTF_8).length) + suffix.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(nametagVisibility.getBytes(StandardCharsets.UTF_8).length) + nametagVisibility.getBytes(StandardCharsets.UTF_8).length + Var.Uint.length(collisionRule.getBytes(StandardCharsets.UTF_8).length) + collisionRule.getBytes(StandardCharsets.UTF_8).length + 2;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] zglzcgxheu5hbwu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zglzcgxheu5hbwu.length); this.writeBytes(zglzcgxheu5hbwu);
			byte[] chjlzml4=prefix.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)chjlzml4.length); this.writeBytes(chjlzml4);
			byte[] c3vmzml4=suffix.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c3vmzml4.length); this.writeBytes(c3vmzml4);
			this.writeBigEndianByte(friendlyFlags);
			byte[] bmftzxrhz1zpc2li=nametagVisibility.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bmftzxrhz1zpc2li.length); this.writeBytes(bmftzxrhz1zpc2li);
			byte[] y29sbglzaw9uunvs=collisionRule.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y29sbglzaw9uunvs.length); this.writeBytes(y29sbglzaw9uunvs);
			this.writeBigEndianByte(color);
			return this._buffer;
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bgvuzglzcgxheu5h=varuint.decode(_buffer, _index); displayName=new String(this.readBytes(bgvuzglzcgxheu5h), StandardCharsets.UTF_8);
			int bgvuchjlzml4=varuint.decode(_buffer, _index); prefix=new String(this.readBytes(bgvuchjlzml4), StandardCharsets.UTF_8);
			int bgvuc3vmzml4=varuint.decode(_buffer, _index); suffix=new String(this.readBytes(bgvuc3vmzml4), StandardCharsets.UTF_8);
			friendlyFlags=readBigEndianByte();
			int bgvubmftzxrhz1zp=varuint.decode(_buffer, _index); nametagVisibility=new String(this.readBytes(bgvubmftzxrhz1zp), StandardCharsets.UTF_8);
			int bgvuy29sbglzaw9u=varuint.decode(_buffer, _index); collisionRule=new String(this.readBytes(bgvuy29sbglzaw9u), StandardCharsets.UTF_8);
			color=readBigEndianByte();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class AddPlayers extends Packet {

		public final static byte MODE = (byte)3;

		public String[] players;

		public AddPlayers() {}

		public AddPlayers(String[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Var.Uint.length(players.length) + 0; for(String cgxhewvycw:players){ length+=Var.Uint.length(cgxhewvycw.getBytes(StandardCharsets.UTF_8).length)+cgxhewvycw.getBytes(StandardCharsets.UTF_8).length; } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(String cgxhewvycw:players){ byte[] y2d4agv3dnljdw=cgxhewvycw.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y2d4agv3dnljdw.length); this.writeBytes(y2d4agv3dnljdw); }
			return this._buffer;
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bhbsyxllcnm=varuint.decode(_buffer, _index); players=new String[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ int bgvucgxhewvyc1tj=varuint.decode(_buffer, _index); players[cgxhewvycw]=new String(this.readBytes(bgvucgxhewvyc1tj), StandardCharsets.UTF_8); }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class RemovePlayers extends Packet {

		public final static byte MODE = (byte)4;

		public String[] players;

		public RemovePlayers() {}

		public RemovePlayers(String[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Var.Uint.length(players.length) + 0; for(String cgxhewvycw:players){ length+=Var.Uint.length(cgxhewvycw.getBytes(StandardCharsets.UTF_8).length)+cgxhewvycw.getBytes(StandardCharsets.UTF_8).length; } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(String cgxhewvycw:players){ byte[] y2d4agv3dnljdw=cgxhewvycw.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y2d4agv3dnljdw.length); this.writeBytes(y2d4agv3dnljdw); }
			return this._buffer;
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bhbsyxllcnm=varuint.decode(_buffer, _index); players=new String[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ int bgvucgxhewvyc1tj=varuint.decode(_buffer, _index); players[cgxhewvycw]=new String(this.readBytes(bgvucgxhewvyc1tj), StandardCharsets.UTF_8); }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

}
