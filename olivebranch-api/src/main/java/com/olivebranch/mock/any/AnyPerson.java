package com.olivebranch.mock.any;

import com.olivebranch.mock.CachedRecord;
import com.olivebranch.mock.Field;
import com.olivebranch.mock.NonNullField;
import com.olivebranch.mock.RecordProfile;
import com.olivebranch.mock.Records;

public final class AnyPerson extends Memory<Person.Key, Field> implements Person {

	public AnyPerson(Records<String> firstNames, Records<String> lastNames,
			Records<Address> addresses, Records<String> phoneNumbers,
			Records<String> emailAddresses) {
		super(Key.values().length);
		final Name name = new Name(firstNames, lastNames);
		put(Key.FIRST_NAME, nameField(name, Name.Key.FIRST_NAME));
		put(Key.LAST_NAME, nameField(name, Name.Key.LAST_NAME));
		put(Key.STREET_ADDRESS_1, addressField(addresses, Address.Key.STREET_ADDRESS));
		put(Key.TOWN, addressField(addresses, Address.Key.TOWN));
		put(Key.STATE, addressField(addresses, Address.Key.STATE));
		put(Key.ZIP_CODE, addressField(addresses, Address.Key.ZIP_CODE));
		put(Key.LATITUDE, addressField(addresses, Address.Key.LATITUDE));
		put(Key.LONGITUDE, addressField(addresses, Address.Key.LONGITUDE));
		put(Key.PHONE_NUMBER, new NonNullField(new CachedField(new RecordField(
				new AnyRecord<String>(phoneNumbers)))));
		put(Key.EMAIL_ADDRESS, new NonNullField(new CachedField(
				new RecordField(new AnyRecord<String>(emailAddresses)))));
	}

	private Field nameField(Name name, Name.Key key) {
		return new NonNullField(new ProfileField<Name.Key>(name, key));
	}

	private Field addressField(Records<Address> addresses, Address.Key key) {
		return new NonNullField(new ProfileField<Address.Key>(
				new RecordProfile<Address.Key, Address>(
						new CachedRecord<Address>(new AnyRecord<Address>(addresses))), key));
	}

	/* (non-Javadoc)
	 * @see com.olivebranch.mock.any.IPerson#field(com.olivebranch.mock.any.Person.Key)
	 */
	@Override
	public String field(Person.Key name) throws Exception {
		return get(name) == null ? "" : get(name).value();
	}

	@Override
	public boolean equals(Object obj) {
		Person person = (Person) obj;
		boolean isEqual = true;
		try {
			for (Key key : Key.values()) {
				isEqual = isEqual && field(key).equals(person.field(key));
			}
		} catch (Exception ex) {
			// An "eat equals's" exception exception
			isEqual = false;
		}
		return isEqual;
	}
}