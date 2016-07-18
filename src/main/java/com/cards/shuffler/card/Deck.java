package com.cards.shuffler.card;

import java.util.Random;

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
		GenericCardI[] deckToShuffle = this.genericDeck.getDeck();
		for (int cardIdx = 0; cardIdx < this.genericDeck.getCardCountInDeck(); cardIdx++) {
			// Get a random number to swap the card
			Random randomize = new Random();
			int swapIdx = randomize.nextInt(this.genericDeck.getCardCountInDeck());

			// Swap the card
			GenericCardI cardToSwap = deckToShuffle[swapIdx];
			deckToShuffle[swapIdx] = deckToShuffle[cardIdx];
			deckToShuffle[cardIdx] = cardToSwap;
		}
		this.genericDeck.setDeck(deckToShuffle);
	}

	/**
	 * Simulates hand shuffling of cards. Performs the hand shuffling 'n' number
	 * of times between 1 & 10. Also performs a simple shuffle before
	 * interleaving is done every time to generate more randomness
	 */
	public void handShuffleCards() {
		// Get a random count (max 10) for the number of times hand-shuffling
		// needs to be completed
		Random randomize = new Random();
		int handShuffleCount = randomize.nextInt(11);

		for (int shuffleCount = 1; shuffleCount <= handShuffleCount; shuffleCount++) {

			// Simple shuffle cards before each hand-shuffling to make it
			// completely random
			this.simpleShuffleCards();

			// Get the shuffled card to perform hand shuffling
			GenericCardI[] deckToShuffle = this.genericDeck.getDeck();

			// Split the deck
			GenericCardI[] firstHalf = new PokerCard[this.genericDeck.getCardCountInDeck() / 2];
			GenericCardI[] secondHalf = new PokerCard[this.genericDeck.getCardCountInDeck() / 2];
			System.arraycopy(deckToShuffle, 0, firstHalf, 0, this.genericDeck.getCardCountInDeck() / 2);
			System.arraycopy(deckToShuffle, 26, secondHalf, 0, this.genericDeck.getCardCountInDeck() / 2);

			// Interleave split decks
			int deckToShuffleIdx = 0;
			deckToShuffle = new PokerCard[this.genericDeck.getCardCountInDeck()];
			for (int splitDeckIdx = 0; splitDeckIdx < firstHalf.length; splitDeckIdx++) {
				deckToShuffle[deckToShuffleIdx++] = firstHalf[splitDeckIdx];
				deckToShuffle[deckToShuffleIdx++] = secondHalf[splitDeckIdx];
			}
			this.genericDeck.setDeck(deckToShuffle);
		}
	}
}