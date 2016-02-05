package com.olivebranch;

/**
 * Represents a user logged into a live application, operating as an agent
 * that reports application status and simulates user activity on command.
 * <p/>
 * This interface requires expects HTML DOM query in the form of a css selector
 * or xpath 
 * 
 * @author 		Benjamin F. Paige III
 * @version 	$Revision$
 * @since 		1.7
 */
public interface Agent {
	
	/**
	 * Directs user agent to start page.
	 * @param string
	 */
	String host();

	/**
	 * Directs user agent to a particular page within the application's site.
	 * @param string
	 */
	Agent goTo(String string);

	/**
	 * Commands user agent to click on a requested element.
	 * @param selector
	 */
	Agent click(Content content);
	
	/**
	 * Return text in requested element if element is found.
	 * @param selector
	 * @return
	 */
	String report(Content content);
	
	/**
	 * Tells user agent to input text within the requested element.
	 * @param selector
	 * @param keys
	 */
	Agent type(Content content, CharSequence keys);
	
	/**
	 * Clears data out of the requested element.  Primarily for textual 
	 * form fields.
	 * @param selector
	 */
	Agent clear(Content content);

	/**
	 * Reports availability of requested element.
	 * @param selector
	 * @return
	 */
	boolean verify(Content content);
	

	/**
	 * Commands user agent to submit on a requested element or page.
	 * @param selector
	 */
	Agent submit(Content content);
	
	String location();

	Agent select(Content content, String option);
	
	Agent takeScreenShot();
	
	Agent wait(Time time);
	
	void quit();
}
