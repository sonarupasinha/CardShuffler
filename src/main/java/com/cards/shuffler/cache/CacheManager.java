package com.cards.shuffler.cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

import com.cards.shuffler.card.GenericDeckI;
import com.cards.shuffler.enums.ErrorKeys.CacheErrorKeys;
import com.cards.shuffler.exceptions.AppException;
import com.cards.shuffler.main.server.LoadProperties;

/**
 * This is singleton class to create an in memory cache to store all the decks.
 * 
 * @author Sona
 *
 */
public class CacheManager {

	// Create a singleton instance of the CacheManager using Factory design
	// pattern
	private static final CacheManager _instance = new CacheManager(50);
	private Map<String, GenericDeckI> cacheMap;
	Properties errMsgsProperties = LoadProperties.INSTANCE.loadErrMsgsFile();

	/**
	 * Instantiates CacheManager object
	 * 
	 * @param maxItems
	 *            : Initial capacity of the cache - if more items are added past
	 *            this count, cache will increase its size. This is also the
	 *            drawback of using the Concurrent HashMap if the memory is not
	 *            cleared for a long time we will eventually run out of memory.
	 */
	private CacheManager(int maxItems) {
		cacheMap = new ConcurrentHashMap<>(maxItems);
	}

	/**
	 * Returns the instance of the CacheManager
	 * 
	 * @return
	 */
	public static CacheManager getInstance() {
		return _instance;
	}

	/**
	 * Add the give items to cache
	 * 
	 * @param deckName
	 *            : Name of the deck to be added to cache as key
	 * @param pokerDeck
	 *            : Actual deck Object stored at the location of key
	 */
	public void addToCache(String deckName, GenericDeckI pokerDeck) throws AppException {
		System.out.println("Adding to cache - Shuffler : " + deckName);
		try {
			cacheMap.put(deckName, pokerDeck);
		} catch (Exception e) {
			throw new AppException(CacheErrorKeys.CACHE_ERROR_ADDING_KEYS.getErrorCode(),
					errMsgsProperties.getProperty(CacheErrorKeys.CACHE_ERROR_ADDING_KEYS.getErrorKey()));
		}
	}

	/**
	 * Removes the given deck from the cache.
	 * 
	 * @param deckName
	 */
	public void removeFromCache(String deckName) throws AppException {
		Iterator<Entry<String, GenericDeckI>> cacheMapIterator = null;
		Boolean deleteFlag = false;
		cacheMapIterator = cacheMap.entrySet().iterator();

		System.out.println("Input Name: " + deckName + "Cachesize :" + cacheMap.keySet().size());
		while (cacheMapIterator.hasNext()) {
			Entry<String, GenericDeckI> entry = cacheMapIterator.next();
			System.out.println("Found key " + entry.getKey());
			if (StringUtils.equals(deckName, entry.getKey())) {
				cacheMapIterator.remove();
				deleteFlag = true;
			}
		}
		if (deleteFlag == false) {
			System.out.println(deckName + " not found in cache");
			throw new AppException(CacheErrorKeys.CACHE_ERROR_REMOVING_KEYS.getErrorCode(),
					errMsgsProperties.getProperty(CacheErrorKeys.CACHE_ERROR_REMOVING_KEYS.getErrorKey()));

		}

	}

	/**
	 * This method looks up the cache for the given deck name.
	 * 
	 * @param deckName
	 * @return Given named deck from the cache
	 * @throws AppException
	 */
	public GenericDeckI lookupCache(String deckName) throws AppException {
		Iterator<Entry<String, GenericDeckI>> cacheMapIterator = null;
		cacheMapIterator = cacheMap.entrySet().iterator();
		GenericDeckI deck = null;

		// TODO : Check for empty cache an throw exception
		System.out.println("Input Name: " + deckName + "Cachesize :" + cacheMap.keySet().size());
		while (cacheMapIterator.hasNext()) {
			String key = cacheMapIterator.next().getKey();
			System.out.println("Found key " + key);
			if (StringUtils.equals(deckName, key)) {
				deck = cacheMap.get(deckName);
			}
		}
		if (null == deck) {
			// TODO : throw exception
			System.out.println(deckName + " not found in cache");
			throw new AppException(CacheErrorKeys.CACHE_ERROR_FETCHING_KEYS.getErrorCode(),
					errMsgsProperties.getProperty(CacheErrorKeys.CACHE_ERROR_FETCHING_KEYS.getErrorKey()));

		}
		return deck;
	}

	/**
	 * This method looks up the cache for all the stored decks
	 * 
	 * @return A collection of Shuffler type for all the decks in the cache
	 */
	public List<GenericDeckI> lookupCache() {
		Iterator<Entry<String, GenericDeckI>> cacheMapIterator = null;
		List<GenericDeckI> deckList = new ArrayList<>();
		cacheMapIterator = cacheMap.entrySet().iterator();

		System.out.println("Currently valid Cachesize :" + cacheMap.keySet().size());
		while (cacheMapIterator.hasNext()) {
			deckList.add(cacheMap.get(cacheMapIterator.next()));
		}
		if (deckList.isEmpty()) {
			System.out.println("Cache is Empty");
		}
		return deckList;
	}
}