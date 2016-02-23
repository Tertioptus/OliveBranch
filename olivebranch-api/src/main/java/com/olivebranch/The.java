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

	public static Input phoneNumberOf(Profile person) throws Exception {
		return createInput(person.field("phoneNumber"));
	}

	public static Input emailAddressOf(Profile person) throws Exception {
		return createInput(person.field("emailAddress"));
	}

	public static Input streetAddressOf(Profile person) throws Exception {
		return createInput(person.field("streetAddress1"));
	}

	public static Input townOf(Profile person) throws Exception {
		return createInput(person.field("town"));
	}

	public static Input stateOf(Profile person) throws Exception {
		return createInput(person.field("state"));
	}

	public static Input zipCodeOf(Profile person) throws Exception {
		return createInput(person.field("zipCode"));
	}

	public static Input longitudeOf(Profile person) throws Exception {
		return createInput(person.field("longitude"));
	}

	public static Input latitudeOf(Profile person) throws Exception {
		return createInput(person.field("latitude"));
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
