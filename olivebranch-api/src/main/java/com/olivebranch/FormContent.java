package com.olivebranch;

/**
 * Represents content within a webpage's form.
 * 
 * @author Benjamin F. Paige III
 * @version 1.0
 * @since 1.0
 *
 */
public interface FormContent<T> extends Content<T> {

	/**
	 * Returns element that has a label containing the specified text 
	 * @param text text displayed from a label
	 */
	FormContent<T> labeled(String text);
	
	/**
	 * Returns the form in which this content is contained 
	 */
	FormContent<T> parentForm();
	
	/**
	 * Returns the input element that has the specified value
	 * @param value
	 * @return input element in the form of a Content object
	 */
	FormContent<T> hasValue(String value);
}
