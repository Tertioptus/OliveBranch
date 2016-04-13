package agent;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.io.Resources;
import com.olivebranch.mock.Records;
import com.olivebranch.mock.any.AnyPerson;
import com.olivebranch.mock.any.Person;
import com.olivebranch.mock.csv.CsvAddressRecords;
import com.olivebranch.mock.csv.SingleColumnCsvRecords;

/**
 * Testing agent creates a set of unique persons from stock data in various CSV files.
 *
 * @author Benjamin Paige
 * @version 1.0
 * @since 1.0
 */
public class SetOfItemizedPersonProfileCSVFilesTest {

    private final Map<String, Records> csvData;

    public SetOfItemizedPersonProfileCSVFilesTest() {
        csvData = new HashMap<String, Records>();
        addStringCsv("firstNames.csv");
        addStringCsv("lastNames.csv");
        addStringCsv("emailAddresses.csv");
        addStringCsv("phoneNumbers.csv");
        addAddressCsv("addresses.csv");
    }

    /**
     * Links and files are all available and intact.
     */
    @Test
    public void createUniquePersons() throws Exception {
        Person person1 = new AnyPerson(
                csvData.get("firstNames.csv"),
                csvData.get("lastNames.csv"),
                csvData.get("addresses.csv"),
                csvData.get("emailAddresses.csv"),
                csvData.get("phoneNumbers.csv"));

        
        Person person2 = new AnyPerson(
                csvData.get("firstNames.csv"),
                csvData.get("lastNames.csv"),
                csvData.get("addresses.csv"),
                csvData.get("emailAddresses.csv"),
                csvData.get("phoneNumbers.csv"));

        //Prove that the same person is equal to itself
        Assert.assertTrue(person1.equals(person1));

        //Prove that two different persons are not equal
        Assert.assertFalse(person1.equals(person2));
    }

    private void addStringCsv(String filePath) {
        csvData.put(filePath, new SingleColumnCsvRecords(Resources.getResource(filePath)));
    }

    private void addAddressCsv(String filePath) {
        csvData.put(filePath, new CsvAddressRecords(Resources.getResource(filePath)));
    }
}
