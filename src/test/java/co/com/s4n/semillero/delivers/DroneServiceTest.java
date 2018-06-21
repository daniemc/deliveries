package co.com.s4n.semillero.delivers;

import co.com.s4n.semillero.deliveries.domain.app.City;
import co.com.s4n.semillero.deliveries.domain.app.Drone;
import co.com.s4n.semillero.deliveries.domain.app.Orientation;
import co.com.s4n.semillero.deliveries.domain.app.Position;
import co.com.s4n.semillero.deliveries.domain.services.DeliverService;
import co.com.s4n.semillero.deliveries.domain.services.DroneService;
import io.vavr.collection.List;
import org.junit.Test;
import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.util.stream.Stream;


public class DroneServiceTest {

    @Test
    public void makeDeliveryTest(){
        List<String> address = List.of("AAAALAAR");
        City city = new City(5, 5, 5, 5);
        Drone drone = new Drone(address, new Position(0, 0), Orientation.N, city);
        Drone newdrone = DroneService.goToAddress(drone);
        assertTrue(newdrone.address.isEmpty());
        assertEquals(-2, newdrone.position.x);
        assertEquals(4, newdrone.position.y);
        assertEquals(Orientation.N, newdrone.orientation);
    }

    @Test
    public void readFileTest(){

    }
}
