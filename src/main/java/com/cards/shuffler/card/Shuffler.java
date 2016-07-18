package com.cards.shuffler.card;

import java.util.Random;

/**
 * This class implements shuffling logic and use the GenericDeck interface
 * 
 * @author Sona
 *
 */
public class Shuffler {

	/**
	 * Shuffles cards with a simple random logic
	 * 
	 * @param deck
	 *            : Deck to be shuffled
	 * @return Returns shuffled deck
	 */
	public GenericDeckI simpleShuffleCards(GenericDeckI deck) {
		GenericCardI[] deckToShuffle = deck.getDeck();
		for (int cardIdx = 0; cardIdx < deck.getCardCountInDeck(); cardIdx++) {
			// Get a random number to swap the card
			Random randomize = new Random();
			int swapIdx = randomize.nextInt(deck.getCardCountInDeck());

			// Swap the card
			GenericCardI cardToSwap = deckToShuffle[swapIdx];
			deckToShuffle[swapIdx] = deckToShuffle[cardIdx];
			deckToShuffle[cardIdx] = cardToSwap;
		}
		return deck;
	}

	/**
	 * Simulates hand shuffling of cards. Performs the hand shuffling 'n' number
	 * of times between 1 & 10. Also performs a simple shuffle before
	 * interleaving is done every time to generate more randomness
	 * 
	 * @param deck
	 *            : Deck to be shuffled
	 * @return Shuffled deck
	 */
	public GenericDeckI handShuffleCards(GenericDeckI deck) {
		// Get a random count (max 10) for the number of times hand-shuffling
		// needs to be completed
		Random randomize = new Random();
		int handShuffleCount = randomize.nextInt(11);

		for (int shuffleCount = 1; shuffleCount <= handShuffleCount; shuffleCount++) {

			// Simple shuffle cards before each hand-shuffling to make it
			// completely random
			deck = simpleShuffleCards(deck);

			// Get the shuffled card to perform hand shuffling
			GenericCardI[] deckToShuffle = deck.getDeck();

			// Split the deck
			GenericCardI[] firstHalf = new PokerCard[deck.getCardCountInDeck() / 2];
			GenericCardI[] secondHalf = new PokerCard[deck.getCardCountInDeck() / 2];
			System.arraycopy(deckToShuffle, 0, firstHalf, 0, deck.getCardCountInDeck() / 2);
			System.arraycopy(deckToShuffle, 26, secondHalf, 0, deck.getCardCountInDeck() / 2);

			// Interleave split decks
			int deckToShuffleIdx = 0;
			deckToShuffle = new PokerCard[deck.getCardCountInDeck()];
			for (int splitDeckIdx = 0; splitDeckIdx < firstHalf.length; splitDeckIdx++) {
				deckToShuffle[deckToShuffleIdx++] = firstHalf[splitDeckIdx];
				deckToShuffle[deckToShuffleIdx++] = secondHalf[splitDeckIdx];
			}
			deck.setDeck(deckToShuffle);
		}
		return deck;
	}
}