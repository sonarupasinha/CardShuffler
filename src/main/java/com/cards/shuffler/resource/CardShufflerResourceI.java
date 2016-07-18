package com.cards.shuffler.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Exposes all the end-points served by this web service.
 * 
 * @author Sona
 */
public interface CardShufflerResourceI {

	/**
	 * Exposes a GET end-point to return the given named deck
	 * 
	 * @param name
	 *            : Name of the deck to be returned.
	 * @return GetDeckResponse
	 */
	@GET
	@Path("deck/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public GetDeckResponse getDeck(@PathParam("name") String name);

	/**
	 * Exposes a GET end-point to return all the valid decks
	 * 
	 * @return GetDeckResponse
	 */
	@GET
	@Path("decks")
	@Produces(MediaType.APPLICATION_JSON)
	public GetAllDecksResponse getAllDecks();

	/**
	 * Exposes a PUT end-point to create/update the given named deck
	 * 
	 * @param name
	 *            : Name of the deck to be created
	 * @return GetDeckResponse
	 */
	@PUT
	@Path("deck")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse createDeck(@FormParam("name") String name);

	/**
	 * Exposes a POST end-point to shuffle the given named deck
	 * 
	 * @param name
	 *            : Name of the deck to be shuffled
	 * @return GetDeckResponse
	 */
	@POST
	@Path("deck/shuffle")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse shuffleDeck(@FormParam("name") String name);

	/**
	 * Exposes a DELETE end-point to delete the given named deck
	 * 
	 * @param name
	 *            : Name of the deck to be deleted
	 * @return GetDeckResponse
	 */
	@DELETE
	@Path("deck/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse deleteDeck(@PathParam("name") String name);
}