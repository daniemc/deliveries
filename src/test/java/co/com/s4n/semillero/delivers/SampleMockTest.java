package co.com.s4n.semillero.delivers;



import java.util.Iterator;

import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.Assert.*;


public class SampleMockTest {

    @Test
    public void MockSampleTest(){
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("Hello").thenReturn("Mockito!");
        String returnString = iterator.next() + " " + iterator.next();
        assertEquals("Hello Mockito!", returnString);
    }
}
