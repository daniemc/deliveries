package co.com.s4n.semillero.deliveries.domain.services;

import co.com.s4n.semillero.deliveries.domain.app.Drone;
import io.vavr.collection.Iterator;
import io.vavr.collection.List;


public class MainService {

    public static void deliveries(){
        Iterator<List<String>> deliveriesList = DeliverService.createDeliveries();

        deliveriesList.forEach(delivery -> {
            Drone drone = DroneService.prepareDroneToDelivery(delivery);
            DroneService.dispatchDrone(drone);
        });
    }
}
