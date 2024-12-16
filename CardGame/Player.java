// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.core;

/**
 * Represents a player on the board, which can be either a computer player or a
 * human. Every player has a direction (North, East, South, West) and a hand of
 * cards which they are currently playing.
 *
 * @author David J. Pearce
 *
 */
public class Player implements Cloneable{//create clone of player
	/**
	 * Represents one of the four position on the table (North, East, South and
	 * West).
	 *
	 * @author David J. Pearce
	 *
	 */
	
	public enum Direction {
		/**
		 * Topmost position on the table.
		 */
		NORTH,
		/**
		 * Rightmost position on the table.
		 */
		EAST,
		/**
		 * Bottom position on the table.
		 */
		SOUTH,
		/**
		 * Leftmost position on the table.
		 */
		WEST;
		/**
		 * Returns the next direction to play after this one (i.e. following a clockwise
		 * rotation).
		 *
		 * @return The rotated direction.
		 */
		public Direction next() {
			if (this.equals(NORTH)) {
				return EAST;
			}
			if (this.equals(EAST)) {
				return SOUTH;
			}
			if (this.equals(SOUTH)) {
				return WEST;
			}
			return NORTH;
		}
	}

	/**
	 * Identifies where this player is sitting on the table.
	 */
	public final Direction direction;
	/**
	 * Records information about the state of the players hand.
	 */
	public Hand hand; //switched from private

	/**
	 * Construct a new player with an initially empty hand.
	 *
	 * @param direction Identifies where on the table the player is sitting.
	 */
	public Player(Direction direction) {
		this.direction = direction;
		this.hand = new Hand();
	}

	/**
	 * Get the position in which this player is sitting.
	 *
	 * @return The direction where the player is sitting.
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Get the current hand of this player.
	 *
	 * @return The players current hand.
	 */
	public Hand getHand() {
		return hand;
	}
	
	@Override
	public Player clone() {
		Player isCloned = new Player(this.direction); //create new player object
		isCloned.hand = this.hand.clone(); //calls deep copy of hand to clone player hand 
		return isCloned; //return deep clone of player with their hand
	}
	
}
