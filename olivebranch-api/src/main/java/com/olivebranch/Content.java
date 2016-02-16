package com.olivebranch;

/**
 * A Content<T> represents some identifiable portion within a GUI rendition.
 * 
 * @author Benjamin Paige
 * @version 1.0
 * @since 1.0
 *
 */
public interface Content<T> {

	/**
	 * Identifies the container of the current Content<T> to allow further specificity in the generated query
	 * @param parent
	 * @return A Content<T> instance that is 
	 */
	Content<T> in(Content<T> parent);

	/**
	 * 
	 * @param values
	 * @return
	 */
	Content<T> thatHas(String... values);
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	Content<T> number(int number);
	
	/**
	 * Establishes 
	 * 
	 * @return
	 */
	Content<T> parent();
	
	/**
	 * Establishes adjacency between two Content<T> objects, whereas the Content<T> object shares the same
	 * parent container with the parameterized one.
	 * 
	 * @param sibling
	 * @return Content<T>
	 */
	Content<T> sibling(Content<T> sibling);
	
	/**
	 * Returns Query expression for identifying Content<T> in a specified medium.
	 * 
	 * @return Query expression
	 */
	T query();
}
