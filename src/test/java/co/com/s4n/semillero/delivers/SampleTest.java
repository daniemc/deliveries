package co.com.s4n.semillero.delivers;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.IncludeEngines;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@IncludeEngines("junit-jupiter")
public class SampleTest {

    @Test
    public void test(){
        assertTrue(true);
    }
}
