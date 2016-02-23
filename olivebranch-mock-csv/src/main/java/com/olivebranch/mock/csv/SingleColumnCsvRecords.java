package com.olivebranch.mock.csv;

import com.olivebranch.mock.Record;
import com.olivebranch.mock.Records;

import java.io.File;
import java.net.URL;

/**
 * Created by bfpaige on 160223.
 */
public class SingleColumnCsvRecords implements Records<String> {
    public SingleColumnCsvRecords(URL csvFile) {
        this(csvFile.getPath());
    }

    public SingleColumnCsvRecords(String filePath) {
        new File(filePath);
    }

    public Record<String> retrieve(long number) throws Exception {
        return null;
    }

    public long size() throws Exception {
        return 0;
    }
}
