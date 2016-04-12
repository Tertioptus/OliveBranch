package com.olivebranch;

import com.olivebranch.mock.any.Person;

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
	public static Input firstNameOf(Person person) throws Exception {
		return createInput(person.field(Person.Key.FIRST_NAME));
	}

	/**
	 * Returns the last name of given person
	 *  
	 * @param person
	 * @return input
	 */
	public static Input lastNameOf(Person person) throws Exception {
		return createInput(person.field(Person.Key.LAST_NAME));
	}

	/**
	 * Returns the name of given person
	 *  
	 * @param person
	 * @return input
	 */
	public static Input nameOf(Person person) throws Exception {
		return createInput(String.format("%s %s", person.field(Person.Key.FIRST_NAME), person.field(Person.Key.LAST_NAME)));
	}

	public static Input phoneNumberOf(Person person) throws Exception {
		return createInput(person.field(Person.Key.PHONE_NUMBER));
	}

	public static Input emailAddressOf(Person person) throws Exception {
		return createInput(person.field(Person.Key.EMAIL_ADDRESS));
	}

	public static Input streetAddressOf(Person person) throws Exception {
		return createInput(person.field(Person.Key.STREET_ADDRESS_1));
	}

	public static Input townOf(Person person) throws Exception {
		return createInput(person.field(Person.Key.TOWN));
	}

	public static Input stateOf(Person person) throws Exception {
		return createInput(person.field(Person.Key.STATE));
	}

	public static Input zipCodeOf(Person person) throws Exception {
		return createInput(person.field(Person.Key.ZIP_CODE));
	}

	public static Input longitudeOf(Person person) throws Exception {
		return createInput(person.field(Person.Key.LONGITUDE));
	}

	public static Input latitudeOf(Person person) throws Exception {
		return createInput(person.field(Person.Key.LATITUDE));
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
