package com.cards.shuffler.card;

/**
 * This class implements shuffling logic and use the GenericDeck interface
 * 
 * @author Sona
 *
 */
public class Deck {
	/**
	 * Handles the deck of cards
	 */
	private GenericDeckI genericDeck;

	/**
	 * Sets the type of deck
	 * 
	 * @param deck
	 *            : Type of deck such as Poker cards deck, UNO cards deck etc.
	 */
	public void setDeckType(GenericDeckI deck) {
		this.genericDeck = deck;
	}

	/**
	 * Sets the name of the current deck
	 * 
	 * @param deckName
	 *            : Name of the deck
	 */
	public void setDeckName(String deckName) {
		this.genericDeck.setDeckName(deckName);
	}

	/**
	 * Gets the name of the deck
	 * 
	 * @return Name of the deck
	 */
	public String getDeckName() {
		return this.genericDeck.getDeckName();
	}

	/**
	 * Sets up a new deck
	 */
	public void setupNewDeck() {
		this.genericDeck.setupNewDeck();
	}

	/**
	 * Sets up a new deck along with the name of the deck
	 * 
	 * @param deckName
	 *            : Name of the deck
	 */
	public void setupNewDeck(String deckName) {
		this.genericDeck.setDeckName(deckName);
		this.genericDeck.setupNewDeck();
	}

	/**
	 * Sets up the deck
	 * 
	 * @param deck
	 *            : Collection of cards to be added to the deck
	 */
	public void setDeck(GenericCardI[] deck) {
		this.genericDeck.setDeck(deck);
	}

	/**
	 * Gets the deck of cards
	 * 
	 * @return Deck of cards
	 */
	public GenericCardI[] getDeck() {
		return this.genericDeck.getDeck();
	}

	/**
	 * Shuffles cards with a simple random logic
	 */
	public void simpleShuffleCards() {
		// TODO : Add code for simple shuffling
	}

	/**
	 * Simulates hand shuffling of cards. Performs the hand shuffling 'n' number
	 * of times between 1 & 10. Also performs a simple shuffle before
	 * interleaving is done every time to generate more randomness
	 */
	public void handShuffleCards() {
		// TODO : Add code for complex shuffling
	}
}