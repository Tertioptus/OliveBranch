package agent;

import com.google.common.io.Resources;
import com.olivebranch.mock.csv.SingleColumnCsvRecords;
import com.olivebranch.mock.any.Person;
import com.olivebranch.mock.csv.CsvAddressRecords;
import org.junit.Test;

/**
 * Testing agent creates a set of unique persons from stock data in various CSV files.
 *
 * @author Benjamin Paige
 * @version 1.0
 * @since 1.0
 */
public class CreatesUniquePersonsFromCSVFilesTest {

    /**
     * Links and files are all available and intact.
     */
    @Test
    public void withProperSetup() {
        final SingleColumnCsvRecords firstNames
                = new SingleColumnCsvRecords(Resources.getResource("firstNames.csv"));
        final SingleColumnCsvRecords lastNames
                = new SingleColumnCsvRecords(Resources.getResource("lastNames.csv"));
        final CsvAddressRecords addresses
                = new CsvAddressRecords(Resources.getResource("addresses.csv"));
        final SingleColumnCsvRecords emailAddresses
                = new SingleColumnCsvRecords(Resources.getResource("emailAddresses.csv"));
        final SingleColumnCsvRecords phoneNumbers
                = new SingleColumnCsvRecords(Resources.getResource("phoneNumbers.csv"));

        Person person1 = new Person(firstNames, lastNames, addresses, emailAddresses, phoneNumbers);
        Person person2 = new Person(firstNames, lastNames, addresses, emailAddresses, phoneNumbers);
    }
}
