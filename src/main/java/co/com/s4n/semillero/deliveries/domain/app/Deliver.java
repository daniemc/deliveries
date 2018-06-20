package co.com.s4n.semillero.deliveries.domain.app;

import io.vavr.collection.List;

public class Deliver {

    Order orders;
    Drone drone;

    public Deliver(Order order, Drone drone){
        this.orders = order;
        this.drone = drone;
    }
}
