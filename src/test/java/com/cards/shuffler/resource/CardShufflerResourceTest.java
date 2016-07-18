package com.cards.shuffler.resource;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.cards.shuffler.card.GenericDeckI;

/**
 * Implements basic test cases for the application
 * 
 * @author Sona
 *
 */
public class CardShufflerResourceTest {

	CardShufflerResourceI cardShufflerResource = new CardShufflerResource() ;

	/**
	 * Prints all cards
	 * 
	 * @param shuffler
	 *            Shuffler which needs to be printed
	 */
	public void printAllCards(GenericDeckI shuffler) {
		System.out.println("Contents of deck");
		for (int i = 0; i < shuffler.getDeck().length; i++) {
			System.out.println(shuffler.getDeck()[i].toString());
		}
	}

	/**
	 * Tests createDeck() with deck name
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateDeckWithDeckName() throws Exception {
		BaseResponse cardShufflerResponse = new GetDeckResponse();
		cardShufflerResponse = cardShufflerResource.createDeck("test1");
		Assert.assertEquals(0, cardShufflerResponse.getResponseCode());
	}

	/**
	 * Tests createDeck() with no deck name
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateDeckNoInput() throws Exception {
		BaseResponse cardShufflerResponse = new GetDeckResponse();
		cardShufflerResponse = cardShufflerResource.createDeck(null);
		Assert.assertNotSame(0, cardShufflerResponse.getResponseCode());
	}

	/**
	 * Tests createDeck() with deck name and an existing shuffled deck
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateDeckExistingShuffledDeckInput() throws Exception {
		BaseResponse cardShufflerResponse = new GetDeckResponse();
		cardShufflerResponse = cardShufflerResource.createDeck("test1");
		Assert.assertEquals(0, cardShufflerResponse.getResponseCode());
	}
	
	/**
	 * Tests createDeck() with deck name
	 * 
	 * @throws Exception
	 */
	@Test
	public void testShuffleDeckWithDeckName() throws Exception {
		BaseResponse cardShufflerResponse = new GetDeckResponse();
		cardShufflerResponse = cardShufflerResource.shuffleDeck("test1");
		Assert.assertEquals(0, cardShufflerResponse.getResponseCode());
	}

	/**
	 * Tests createDeck() with no deck name
	 * 
	 * @throws Exception
	 */
	@Test
	public void testShuffleDeckNoInput() throws Exception {
		BaseResponse cardShufflerResponse = new GetDeckResponse();
		cardShufflerResponse = cardShufflerResource.shuffleDeck(null);
		Assert.assertNotSame(0, cardShufflerResponse.getResponseCode());
	}

	/**
	 * Tests createDeck() with deck name and an existing shuffled deck
	 * 
	 * @throws Exception
	 */
	@Test
	public void testShuffleDeckExistingShuffledDeckInput() throws Exception {
		BaseResponse cardShufflerResponse = new GetDeckResponse();
		cardShufflerResponse = cardShufflerResource.createDeck("test1");
		Assert.assertEquals(0, cardShufflerResponse.getResponseCode());
	}
	/**
	 * Test getDeck()
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetDeck() throws Exception {
		GetDeckResponse getDeckResponse = new GetDeckResponse();
		getDeckResponse = cardShufflerResource.getDeck("test1");
		GenericDeckI deck = getDeckResponse.getDeck();
		printAllCards(deck);
		Assert.assertEquals(0, getDeckResponse.getResponseCode());

	}

	/**
	 * Tests getDeck() with NULL input
	 */
	@Test
	public void testGetDeckWithNullInput() throws Exception {
		GetDeckResponse getDeckResponse = new GetDeckResponse();
		getDeckResponse = cardShufflerResource.getDeck(null);
		Assert.assertNotSame(0, getDeckResponse.getResponseCode());
	}

	/**
	 * Tests getDeck() with valid input
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetDeckWithInvalidInput() throws Exception {
		GetDeckResponse getDeckResponse = new GetDeckResponse();
		getDeckResponse = cardShufflerResource.getDeck("test2");
		Assert.assertNotSame(0, getDeckResponse.getResponseCode());
	}

	/**
	 * Tests getDeck() with valid input in sorted order
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetDeckWithValidInputSorted() throws Exception {
		GetDeckResponse getDeckResponse = new GetDeckResponse();
		getDeckResponse = cardShufflerResource.getDeck("test1");
		Assert.assertEquals(0, getDeckResponse.getResponseCode());
	}

	/**
	 * Test getDeck() with valid input in shuffled order
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetNameWithValidInputShuffled() throws Exception {
		GetDeckResponse getDeckResponse = new GetDeckResponse();
		getDeckResponse = cardShufflerResource.getDeck("test1");
		Assert.assertEquals(0, getDeckResponse.getResponseCode());
	}

	/**
	 * Tests createDeck() with deck name
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteDeckWithDeckName() throws Exception {
		BaseResponse cardShufflerResponse = new GetDeckResponse();
		cardShufflerResponse = cardShufflerResource.deleteDeck("test1");
		Assert.assertEquals(0, cardShufflerResponse.getResponseCode());
	}

	/**
	 * Tests createDeck() with no deck name
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteDeckNoInput() throws Exception {
		BaseResponse cardShufflerResponse = new GetDeckResponse();
		cardShufflerResponse = cardShufflerResource.deleteDeck(null);
		Assert.assertNotSame(0, cardShufflerResponse.getResponseCode());
	}

}
