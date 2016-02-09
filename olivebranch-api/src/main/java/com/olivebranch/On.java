package com.olivebranch;

/**
 * On is an expression that defines the payload requested from a report call.
 * 
 * @author Benjamin Paige
 * @version 1.0
 * @since 1.0
 *
 */
public enum On {

	/**
	 * Host site of current url.
	 */
	HOST,
	
	/**
	 * Current url.
	 */
	LOCATION,
	
	/**
	 * Title of current page
	 */
	TITLE
}
