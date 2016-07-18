package com.cards.shuffler.resource;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cards.shuffler.card.GenericDeckI;

/**
 * Response handler for Single decks
 * 
 * @author Sona
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
public class GetDeckResponse extends BaseResponse {

	// Generic deck object
	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private GenericDeckI deck;

	/**
	 * Gets the current deck
	 * 
	 * @return Generic Deck
	 */
	public GenericDeckI getDeck() {
		return deck;
	}

	/**
	 * Set the given deck
	 * 
	 * @param deck
	 *            : Deck to be set
	 */
	public void setDeck(GenericDeckI deck) {
		this.deck = deck;
	}
}