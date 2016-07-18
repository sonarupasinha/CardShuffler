package com.cards.shuffler.exceptions;

/**
 * This extends AbstractException to log more error details
 * 
 * @author Sona
 *
 */
public class AppException extends AbstractException {

	private static final long serialVersionUID = 1L;

	// This field stores the error message in detail.
	private String errorDetail;

	/**
	 * This constructor creates an AppException object based on the input params
	 * provided.
	 * 
	 * @param errorCode
	 *            Error code to be set
	 * @param errorMessage
	 *            Error message to be set
	 * @param params
	 *            Error message parameters
	 */
	public AppException(int errorCode, String errorMessage, String... params) {
		super(errorCode, errorMessage);
		for (int i = 1; i <= params.length; i++) {
			errorMessage.replace("{" + i + "}", params[i]);
		}
		this.errorDetail = errorMessage;
		System.out.println("Error Detail : " + errorDetail);
		printStackTrace();
	}

	/**
	 * Get the error detail message for the given exception object
	 * 
	 * @return Error detail string
	 */
	public String getErrorDetail() {
		return errorDetail;
	}

	/**
	 * Set the error detail message for the given exception object
	 * 
	 * @param errorDetail
	 *            Error detail to be set
	 */
	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}
}