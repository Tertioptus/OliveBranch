package agent;

import com.olivebranch.Content;
import com.olivebranch.Input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bfpaige on 160223.
 */
public class Typed {

    final Map<Content, List> inputResultMap;

    public Typed(final Form form) {
        inputResultMap=new HashMap<Content,List>();
        inputResultMap.put(form.firstNameField, new ArrayList<String>());
        inputResultMap.put(form.lastNameField, new ArrayList<String>());
        inputResultMap.put(form.streetField, new ArrayList<String>());
        inputResultMap.put(form.stateField, new ArrayList<String>());
        inputResultMap.put(form.townField, new ArrayList<String>());
        inputResultMap.put(form.phoneNumberField, new ArrayList<String>());
        inputResultMap.put(form.emailAddressField, new ArrayList<String>());
    }

    public void log(Content content, Input input) {
        inputResultMap.get(content).add(input.value());
    }

    public boolean contains(Content content, String value) {
        return inputResultMap.get(content).contains(value);
    }
}
