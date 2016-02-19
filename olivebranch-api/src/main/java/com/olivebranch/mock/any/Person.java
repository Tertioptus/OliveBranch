package com.olivebranch.mock.any;

import com.olivebranch.mock.*;

import java.util.HashMap;
import java.util.Map;

public final class Person implements Profile {

	private final Map<String, Field> map;

	public Person(Records<String> firstNames,
				  Records<String> lastNames,
				  Records<Address> addresses,
				  Records<String> phoneNumbers,
				  Records<String> emailAddresses) {
		map=new HashMap<String, Field>();
		final Name name = new Name(firstNames, lastNames);
		addNameField(name, "firstName");
		addNameField(name, "lastName");
		addAddressField(addresses, "streetAddress1");
		addAddressField(addresses, "town");
		addAddressField(addresses, "state");
		addAddressField(addresses, "zipCode");
		map.put("phoneNumbers", new CachedField(new RecordField(new AnyRecord<String>(phoneNumbers))));
		map.put("emailAddresses", new CachedField(new RecordField(new AnyRecord<String>(emailAddresses))));
	}
	private void addNameField(Name name, String key) {
		map.put(key,new ProfileField(name,key));
	}

	private void addAddressField(Records<Address> addresses, String key) {
		map.put(key,new ProfileField(
						new RecordProfile(
								new CachedRecord(
										new AnyRecord<Address>(addresses)
								)
						),
					key
				)
		);
	}

	public String field(String name) throws Exception {
		return map.get(name).value();
	}
}
