package co.com.s4n.semillero.deliveries.domain.app;

import io.vavr.collection.List;

public class Order {
    List<String> address;
    public Order(List<String> address){
        this.address = address;
    }
}
