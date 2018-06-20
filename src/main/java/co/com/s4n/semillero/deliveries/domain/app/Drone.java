package co.com.s4n.semillero.deliveries.domain.app;

import io.vavr.collection.List;

public class Drone {

    public List<String> address;
    public Position position;
    public Orientation orientation;

    public Drone(List<String> address, Position position, Orientation orientation){
        this.address = address;
        this.position = position;
        this.orientation = orientation;
    }
}
