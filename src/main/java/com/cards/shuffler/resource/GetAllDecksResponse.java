package com.cards.shuffler.resource;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cards.shuffler.card.GenericDeckI;

/**
 * Response handler for all the decks
 * 
 * @author Sona
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
public class GetAllDecksResponse extends BaseResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	// List of decks
	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private List<GenericDeckI> decks;

	/**
	 * Gets the list of decks
	 * 
	 * @return Collection of decks
	 */
	public List<GenericDeckI> getDecks() {
		return decks;
	}

	/**
	 * Sets the decks
	 * 
	 * @param decks
	 *            Decks to be set in the collection
	 */
	public void setDecks(List<GenericDeckI> decks) {
		this.decks = decks;
	}
}