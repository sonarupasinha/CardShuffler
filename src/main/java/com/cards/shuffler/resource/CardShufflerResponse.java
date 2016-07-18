package com.cards.shuffler.resource;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cards.shuffler.card.Deck;


/**
 * 
 * @author Sona
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
public class CardShufflerResponse {

	/**
	 * 
	 */
	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private int responseCode = 0;

	/**
	 * 
	 */
	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String responseMsg;

	/**
	 * 
	 */
	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private Deck deck;

	/**
	 * 
	 */
	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private List<Deck> decks;

	/**
	 * 
	 * @return
	 */
	public int getResponseCode() {
		return responseCode;
	}

	/**
	 * 
	 * @param responseCode
	 */
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * 
	 * @return
	 */
	public String getResponseMsg() {
		return responseMsg;
	}

	/**
	 * 
	 * @param responseMsg
	 */
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	/**
	 * 
	 * @return
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * 
	 * @param deck
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	/**
	 * 
	 * @return
	 */
	public List<Deck> getDecks() {
		return decks;
	}

	/**
	 * 
	 * @param decks
	 */
	public void setDecks(List<Deck> decks) {
		this.decks = decks;
	}
}