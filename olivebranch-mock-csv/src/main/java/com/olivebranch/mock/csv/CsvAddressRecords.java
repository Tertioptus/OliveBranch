package com.olivebranch.mock.csv;

import com.olivebranch.mock.Record;
import com.olivebranch.mock.Records;
import com.olivebranch.mock.any.Address;
import org.apache.commons.csv.CSVRecord;

import java.net.URL;

/**
 * Created by bfpaige on 160223.
 */
final public class CsvAddressRecords implements Records<Address> {

    private String filePath;
    private Long size;

    public CsvAddressRecords(URL csvFile) {
        this(csvFile.getPath());
    }

    public CsvAddressRecords(String filePath) {
        this.filePath = filePath;
    }

    public Record<Address> retrieve(long number) throws Exception {
        return new CsvRecord<Address>(filePath, number, true) {
            @Override
            protected Address marshall(CSVRecord record) {
                return new Address(
                        record.get("STREET"),
                        record.get("TOWN"),
                        record.get("STATE"),
                        record.get("ZIPCODE"),
                        record.get("LONGITUDE"),
                        record.get("LATITUDE")
                );
            }
        };
    }

    public long size() throws Exception {
        if(size==null)
            size=new CsvSize(filePath).value()-1;
        return size;
    }
}
