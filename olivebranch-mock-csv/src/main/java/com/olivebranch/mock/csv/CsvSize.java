package com.olivebranch.mock.csv;

import org.apache.commons.csv.CSVFormat;

import java.io.FileReader;

/**
 * Created by bfpaige on 160224.
 */
class CsvSize {
    private final String filePath;

    public CsvSize(String filePath) {
        this.filePath =filePath;
    }

    public long value() throws Exception {
        long size;
        final FileReader in = new FileReader(filePath);
        try {
            size= CSVFormat.DEFAULT.parse(in).getRecords().size();
        }
        catch (Exception ex) {
            throw ex;
        }
        finally {
            in.close();
        }
        return size;
    }
}
