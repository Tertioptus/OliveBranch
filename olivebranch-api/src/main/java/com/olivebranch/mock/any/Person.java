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
        map = new HashMap<String, Field>();
        final Name name = new Name(firstNames, lastNames);
        addNameField(name, "firstName");
        addNameField(name, "lastName");
        addAddressField(addresses, "streetAddress1");
        addAddressField(addresses, "town");
        addAddressField(addresses, "state");
        addAddressField(addresses, "zipCode");
        addAddressField(addresses, "latitude");
        addAddressField(addresses, "longitude");
        map.put("phoneNumber", new NonNullField(new CachedField(new RecordField(new AnyRecord<String>(phoneNumbers)))));
        map.put("emailAddress", new NonNullField(new CachedField(new RecordField(new AnyRecord<String>(emailAddresses)))));
    }

    private void addNameField(Name name, String key) {
        map.put(key, new NonNullField(new ProfileField(name, key)));
    }

    private void addAddressField(Records<Address> addresses, String key) {
        map.put(key, new NonNullField(
                        new ProfileField(
                                new RecordProfile(
                                        new CachedRecord(
                                                new AnyRecord<Address>(addresses)
                                        )
                                ),
                                key
                        )
                )
        );
    }

    public String field(String name) throws Exception {
        return map.containsKey(name)?map.get(name).value():"";
    }

    @Override
    public boolean equals(Object obj) {
        Person person=(Person) obj;
        boolean isEqual=true;
        for(String fieldName : map.keySet()) {
            try {
                isEqual=isEqual&&field(fieldName).equals(person.field(fieldName));
            }
            catch (Exception ex) {
                //An "eat equals's" exception exception
            }
        }
        return isEqual;
    }
}
