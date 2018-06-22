package co.com.s4n.semillero.deliveries.domain.app;

import io.vavr.collection.List;

public class Drone {

    public List<String> address;
    public Position position;
    public Orientation orientation;
    public City cityMap;

    public Drone(List<String> address, Position position, Orientation orientation, City cityMap){
        this.address = address;
        this.position = position;
        this.orientation = orientation;
        this.cityMap = cityMap;
    }
}
