package com.olivebranch;

/**
 * A content  
 * 
 * @author Benjamin Paige
 * @version 1.0
 * @since 1.0
 *
 */
public interface Content {

	Content in(Content parent);

	Content has(String... values);
	
	Content number(int number);
	
	Content parent();
	
	Content sibling(Content sibling);
}
