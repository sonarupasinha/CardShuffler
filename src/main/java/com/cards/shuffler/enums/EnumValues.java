package com.cards.shuffler.enums;

/**
 * Holds enum values for suits, face value etc.
 * 
 * @author Sona
 *
 */
public class EnumValues {

	/**
	 * Holds 4 suits of the 52-card deck
	 * 
	 * @author Sona
	 *
	 */
	public enum Suit {
		SPADES("spades", 0), HEARTS("hearts", 1), DIAMONDS("diamond", 2), CLUBS("club", 3);

		/**
		 * Name of the suit such as Spades
		 */
		private String suitName;

		/**
		 * Corresponding value of the suit for the enum
		 */
		private int suitValue;

		/**
		 * Sets the suit name and value
		 * 
		 * @param suitName
		 *            : Suit name such as Spades
		 * @param suitValue
		 *            : Corresponding suit value
		 */
		Suit(String suitName, int suitValue) {
			this.suitName = suitName;
			this.suitValue = suitValue;
		}

		/**
		 * Gets the name of the suit
		 * 
		 * @return Name of the suit
		 */
		public String getSuitName() {
			return suitName;
		}

		/**
		 * Gets the value of the suit
		 * 
		 * @return Suit value
		 */
		public int getSuitValue() {
			return suitValue;
		}
	}

	/**
	 * Holds 13 face values for the 52-card deck
	 * 
	 * @author Sona
	 *
	 */
	public enum FaceValue {
		ACE("Ace", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8",
				8), NINE("9", 9), TEN("10", 10), JACK("Jack", 11), QUEEN("Queen", 12), KING("King", 13);

		/**
		 * Face name such as 'Ace', 'King' etc.
		 */
		private String faceName;
		/**
		 * Face value such as 1, 2 , 3 etc.
		 */
		private int faceValue;

		/**
		 * Sets a new FaceValue based on the given faceName and faceValue
		 * 
		 * @param faceName
		 *            : Face name to be set
		 * @param faceValue
		 *            : Face value to be set
		 */
		FaceValue(String faceName, int faceValue) {
			this.faceName = faceName;
			this.faceValue = faceValue;
		}

		/**
		 * Gets the Face name
		 * 
		 * @return Face name such as 'Ace', 'King' etc.
		 */
		public String getFaceName() {
			return faceName;
		}

		/**
		 * Gets the face value
		 * 
		 * @return Face value such as 1, 2, 3..
		 */
		public int getFaceValue() {
			return faceValue;
		}
	}
}