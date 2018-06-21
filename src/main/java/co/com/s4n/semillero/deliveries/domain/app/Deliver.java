package co.com.s4n.semillero.deliveries.domain.app;

public class Deliver {

    Order orders;
    Drone drone;
    City city;

    public Deliver(Order order, Drone drone, City city){
        this.orders = order;
        this.drone = drone;
        this.city = city;
    }
}
