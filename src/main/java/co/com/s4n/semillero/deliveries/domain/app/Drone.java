package co.com.s4n.semillero.deliveries.domain.app;

import io.vavr.collection.List;

public class Drone {

    public List<String> address;
    public Position position;
    public Orientation orientation;
    public City cityMap;
    public String name;
    public String outputFile;
    public String inputFile;

    public Drone(List<String> address, Position position, Orientation orientation, City cityMap, String name){
        this.address = address;
        this.position = position;
        this.orientation = orientation;
        this.cityMap = cityMap;
        this.name = name;
        this.inputFile = "in" + name;
        this.outputFile = "out" + name;
    }
}
