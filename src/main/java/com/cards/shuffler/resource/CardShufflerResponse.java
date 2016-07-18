package com.cards.shuffler.resource;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cards.shuffler.card.GenericDeckI;

/**
 * 
 * @author Sona
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
public class CardShufflerResponse extends BaseResponse {

	/**
	 * 
	 */
	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private GenericDeckI deck;

	/**
	 * 
	 * @return
	 */
	public GenericDeckI getDeck() {
		return deck;
	}

	/**
	 * 
	 * @param deck
	 */
	public void setDeck(GenericDeckI deck) {
		this.deck = deck;
	}

	
}