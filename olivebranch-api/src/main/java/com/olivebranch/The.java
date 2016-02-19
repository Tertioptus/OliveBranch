package com.olivebranch;

import com.olivebranch.mock.Profile;

/**
 * 
 * @author bfpaige
 *
 */
public abstract class The {
	
	protected The() {};
	
	/**
	 * Returns the first name of given person
	 *  
	 * @param person
	 * @return input
	 */
	public static Input firstNameOf(Profile person) throws Exception {
		return createInput(person.field("firstName"));
	}

	/**
	 * Returns the last name of given person
	 *  
	 * @param person
	 * @return input
	 */
	public static Input lastNameOf(Profile person) throws Exception {
		return createInput(person.field("lastName"));
	}
	/**
	 * Returns the name of given person
	 *  
	 * @param person
	 * @return input
	 */
	public static Input nameOf(Profile person) throws Exception {
		return createInput(person.field("fullName"));
	}
	
	/**
	 * 
	 * @param text
	 * @return
	 */
	public static Input followingText(String text) {
		return createInput(text);
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	protected static Input createInput(String value) {
		return new Input(value);
	}
}
