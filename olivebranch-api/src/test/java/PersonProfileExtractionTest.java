import com.olivebranch.The;
import com.olivebranch.mock.*;
import com.olivebranch.mock.any.Address;
import com.olivebranch.mock.any.Person;
import org.junit.Test;

public class PersonProfileExtractionTest {

	@SuppressWarnings("unchecked")
	@Test
	public void statedKeysFromNameObjectReturnsValuesSuccessfully() throws Exception {
		Records<String> firstNameRecords = new SampleFirstNameRecords();
		Records<String> lastNameRecords = new SampleLastNameRecords();
		Records<Address> addressRecords = new SampleAddressRecords();
		Records<String> emailAddressRecords = new EmailAddressRecords();
		Records<String> phoneNumberRecords = new PhoneNumberRecords();

		for (int i = 0; i < 30; i++) {
			Person person = new Person(firstNameRecords,
										lastNameRecords,
										addressRecords,
										phoneNumberRecords,
										emailAddressRecords
									);

			System.out.println(The.firstNameOf(person)
					+ " " + The.lastNameOf(person)
					+ " " + person.field("streetAddress1") );
		}
	}

	@Test
	public void nonStatedKeysFromNameObjectReturnsEmptyString() {

	}
}
