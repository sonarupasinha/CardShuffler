package com.cards.shuffler.resource;

import java.util.List;

import com.cards.shuffler.card.GenericDeckI;
import com.cards.shuffler.exceptions.AppException;

/**
 * Handles resource class requests
 * 
 * @author Sona
 *
 */
public interface CardShufflerServiceI {

	/**
	 * Gets the given named deck
	 * 
	 * @param name
	 *            : Name of the deck to be returned.
	 * @return Return the deck by the given name
	 * @throws AppException
	 */
	GenericDeckI getDeck(String name) throws AppException;

	/**
	 * Create the given named deck
	 * 
	 * @param name
	 *            : Name of the deck to be created
	 * @return Returns 0 in case of a success. Non-zero custom error code in
	 *         case of failure.
	 * @throws AppException
	 */
	Integer createDeck(String name) throws AppException;

	/**
	 * Shuffles the given named deck
	 * 
	 * @param name
	 *            : Name of the deck to be shuffled
	 * @return Returns 0 in case of a success. Non-zero custom error code in
	 *         case of failure.
	 * @throws AppException
	 */
	Integer shuffleDeck(String name) throws AppException;

	/**
	 * Deletes the given named deck
	 * 
	 * @param name
	 *            : Name of the deck to be deleted
	 * @return Returns 0 in case of a success. Non-zero custom error code in
	 *         case of failure.
	 * @throws AppException
	 */
	Integer deleteDeck(String name) throws AppException;

	/**
	 * Gets all valid decks
	 * 
	 * @return A collection of decks currently available
	 */
	List<GenericDeckI> getAllDecks();
}