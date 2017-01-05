// This file has been automatically generated by sel-utils
// https://github.com/sel-project/sel-utils
package sul.constants;

final class Minecraft315 {

	private Minecraft315() {}

	public final static class PlayerDigging {

		public final static class status {

			public final static long FINISHED_DIGGING = 2;
			public final static long DROP_ITEM_STACK = 3;
			public final static long DROP_ITEM = 4;
			public final static long SWAP_ITEM_IN_HAND = 6;
			public final static long RELEASE_ITEM = 5;
			public final static long STARTED_DIGGING = 0;
			public final static long CANCELLED_DIGGING = 1;

		}

	}

	public final static class EntityAction {

		public final static class action {

			public final static long START_ELYTRA_FLYING = 8;
			public final static long OPEN_HORSE_INVENTORY = 7;
			public final static long START_SPRINTING = 3;
			public final static long LEAVE_BED = 2;
			public final static long START_HORSE_JUMP = 5;
			public final static long STOP_HORSE_JUMP = 6;
			public final static long START_SNEAKING = 0;
			public final static long STOP_SPRINTING = 4;
			public final static long STOP_SNEAKING = 1;

		}

	}

	public final static class ClientStatus {

		public final static class action {

			public final static long REQUEST_STATS = 1;
			public final static long OPEN_INVENTORY = 2;
			public final static long RESPAWN = 0;

		}

	}

	public final static class WindowProperty {

		public final static class property {

			public final static int FIRE_ICON = 0;
			public final static int MAXIMUM_FUEL_BURN_TIME = 1;
			public final static int LEVEL_REQUIREMENT_FOR_BOTTOM_ENCHANTMENT_SLOT = 2;
			public final static int SECOND_POTION_EFFECT = 2;
			public final static int ENCHANTMENT_SEED = 3;
			public final static int REPAIR_COST = 0;
			public final static int PROGRESS_ARROW = 2;
			public final static int LEVEL_REQUIREMENT_FOR_TOP_ENCHANTMENT_SLOT = 0;
			public final static int POWER_LEVEL = 0;
			public final static int LEVEL_REQUIREMENT_FOR_MIDDLE_ENCHANTMENT_SLOT = 1;
			public final static int FIRST_POTION_EFFECT = 1;
			public final static int BREW_TIME = 0;
			public final static int MAXIMUM_PROGRESS = 3;

		}

	}

	public final static class AnimationClientbound {

		public final static class animation {

			public final static short SWING_OFFHAND = 3;
			public final static short CRITICAL_EFFECT = 4;
			public final static short SWING_MAIN_ARM = 0;
			public final static short TAKE_DAMAGE = 1;
			public final static short MAGICAL_CRITICAL_EFFECT = 5;
			public final static short LEAVE_BED = 2;

		}

	}

	public final static class SpawnGlobalEntity {

		public final static class type {

			public final static short THUNDERBOLT = 1;

		}

	}

	public final static class ScoreboardObjective {

		public final static class mode {

			public final static short REMOVE = 1;
			public final static short UPDATE = 2;
			public final static short CREATE = 0;

		}

	}

	public final static class Handshake {

		public final static class next {

			public final static long LOGIN = 2;
			public final static long STATUS = 1;

		}

	}

	public final static class Title {

		public final static class action {

			public final static long SET_SUBTITLE = 1;
			public final static long SET_TITLE = 0;
			public final static long SET_TIMES_AND_DISPLAY = 2;
			public final static long RESET = 4;
			public final static long HIDE = 3;

		}

	}

	public final static class ChangeGameState {

		public final static class value {

			public final static float BRIGHT = 0;
			public final static float DARK = 1;
			public final static float RESPAWN = 0;
			public final static float SHOW_CREDITS = 1;
			public final static float SHOW_MOVEMENT_CONTROLS = 101;
			public final static float SHOW_JUMP_CONTROLS = 102;
			public final static float SHOW_WELCOME_DEMO = 0;
			public final static float SHOW_INVENTORY_CONTROLS = 103;

		}

		public final static class reason {

			public final static short FADE_TIME = 8;
			public final static short ARROW_HITTING_PLAYER = 6;
			public final static short INVALID_BED = 0;
			public final static short END_RAINING = 1;
			public final static short EXIT_END = 4;
			public final static short ELDER_GUARDIAN_APPEARANCE = 10;
			public final static short FADE_VALUE = 7;
			public final static short DEMO_MESSAGE = 5;
			public final static short BEGIN_RAINING = 2;
			public final static short CHANGE_GAMEMODE = 3;

		}

	}

	public final static class UpdateScore {

		public final static class action {

			public final static short REMOVE = 1;
			public final static short UPDATE = 0;

		}

	}

	public final static class PlayerAbilities {

		public final static class flags {

			public final static short CREATIVE_MODE = 8;
			public final static short ALLOW_FLYING = 4;
			public final static short FLYING = 2;
			public final static short INVULNERABLE = 1;

		}

	}

	public final static class DisplayScoreboard {

		public final static class position {

			public final static short LIST = 0;
			public final static short SIDEBAR = 1;
			public final static short BELOW_NAME = 2;

		}

	}

	public final static class EntityStatus {

		public final static class status {

			public final static short HURT = 2;
			public final static short DEATH = 3;

		}

	}

	public final static class ChatMessageClientbound {

		public final static class position {

			public final static short CHAT = 0;
			public final static short SYSTEM_MESSAGE = 1;
			public final static short ABOVE_HOTBAR = 2;

		}

	}

	public final static class UseEntity {

		public final static class type {

			public final static long INTERACT_AT = 2;
			public final static long INTERACT = 0;
			public final static long ATTACK = 1;

		}

	}

	public final static class Map {

		public final static class iconType {

			public final static int FAR_AWAY_PLAYER = 8;
			public final static int WHITE_CROSS = 4;
			public final static int BLUE_SQUARE = 7;
			public final static int TEMPLE = 10;
			public final static int GREEN_ARROW = 1;
			public final static int RED_ARROW = 2;
			public final static int WHITE_CIRCLE = 6;
			public final static int MANSION = 9;
			public final static int BLUE_ARROW = 3;
			public final static int RED_POINTER = 5;
			public final static int WHITE_ARROW = 0;

		}

	}

	public final static class AnimationServerbound {

		public final static class hand {

			public final static long LEFT = 1;
			public final static long RIGHT = 0;

		}

	}

}