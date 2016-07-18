package com.cards.shuffler.exceptions;

/**
 * This abstract class is used as a basic type for all exception classes
 * 
 * @author Sona
 *
 */
public abstract class AbstractException extends Throwable {

	private static final long serialVersionUID = 1L;

	// Error code to be set for an exception
	private int errorCode;

	// Error message to be set for an exception
	private String errorMessage;

	/**
	 * This constructor creates an AbstractException object based on the input
	 * params provided.
	 * 
	 * @param errorCode
	 * @param errorMessage
	 */
	public AbstractException(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * Get the error message for the given exception object
	 * 
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Set the error message for the given exception object
	 * 
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Returns the error message
	 */
	@Override
	public String toString() {
		return errorMessage;
	}

	/**
	 * Get the error code for the given exception object
	 * 
	 * @return int
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Set the error code for the given exception object
	 * 
	 * @param errorCode
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
