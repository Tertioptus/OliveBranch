package com.olivebranch;

/**
 * A Content represents some identifiable portion within a GUI rendition.
 * 
 * @author Benjamin Paige
 * @version 1.0
 * @since 1.0
 *
 */
public interface Content {

	/**
	 * Identifies the container of the current content to allow further specificity in the generated query
	 * @param parent
	 * @return A Content instance that is 
	 */
	Content in(Content parent);

	/**
	 * 
	 * @param values
	 * @return
	 */
	Content has(String... values);
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	Content number(int number);
	
	/**
	 * Establishes 
	 * 
	 * @return
	 */
	Content parent();
	
	/**
	 * Establishes adjacency between two Content objects, whereas the Content object shares the same
	 * parent container with the parameterized one.
	 * 
	 * @param sibling
	 * @return Content
	 */
	Content sibling(Content sibling);
	
	/**
	 * Returns Query expression for identifying content in a specified medium.
	 * 
	 * @return Query expression
	 */
	String query();
}
