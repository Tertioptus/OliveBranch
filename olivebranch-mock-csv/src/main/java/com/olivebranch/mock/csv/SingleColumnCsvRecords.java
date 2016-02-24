package com.olivebranch.mock.csv;

import com.olivebranch.mock.Record;
import com.olivebranch.mock.Records;
import org.apache.commons.csv.CSVRecord;

import java.net.URL;

/**
 * Created by bfpaige on 160223.
 */
public class SingleColumnCsvRecords implements Records<String> {

    private final String filePath;
    private Long size;

    public SingleColumnCsvRecords(URL csvFile) {
        this(csvFile.getPath());
    }

    public SingleColumnCsvRecords(String filePath) {
        this.filePath=filePath;
    }

    public Record<String> retrieve(long number) throws Exception {
        return new CsvRecord<String>(filePath, number){

            @Override
            protected String marshall(CSVRecord record) {
                return record.get(0);
            }
        };
    }

    public long size() throws Exception {
        if(size==null)
            size=new CsvSize(filePath).value();
        return size;
    }
}
