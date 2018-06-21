package co.com.s4n.semillero.deliveries.domain.services;

import co.com.s4n.semillero.deliveries.domain.app.Drone;
import co.com.s4n.semillero.deliveries.domain.app.City;
import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import io.vavr.control.Try;

import java.util.concurrent.atomic.AtomicInteger;


public class MainService {

    public static void deliveries(){
        Iterator<List<String>> deliveriesList = DeliverService.createDeliveries();
        AtomicInteger deliveryCount = new AtomicInteger(1);
        City city = new City(10, 10, -10, -10);
        deliveriesList.forEach(delivery -> {
            Drone drone = DroneService.prepareDroneToDelivery(delivery, city);
            Try.of(() -> FileService.writeDeliveryMessage("Starts delivery: " + deliveryCount.getAndIncrement() + " ---"));
            DroneService.dispatchDrone(drone);
        });
    }
}
