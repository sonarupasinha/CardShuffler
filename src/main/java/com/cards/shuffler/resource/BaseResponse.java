package com.cards.shuffler.resource;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class BaseResponse {

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
}
