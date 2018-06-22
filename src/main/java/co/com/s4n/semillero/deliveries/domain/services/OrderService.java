package co.com.s4n.semillero.deliveries.domain.services;

import co.com.s4n.semillero.deliveries.domain.app.Order;
import io.vavr.collection.List;

public class OrderService {
    //Aqui creo las ordenes a partir de la lectura del archivo
    public static Order createOrders(){
        List<String> ordersList = List.of("AAR", "AAL", "LAA");
        return new Order(ordersList);
    }
}
