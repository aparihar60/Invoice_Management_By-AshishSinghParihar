package com.impetus.invc_mgmt.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericException.
 */
public class GenericException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The custom msg. */
	private String customMsg;

	// getter and setter methods

	/**
	 * Gets the custom msg.
	 * 
	 * @return the custom msg
	 */
	public String getCustomMsg() {
		return customMsg;
	}

	/**
	 * Sets the custom msg.
	 * 
	 * @param customMsg
	 *            the new custom msg
	 */
	public void setCustomMsg(String customMsg) {
		this.customMsg = customMsg;
	}

	/**
	 * Instantiates a new generic exception.
	 */
	public GenericException() {
		this.customMsg = "error occurred";

	}

	/**
	 * Instantiates a new generic exception.
	 * 
	 * @param customMsg
	 *            the custom msg
	 */
	public GenericException(String customMsg) {
		this.customMsg = customMsg;
	}

}
