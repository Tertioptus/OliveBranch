package com.xmenus.commons.test.olivebranch.agents;

import com.xmenus.commons.test.olivebranch.queries.XPathQuery;
import com.xmenus.commons.test.olivebranch.time.Accordingly;

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
public interface UserAgent {
	
	/**
	 * Directs user agent to start page.
	 * @param string
	 */
	UserAgent startAt(String string);

	/**
	 * Directs user agent to a particular page within the application's site.
	 * @param string
	 */
	UserAgent goTo(String string);

	/**
	 * Commands user agent to click on a requested element.
	 * @param selector
	 */
	UserAgent click(XPathQuery query, Accordingly... actionDelay);
	
	/**
	 * Return text in requested element if element is found.
	 * @param selector
	 * @return
	 */
	String report(XPathQuery query, Accordingly... actionDelay);
	
	/**
	 * Tells user agent to input text within the requested element.
	 * @param selector
	 * @param keys
	 */
	UserAgent type(XPathQuery query, CharSequence keys, Accordingly... actionDelay);
	
	/**
	 * Clears data out of the requested element.  Primarily for textual 
	 * form fields.
	 * @param selector
	 */
	UserAgent clear(XPathQuery query, Accordingly... actionDelay);

	/**
	 * Reports availability of requested element.
	 * @param selector
	 * @return
	 */
	boolean verify(XPathQuery query, Accordingly... actionDelay);
	

	/**
	 * Commands user agent to submit on a requested element or page.
	 * @param selector
	 */
	UserAgent submit(XPathQuery query, Accordingly... actionDelay);
	
	String currentUrl(Accordingly... actionDelay);

	UserAgent select(XPathQuery query, String option, Accordingly... actionDelay);
	
	UserAgent takeScreenShot();
}
