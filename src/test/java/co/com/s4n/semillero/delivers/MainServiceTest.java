package co.com.s4n.semillero.delivers;

import co.com.s4n.semillero.deliveries.domain.services.MainService;
import org.junit.Test;

public class MainServiceTest {

    @Test
    public void getListTest(){
        MainService.startDeliveries();
    }
}
