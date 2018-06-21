package co.com.s4n.semillero.delivers;


import co.com.s4n.semillero.deliveries.domain.services.DeliverService;
import co.com.s4n.semillero.deliveries.domain.services.FileService;
import co.com.s4n.semillero.deliveries.domain.services.MainService;
import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Test;

import static org.junit.Assert.*;


public class DeliveryServiceTest {

    @Test
    public void readFileTest(){
        Try<List<String>> deliveriesList = Try.of(() -> FileService.readDeliveriesFile("in.txt"));
        assertTrue(deliveriesList.isSuccess());
    }

    @Test
    public void getDeliveriesListTest(){
        Iterator<List<String>> deliveriesList = DeliverService.createDeliveries("in.txxt");
        deliveriesList.forEach(list -> {
            System.out.println(list);
        });
    }

    @Test
    public void main(){
        MainService.deliveries();
    }
}
