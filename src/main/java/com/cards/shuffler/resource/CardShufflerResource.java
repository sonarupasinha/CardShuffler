package com.cards.shuffler.resource;

import java.util.List;
import java.util.Properties;

import javax.ws.rs.Path;

import com.cards.shuffler.card.GenericDeckI;
import com.cards.shuffler.exceptions.AppException;
import com.cards.shuffler.main.server.LoadProperties;

/**
 * Implements CardShufflerResourceI to expose all the end-points served by this
 * web service.
 * 
 * @author Sona
 *
 */
@Path("/")
public class CardShufflerResource implements CardShufflerResourceI {

	CardShufflerServiceI cardShufflerService = new CardShufflerService();
	Properties errMsgsProperties = LoadProperties.INSTANCE.loadErrMsgsFile();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cards.shuffler.resource.CardShufflerResourceI#getDeck(java.lang.
	 * String)
	 */
	@Override
	public GetDeckResponse getDeck(String name) {
		Integer responseCode = 0;
		GetDeckResponse getDeckResponse = new GetDeckResponse();
		GenericDeckI deck;
		try {
			deck = cardShufflerService.getDeck(name);
			getDeckResponse.setDeck(deck);
			getDeckResponse.setResponseMsg("Success");
		} catch (AppException e) {
			responseCode = e.getErrorCode();
			getDeckResponse.setResponseMsg(e.getErrorMessage());
		}

		getDeckResponse.setResponseCode(responseCode);
		return getDeckResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cards.shuffler.resource.CardShufflerResourceI#createDeck(java.lang.
	 * String)
	 */
	@Override
	public BaseResponse createDeck(String name) {

		Integer responseCode = 0;
		BaseResponse cardShufflerResponse = new BaseResponse();
		try {
			responseCode = cardShufflerService.createDeck(name);
			cardShufflerResponse.setResponseMsg("Success");
		} catch (AppException e) {
			responseCode = e.getErrorCode();
			cardShufflerResponse.setResponseMsg(e.getErrorMessage());
		}
		cardShufflerResponse.setResponseCode(responseCode);
		return cardShufflerResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cards.shuffler.resource.CardShufflerResourceI#shuffleDeck(java.lang.
	 * String)
	 */
	@Override
	public BaseResponse shuffleDeck(String name) {
		Integer responseCode = 0;
		BaseResponse cardShufflerResponse = new BaseResponse();
		try {
			responseCode = cardShufflerService.shuffleDeck(name);
			cardShufflerResponse.setResponseMsg("Success");
		} catch (AppException e) {
			responseCode = e.getErrorCode();
			cardShufflerResponse.setResponseMsg(e.getErrorMessage());
		}
		cardShufflerResponse.setResponseCode(responseCode);
		return cardShufflerResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cards.shuffler.resource.CardShufflerResourceI#deleteDeck(java.lang.
	 * String)
	 */
	@Override
	public BaseResponse deleteDeck(String name) {
		Integer responseCode = 0;
		BaseResponse getDeckResponse = new BaseResponse();
		try {
			responseCode = cardShufflerService.deleteDeck(name);
			getDeckResponse.setResponseMsg("Success");
		} catch (AppException e) {
			responseCode = e.getErrorCode();
			getDeckResponse.setResponseMsg(e.getErrorMessage());
		}
		getDeckResponse.setResponseCode(responseCode);
		return getDeckResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cards.shuffler.resource.CardShufflerResourceI#getAllDecks()
	 */
	@Override
	public GetAllDecksResponse getAllDecks() {
		GetAllDecksResponse cardShufflerResponse = new GetAllDecksResponse();
		Integer responseCode = 0;
		List<GenericDeckI> decks;
		try {
			decks = cardShufflerService.getAllDecks();
			responseCode = 0;
			cardShufflerResponse.setResponseMsg("Success");
			cardShufflerResponse.setDecks(decks);
		} catch (AppException e) {
			responseCode = e.getErrorCode();
			cardShufflerResponse.setResponseMsg(e.getErrorMessage());
		}
		cardShufflerResponse.setResponseCode(responseCode);

		return cardShufflerResponse;
	}
}