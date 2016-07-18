package com.cards.shuffler.resource;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Base response class for common response objects
 * 
 * @author Sona
 *
 */
public class BaseResponse {

	// Response code
	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private int responseCode = 0;

	// Response Message
	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String responseMsg;

	/**
	 * Gets the response code
	 * 
	 * @return : Response code integer
	 */
	public int getResponseCode() {
		return responseCode;
	}

	/**
	 * Sets the response code
	 * 
	 * @param responseCode
	 *            : Response code to be set
	 */
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * Gets the response message
	 * 
	 * @return Response message
	 */
	public String getResponseMsg() {
		return responseMsg;
	}

	/**
	 * Sets the response message
	 * 
	 * @param responseMsg
	 *            : Response message to be set
	 */
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
}