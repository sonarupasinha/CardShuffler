package com.cards.shuffler.card;

/**
 * This interface is used as a basic type for all card decks
 * 
 * @author Sona
 *
 */
public interface GenericDeckI {
	/**
	 * Sets the name of deck of cards
	 * 
	 * @param cardDeckName
	 *            : Name of the deck
	 */
	public void setDeckName(String deckName);

	/**
	 * Gets the name of the deck
	 * 
	 * @return Name of the current deck
	 */
	public String getDeckName();

	/**
	 * Sets up the new deck - the deck of cards could be anything such as Poker
	 * cards, UNO cards or other playing cards
	 */
	public void setupNewDeck();

	/**
	 * Overload for setupNewDeck - Sets up the new deck - the deck of cards
	 * could be anything such as Poker cards, UNO cards or other playing cards
	 * Along with setting a new deck, it also sets the deck name
	 * 
	 * @param deckName
	 *            : Name of the deck
	 */
	public void setupNewDeck(String deckName);

	/**
	 * Gets the current deck of cards
	 * 
	 * @return Deck of cards
	 */
	public GenericCardI[] getDeck();

	/**
	 * Sets the deck of cards
	 * 
	 * @param deck
	 *            : Collection of cards for the deck
	 */
	public void setDeck(GenericCardI[] deck);

	/**
	 * Gets the count of card in the current deck
	 * 
	 * @return Count of cards in the deck
	 */
	public int getCardCountInDeck();
}
