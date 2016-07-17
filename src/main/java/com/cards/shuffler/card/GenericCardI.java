package com.cards.shuffler.card;

import com.cards.shuffler.enums.EnumValues.FaceValue;
import com.cards.shuffler.enums.EnumValues.Suit;

/**
 * Exposes some generic methods to handle cards
 * 
 * @author Sona
 *
 */
public interface GenericCardI {

	/**
	 * Returns the face value of the card
	 * 
	 * @return FaceValue object (Face value of the card)
	 */
	public FaceValue getFaceValue();

	/**
	 * Returns the suit of the card
	 * 
	 * @return Suit object (Suit of the card)
	 */
	public Suit getSuit();
}