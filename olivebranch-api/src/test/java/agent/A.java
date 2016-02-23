package agent;

import com.olivebranch.Input;
import com.olivebranch.The;
import com.olivebranch.mock.Profile;

/**
 * Created by bfpaige on 160223.
 */
public class A extends The{
    public static Input invalidPropertyOf(Profile person) throws Exception {
        return createInput(person.field("badName"));
    }
}
