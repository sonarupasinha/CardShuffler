package com.cards.shuffler.resource;

import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.cards.shuffler.cache.CacheManager;
import com.cards.shuffler.card.DeckOfPokerCards;
import com.cards.shuffler.card.GenericDeckI;
import com.cards.shuffler.card.Shuffler;
import com.cards.shuffler.enums.ErrorKeys.ValidationKeys;
import com.cards.shuffler.exceptions.AppException;
import com.cards.shuffler.main.server.LoadProperties;

/**
 * Implements CardShufflerServiceI to handle resource class requests
 * 
 * @author Sona
 *
 */
public class CardShufflerService implements CardShufflerServiceI {

	// Load properties
	Properties properties = LoadProperties.INSTANCE.loadConfigPropertiesFile();
	Properties errMsgsProperties = LoadProperties.INSTANCE.loadErrMsgsFile();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cards.shuffler.resource.CardShufflerServiceI#getName(java.lang.
	 * String)
	 */
	@Override
	public GenericDeckI getDeck(String name) throws AppException {
		if (null == name) {
			throw new AppException(ValidationKeys.WEBSERVICE_INPUT_EMPTY.getErrorCode(),
					errMsgsProperties.getProperty(ValidationKeys.WEBSERVICE_INPUT_EMPTY.getErrorKey()));
		}
		System.out.println("Input name : " + name);
		GenericDeckI pokerDeck = CacheManager.getInstance().lookupCache(name);
		// pokerDeck.printAllCards();
		return pokerDeck;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cards.shuffler.resource.CardShufflerServiceI#createDeck(java.lang.
	 * String)
	 */
	@Override
	public Integer createDeck(String name) throws AppException {
		if (null == name) {
			throw new AppException(ValidationKeys.WEBSERVICE_INPUT_EMPTY.getErrorCode(),
					errMsgsProperties.getProperty(ValidationKeys.WEBSERVICE_INPUT_EMPTY.getErrorKey()));
		}
		GenericDeckI pokerDeck = new DeckOfPokerCards();
		pokerDeck.setupNewDeck(name);
		// pokerDeck.printAllCards();
		CacheManager.getInstance().addToCache(name, pokerDeck);
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cards.shuffler.resource.CardShufflerServiceI#shuffleDeck(java.lang.
	 * String)
	 */
	@Override
	public Integer shuffleDeck(String name) throws AppException {
		if (null == name) {
			throw new AppException(ValidationKeys.WEBSERVICE_INPUT_EMPTY.getErrorCode(),
					errMsgsProperties.getProperty(ValidationKeys.WEBSERVICE_INPUT_EMPTY.getErrorKey()));
		}
		GenericDeckI pokerDeck = CacheManager.getInstance().lookupCache(name);
		System.out.println("pokerDeckreturn size " + pokerDeck.getDeck().length);
		pokerDeck.getDeck();
		Shuffler shuffler = new Shuffler();
		String shuffleLogic = properties.getProperty("SHUFFLE_LOGIC");
		System.out.println("shuffleLogic" + shuffleLogic);
		if (StringUtils.equals("simple", shuffleLogic))
			pokerDeck = shuffler.simpleShuffleCards(pokerDeck);
		else if (StringUtils.equals("complex", shuffleLogic))
			pokerDeck = shuffler.handShuffleCards(pokerDeck);
		else
			throw new AppException(ValidationKeys.PROPERTY_NOT_SET.getErrorCode(),
					errMsgsProperties.getProperty(ValidationKeys.PROPERTY_NOT_SET.getErrorKey()),
					properties.getProperty("SHUFFLE_LOGIC"));

		CacheManager.getInstance().addToCache(name, pokerDeck);
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cards.shuffler.resource.CardShufflerServiceI#deleteDeck(java.lang.
	 * String)
	 */
	@Override
	public Integer deleteDeck(String name) throws AppException {
		if (null == name) {
			throw new AppException(ValidationKeys.WEBSERVICE_INPUT_EMPTY.getErrorCode(),
					errMsgsProperties.getProperty(ValidationKeys.WEBSERVICE_INPUT_EMPTY.getErrorKey()));
		}
		GenericDeckI pokerDeck = CacheManager.getInstance().lookupCache(name);
		System.out.println("pokerDeckreturn size " + pokerDeck.getDeck().length);
		pokerDeck.getDeck();
		CacheManager.getInstance().removeFromCache(name);
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cards.shuffler.resource.CardShufflerServiceI#getAllDecks()
	 */
	@Override
	public List<GenericDeckI> getAllDecks() {
		List<GenericDeckI> deckList = CacheManager.getInstance().lookupCache();
		System.out.println("Total decks currently :" + deckList.size());
		return deckList;
	}
}