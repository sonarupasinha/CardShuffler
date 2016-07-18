package com.cards.shuffler.card;

import com.cards.shuffler.enums.EnumValues.FaceValue;
import com.cards.shuffler.enums.EnumValues.Suit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Handles deck of poker cards
 * 
 * @author Sona
 *
 */
public class DeckOfPokerCards implements GenericDeckI {

	private String pokerDeckName;
	
	private PokerCard[] pokerDeck;
	
	@JsonIgnore
	final int cardCountInDeck = 52;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cardDeck.GenericDeck#setDeckName(java.lang.String)
	 */
	@Override
	public void setDeckName(String deckName) {
		this.pokerDeckName = deckName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cardDeck.GenericDeck#setupNewDeck()
	 */
	@Override
	public void setupNewDeck() {
		System.out.println("setupNewDeck() of  DeckOfPokerCards called");
		int cardCounter = 0;
		pokerDeck = new PokerCard[cardCountInDeck];
		for (Suit suit : Suit.values()) {
			for (FaceValue faceValue : FaceValue.values()) {
				pokerDeck[cardCounter++] = new PokerCard(suit, faceValue);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cardDeck.GenericDeck#getDeckName()
	 */
	@Override
	public String getDeckName() {
		return this.pokerDeckName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cardDeck.GenericDeck#getDeck()
	 */
	@Override
	public GenericCardI[] getDeck() {
		return this.pokerDeck;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cardDeck.GenericDeck#setDeck(cardDeck.Card[])
	 */
	@Override
	public void setDeck(GenericCardI[] deck) {
		this.pokerDeck = (PokerCard[]) deck;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cardDeck.GenericDeck#setupNewDeck(java.lang.String)
	 */
	@Override
	public void setupNewDeck(String deckName) {
		this.pokerDeckName = deckName;
		this.setupNewDeck();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cardDeck.GenericDeck#getCardCountInDeck()
	 */
	@Override
	public int getCardCountInDeck() {
		return this.cardCountInDeck;
	}
}