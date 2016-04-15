package agent;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.olivebranch.Agent;
import com.olivebranch.Content;
import com.olivebranch.Input;
import com.olivebranch.The;
import com.olivebranch.mock.SampleAddressRecords;
import com.olivebranch.mock.SampleEmailAddressRecords;
import com.olivebranch.mock.SampleFirstNameRecords;
import com.olivebranch.mock.SampleLastNameRecords;
import com.olivebranch.mock.SamplePhoneNumberRecords;
import com.olivebranch.mock.any.AnyPerson;
import com.olivebranch.mock.any.Person;

/**
 * A testing agent creates a random person from stock sample records and asserts
 * that the values extracted from a host of persons are indeed unique.
 *
 * @author Benjamin Paige
 * @version 1.0
 */
public class InputsDataFromRandomPersonProfileExtractionTest {

    //Given
    final Agent<String> agent = mock(Agent.class);
    final Form form = mock(Form.class);
    final Typed typed = new Typed(form);

    /**
     * Attempt to perform objective with valid input.
     *
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Test
    public void statedKeysFromPersonObjectReturnsValuesSuccessfully() throws Exception {
        //When type agent types into a content field
        when(agent.typeInto(any(Content.class), any(Input.class)))

                //Then categorically log the input value by content field
                .then(new Answer<Void>() {

                    public Void answer(InvocationOnMock invocation) throws Throwable {
                        Content content = (Content) invocation.getArguments()[0];
                        Input input = (Input) invocation.getArguments()[1];
                        typed.log(content, input);
                        return null;
                    }
                });

        //Generate a number of random persons
        for (int i = 0; i < 30; i++) {
            Person person = new AnyPerson(new SampleFirstNameRecords(),
                    new SampleLastNameRecords(),
                    new SampleAddressRecords(),
                    new SamplePhoneNumberRecords(),
                    new SampleEmailAddressRecords()
            );

            agent.typeInto(form.firstNameField, The.firstNameOf(person));
            agent.typeInto(form.lastNameField, The.lastNameOf(person));
            agent.typeInto(form.phoneNumberField, The.phoneNumberOf(person));
            agent.typeInto(form.emailAddressField, The.emailAddressOf(person));
            agent.typeInto(form.streetField, The.streetAddressOf(person));
            agent.typeInto(form.townField, The.townOf(person));
            agent.typeInto(form.stateField, The.stateOf(person));
            agent.typeInto(form.zipCodeField, The.zipCodeOf(person));
            agent.typeInto(form.longitudeField, The.longitudeOf(person));
            agent.typeInto(form.latitudeField, The.latitudeOf(person));
        }

        //Assert that multiple unique individuals have successfully been created
        new Validated(form, typed).prove();
    }

    /**
     * Attempt to perform objective with invalid input.
     */
    @Ignore
    public void nonStatedKeysFromPersonObjectReturnsEmptyString() throws Exception {
        //When type agent types into a content field
        when(agent.typeInto(any(Content.class), any(Input.class)))

                //Then categorically log the input value by content field
                .then(new Answer<Void>() {

                    public Void answer(InvocationOnMock invocation) throws Throwable {
                        Content content = (Content) invocation.getArguments()[0];
                        Input input = (Input) invocation.getArguments()[1];
                        Assert.assertTrue(input.value().isEmpty());
                        return null;
                    }
                });

        //Generate random person
        Person person = new AnyPerson(new SampleFirstNameRecords(),
                new SampleLastNameRecords(),
                new SampleAddressRecords(),
                new SamplePhoneNumberRecords(),
                new SampleEmailAddressRecords()
        );

        agent.typeInto(form.firstNameField, A.invalidPropertyOf(person));
    }
}
