package com.cards.shuffler.card;

import com.cards.shuffler.enums.EnumValues.FaceValue;
import com.cards.shuffler.enums.EnumValues.Suit;

/**
 * Implements GenericCardI for cards used in poker. The #assumption is that it
 * uses a 52-card deck and Jokers are excluded.
 * 
 * @author Sona
 *
 */
public class PokerCard implements GenericCardI {

	/**
	 * Name of the suit such as Spades
	 */
	private Suit suit;

	/**
	 * Face name such as 'Ace', 'King' etc.
	 */
	private FaceValue faceValue;

	/**
	 * Sets the suit name and face value
	 * 
	 * @param suit
	 *            : Name of the suit such as Spades
	 * @param faceValue
	 *            : Face value such as 1, 2, 3 etc.
	 */
	PokerCard(Suit suit, FaceValue faceValue) {
		this.suit = suit;
		this.faceValue = faceValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cards.shuffler.card.GenericCardI#getSuit()
	 */
	@Override
	public Suit getSuit() {
		return suit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cards.shuffler.card.GenericCardI#getFaceValue()
	 */
	@Override
	public FaceValue getFaceValue() {
		return faceValue;
	}

	/**
	 * This method overrides toString method to print the cards in desired way.
	 */
	@Override
	public String toString() {
		return String.format("%1$s-%2$s", faceValue.getFaceName(), suit.getSuitName());
	}
}