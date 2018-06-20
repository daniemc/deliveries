package co.com.s4n.semillero.delivers;

import co.com.s4n.semillero.delivers.utils.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.IncludeEngines;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.Iterator;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@IncludeEngines("junit-jupiter")
public class SampleMockTest {

    @Test
    public void MockSampleTest(){
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("Hello").thenReturn("Mockito!");
        String returnString = iterator.next() + " " + iterator.next();
        assertEquals("Hello Mockito!", returnString);
    }
}
