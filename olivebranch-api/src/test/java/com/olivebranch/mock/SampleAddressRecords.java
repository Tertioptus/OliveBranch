package com.olivebranch.mock;

import com.olivebranch.mock.any.Address;

/**
 * Created by bfpaige on 160219.
 */
public class SampleAddressRecords extends AbstractSampleRecords<Address> {
    public SampleAddressRecords() {
        super(new Address[] {
                new Address("625 Broadway", "Albany", "NY", "12233", "33.23552", "-55.32443"),
                new Address("1 Air Force", "Washington", "DC", "55555", "-70.43525", "45.12434")
        });
    }
}
