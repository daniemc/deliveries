package co.com.s4n.semillero.delivers;

import co.com.s4n.semillero.deliveries.domain.services.DeliverService;
import io.vavr.collection.List;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.IncludeEngines;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@IncludeEngines("junit-jupiter")
public class DeliveryServiceTest {

    @Test
    public void readFileTest(){
        DeliverService.createDeliveries();
    }
}
