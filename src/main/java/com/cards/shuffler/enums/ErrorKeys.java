package com.cards.shuffler.enums;

/**
 * Holds enum values for errors : codes and msg keys.
 * 
 * @author Sona
 *
 */
public class ErrorKeys {

	/**
	 * Holds enum values for Validation errors : codes and msg keys.
	 *
	 */
	public enum ValidationKeys {
		WEBSERVICE_INPUT_EMPTY(1001, "input.empty"), PROPERTY_NOT_SET(1002, "config.property.not.set");

		// Corresponding codes for the error
		private final Integer errorCode;

		// Corresponding keys for the error
		private final String errorKey;

		/**
		 * Sets the error code and keys
		 * 
		 * @param errorCode
		 *            : error codes for the errors
		 * 
		 * @param errorKey
		 *            : Corresponding error key value to fetch the error
		 *            message.
		 */
		ValidationKeys(Integer errorCode, String errorKey) {
			this.errorCode = errorCode;
			this.errorKey = errorKey;
		}

		/**
		 * Gets the error code for the error
		 * 
		 * @return Integer of the suit
		 */
		public Integer getErrorCode() {
			return errorCode;
		}

		/**
		 * Gets the error key for the error
		 * 
		 * @return String value
		 */
		public String getErrorKey() {
			return errorKey;
		}
	}

	/**
	 * Holds enum values for Cache errors : codes and msg keys.
	 *
	 */
	public enum CacheErrorKeys {
		CACHE_FULL(1003, "cache.full"),
		CACHE_KEY_NOT_PRESENT(1004, "cache.key.not.present"),
		CACHE_EMPTY(1005, "cache.empty"),
		CACHE_ERROR_ADDING_KEYS(1006, "cache.err.add.keys"),
		CACHE_ERROR_REMOVING_KEYS(1007, "cache.err.removing.keys"),
		CACHE_ERROR_FETCHING_KEYS(1008, "cache.err.fetch.keys");

		// Corresponding codes for the error
		private final Integer errorCode;

		// Corresponding keys for the error
		private final String errorKey;

		/**
		 * Sets the error code and keys
		 * 
		 * @param errorCode
		 *            : error codes for the errors
		 * 
		 * @param errorKey
		 *            : Corresponding error key value to fetch the error
		 *            message.
		 */
		CacheErrorKeys(Integer errorCode, String errorKey) {
			this.errorCode = errorCode;
			this.errorKey = errorKey;
		}

		/**
		 * Gets the error code for the error
		 * 
		 * @return Integer of the suit
		 */
		public Integer getErrorCode() {
			return errorCode;
		}

		/**
		 * Gets the error key for the error
		 * 
		 * @return String value
		 */
		public String getErrorKey() {
			return errorKey;
		}
	}
}