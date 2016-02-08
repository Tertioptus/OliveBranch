package com.olivebranch;

/**
 * An Agent represents a user performing some activity via a graphical user interface. 
 * 
 * @author 		Benjamin F. Paige III
 * @version 	1.0
 * @since 		1.0
 */
public interface Agent {
	
	/**
	 * Directs agent to a particular page within the application's site.
	 * @param string
	 * 
	 * @return Returns calling Agent 
	 */
	Agent goTo(String string);

	/**
	 * Commands agent to click on a requested element.
	 * @param selector
	 * 
	 * @return Returns calling Agent 
	 */
	Agent click(Content content);
	
	/**
	 * Tells agent to input text within the requested element.
	 * @param selector
	 * @param keys
	 * 
	 * @return Returns calling Agent 
	 */
	Agent type(Content content, CharSequence keys);
	
	/**
	 * Clears data out of the requested element.  Primarily for textual 
	 * form fields.
	 * @param selector
	 * 
	 * @return Returns calling Agent 
	 */
	Agent clear(Content content);

	/**
	 * Selects option from specified select box content.
	 * 
	 * @param content select box
	 * @param option select box option
	 * 
	 * @return Returns calling Agent 
	 */
	Agent select(Content selectBox, String option);

	/**
	 * Requests agent to wait for previous action to complete for a specified amount of time.
	 * 
	 * @param time The amount of time for agent to wait.
	 * 
	 * @return Returns calling Agent 
	 */
	Agent wait(Time time);

	/**
	 * Reports availability of requested element.
	 * 
	 * @param selector
	 * @return availability of requested element.
	 */
	boolean verify(Content content);

	/**
	 * Agent reports on one aspect of user session 
	 * 
	 * @param on
	 * @return
	 */
	String report(On on);
	
	/**
	 * Record the current rendition of a GUIs resource.
	 * 
	 * @param imageOf An enumerator designating the type of resource
	 * @return location of captured file
	 */
	String capture(ImageOf imageOf);
	
	/**
	 * End session.
	 */
	void quit();
}
