package com.olivebranch;

import com.olivebranch.mock.Record;

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
	public static Input firstNameOf(Record person) {
		return createInput(person.retrieve("firstName"));
	}

	/**
	 * Returns the last name of given person
	 *  
	 * @param person
	 * @return input
	 */
	public static Input lastNameOf(Record person) {
		return createInput(person.retrieve("lastName"));
	}
	/**
	 * Returns the name of given person
	 *  
	 * @param person
	 * @return input
	 */
	public static Input nameOf(Record person) {
		return createInput(person.retrieve("fullName"));
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
