package com.olivebranch.mock.csv;

import com.olivebranch.mock.Record;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;

/**
 * Created by bfpaige on 160224.
 */
abstract class CsvRecord<T> implements Record<T> {
    private final String filePath;
    private final long recordNumber;
    private final CSVFormat format;

    public CsvRecord(String filePath, long recordNumber, boolean hasHeaderRecord) {
        this(   filePath,
                recordNumber+(hasHeaderRecord?1:0),
                hasHeaderRecord?CSVFormat.DEFAULT.withHeader():CSVFormat.DEFAULT);
    }

    public CsvRecord(String filePath, long recordNumber) {
        this(filePath, recordNumber, CSVFormat.DEFAULT);
    }
    private CsvRecord(String filePath, long recordNumber, CSVFormat format) {
        this.filePath=filePath;
        this.recordNumber=recordNumber+1;
        this.format=format;
    }
    abstract protected T marshall(CSVRecord record);

    public T load() throws Exception {
        CSVRecord record=null;
        final FileReader in = new FileReader(filePath);
        final CSVParser records =format.parse(in);
        long size;
        try {
            record = findRecord(recordNumber, records);
        } catch (Exception ex) {
            throw ex;
        } finally {
            records.close();
            in.close();
        }
        if(record==null)
            throw new Exception("No record found at number(" + recordNumber + ") for " + filePath);
        return marshall(record);
    }

    private CSVRecord findRecord(long number, Iterable<CSVRecord> records) {
        CSVRecord csvRecord=null;
        for (CSVRecord record : records)
            if (record.getRecordNumber() == number)
                csvRecord=record;
        return csvRecord;
    }
}
