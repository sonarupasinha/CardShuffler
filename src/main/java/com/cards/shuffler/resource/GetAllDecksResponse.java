package com.cards.shuffler.resource;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cards.shuffler.card.GenericDeckI;

public class GetAllDecksResponse implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private List<GenericDeckI> decks;

	public GetAllDecksResponse(List<GenericDeckI> decks){
		this.decks = decks;
	}
	/**
		 * 
		 * @return
		 */
		public List<GenericDeckI> getDecks() {
			return decks;
		}
	
		/**
		 * 
		 * @param shufflers
		 */
		public void setDecks(List<GenericDeckI> decks) {
			this.decks = decks;
		}

	
}
