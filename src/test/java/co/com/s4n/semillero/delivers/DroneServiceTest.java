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
        Drone drone = new Drone(address, new Position(0, 0), Orientation.N, city, "01");
        Drone newdrone = DroneService.goToAddress(drone);
        assertTrue(newdrone.address.isEmpty());
        assertEquals(-2, newdrone.position.x);
        assertEquals(4, newdrone.position.y);
        assertEquals(Orientation.N, newdrone.orientation);
    }

    @Test
    public void moveTest(){
        Position position1 = DroneService.move(Orientation.N, new Position(0,0));
        Position position2 = DroneService.move(Orientation.E, new Position(0,0));
        Position position3 = DroneService.move(Orientation.S, new Position(0,0));
        Position position4 = DroneService.move(Orientation.O, new Position(0,0));

        assertEquals(new Position(0, 1).x, position1.x);
        assertEquals(new Position(0, 1).y, position1.y);

        assertEquals(new Position(-1, 0).x, position2.x);
        assertEquals(new Position(-1, 0).y, position2.y);

        assertEquals(new Position(0, -1).x, position3.x);
        assertEquals(new Position(0, -1).y, position3.y);

        assertEquals(new Position(1, 0).x, position4.x);
        assertEquals(new Position(1, 0).y, position4.y);
    }

    @Test
    public void moveTestFail(){
        Position position1 = DroneService.move(Orientation.N, new Position(0,0));
        Position position2 = DroneService.move(Orientation.E, new Position(0,0));
        Position position3 = DroneService.move(Orientation.S, new Position(0,0));
        Position position4 = DroneService.move(Orientation.O, new Position(0,0));

        assertNotSame(new Position(1, -1).x, position1.x);
        assertNotSame(new Position(1, -1).y, position1.y);

        assertNotSame(new Position(1, 1).x, position2.x);
        assertNotSame(new Position(1, 1).y, position2.y);

        assertNotSame(new Position(1, 1).x, position3.x);
        assertNotSame(new Position(1, 1).y, position3.y);

        assertNotSame(new Position(-1, 1).x, position4.x);
        assertNotSame(new Position(-1, 1).y, position4.y);
    }


}
