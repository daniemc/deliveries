package co.com.s4n.semillero.delivers;

import co.com.s4n.semillero.deliveries.domain.app.Drone;
import co.com.s4n.semillero.deliveries.domain.app.Orientation;
import co.com.s4n.semillero.deliveries.domain.app.Position;
import co.com.s4n.semillero.deliveries.domain.services.DeliverService;
import co.com.s4n.semillero.deliveries.domain.services.DroneService;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.IncludeEngines;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@IncludeEngines("junit-jupiter")
public class DroneServiceTest {

    @Test
    public void makeDeliveryTest(){
        List<String> address = List.of("AAAARAAL", "ALA", "ARA");
        Drone drone = new Drone(address, new Position(0, 0), Orientation.N);
        Drone newdrone = DroneService.goToAddress(drone);
        System.out.println("address list" + newdrone.address);
        System.out.println("position x " + newdrone.position.x);
        System.out.println("position y " + newdrone.position.y);
        System.out.println("orientation " + newdrone.orientation);
    }

    @Test
    public void readFileTest(){

        DeliverService.createDeliveries();
    }
}
