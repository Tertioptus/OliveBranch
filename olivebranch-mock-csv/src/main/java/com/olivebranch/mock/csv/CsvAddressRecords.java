package com.olivebranch.mock.csv;

import com.olivebranch.mock.Record;
import com.olivebranch.mock.Records;
import com.olivebranch.mock.any.Address;

import java.net.URL;

/**
 * Created by bfpaige on 160223.
 */
public class CsvAddressRecords implements Records<Address> {

    public CsvAddressRecords(URL csvFile) {

    }

    public Record<Address> retrieve(long number) throws Exception {
        return null;
    }

    public long size() throws Exception {
        return 0;
    }
}
