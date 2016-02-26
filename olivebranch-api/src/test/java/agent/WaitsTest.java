package agent;

import com.olivebranch.Agent;
import com.olivebranch.Just;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by bfpaige on 160222.
 */
public class WaitsTest {
    //Given
    final Agent<String> agent = mock(Agent.class);
    final Form form = mock(Form.class);
    final Typed typed = new Typed(form);
    
    @Test
    public void anyGivenAmountOfSecondsDesignatedByJustEnumerator() {
        
        assertEquals(Just.ONE.second().milliseconds(),1000);
        assertEquals(Just.TWO.seconds().milliseconds(),2000);
        assertEquals(Just.THREE.seconds().milliseconds(),3000);
        assertEquals(Just.FOUR.seconds().milliseconds(),4000);
        assertEquals(Just.FIVE.seconds().milliseconds(),5000);
        assertEquals(Just.SIX.seconds().milliseconds(),6000);
        assertEquals(Just.SEVEN.seconds().milliseconds(),7000);
        assertEquals(Just.EIGHT.seconds().milliseconds(),8000);
        assertEquals(Just.NINE.seconds().milliseconds(),9000);
        assertEquals(Just.TEN.seconds().milliseconds(),10000);
        assertEquals(Just.TWENTY.seconds().milliseconds(),20000);
        assertEquals(Just.THIRTY.seconds().milliseconds(),30000);
    }

    @Test
    public void anyGivenAmountOfMinutesDesignatedByJustEnumerator() {

        assertEquals(Just.ONE.minute().milliseconds(),60000);
        assertEquals(Just.TWO.minutes().milliseconds(),60000*2);
        assertEquals(Just.THREE.minutes().milliseconds(),60000*3);
        assertEquals(Just.FOUR.minutes().milliseconds(),60000*4);
        assertEquals(Just.FIVE.minutes().milliseconds(),60000*5);
        assertEquals(Just.SIX.minutes().milliseconds(),60000*6);
        assertEquals(Just.SEVEN.minutes().milliseconds(),60000*7);
        assertEquals(Just.EIGHT.minutes().milliseconds(),60000*8);
        assertEquals(Just.NINE.minutes().milliseconds(),60000*9);
        assertEquals(Just.TEN.minutes().milliseconds(),60000*10);
        assertEquals(Just.TWENTY.minutes().milliseconds(),60000*20);
        assertEquals(Just.THIRTY.minutes().milliseconds(),60000*30);
    }
}
