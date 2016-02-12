package com.olivebranch;

import com.olivebranch.mock.Person;

/**
 * 
 * @author bfpaige
 *
 */
public abstract class The {
	
	protected The() {};
	
	/**
	 * 
	 * @param person
	 * @return
	 */
	public static Input firstNameOf(Person person) {
		return createInput(person.firstName());
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
