package agent;

import agent.Form;
import agent.Typed;
import com.olivebranch.Content;
import com.olivebranch.mock.*;
import com.olivebranch.mock.any.Address;

import org.junit.Assert;

/**
 * Created by bfpaige on 160223.
 */
public class Validated {

    final Form form;
    final Typed typed;

    public Validated(final Form form, final Typed typed) {
        this.form=form;
        this.typed=typed;
    }


   public void prove() throws Exception {
        prove(new SamplePhoneNumberRecords(), form.phoneNumberField);
        prove(new SampleFirstNameRecords(), form.firstNameField);
        prove(new SampleLastNameRecords(), form.lastNameField);
        prove(new SampleEmailAddressRecords(), form.emailAddressField);
        prove(new SampleAddressRecords(), Address.Key.STREET_ADDRESS, form.streetField);
        prove(new SampleAddressRecords(), Address.Key.TOWN, form.townField);
        prove(new SampleAddressRecords(), Address.Key.STATE, form.stateField);
    }

    private void prove(SampleRecords<? extends Profile> sampleRecords,
                       String fieldName,
                       Content fieldContent) throws Exception {
        for(Profile profile : sampleRecords.getPayload()) {
            Assert.assertTrue(typed.contains(fieldContent,profile.field(fieldName)));
        }
    }

    private void prove(SampleRecords<String> sampleRecords, Content field) {
        for(String value : sampleRecords.getPayload()) {
            Assert.assertTrue(typed.contains(field,value));
        }
    }
    
    private void prove(SampleRecords<Address> sampleRecords, Address.Key key, Content field) throws Exception {
        for(Address address : sampleRecords.getPayload()) {
            Assert.assertTrue(typed.contains(field, address.field(key)));
        }
    }
}
