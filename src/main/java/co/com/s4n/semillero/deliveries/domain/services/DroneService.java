package co.com.s4n.semillero.deliveries.domain.services;

import co.com.s4n.semillero.deliveries.domain.app.*;
import io.vavr.collection.List;
import io.vavr.control.Try;

import java.util.concurrent.atomic.AtomicInteger;

public class DroneService {

    public static Drone goToAddress(Drone drone){
        final Orientation[] orientation = {drone.orientation};
        final Position[] dronePosition = {drone.position};

        drone.address.head().chars().forEach(move -> {

            switch (move){
                case 'A':
                    dronePosition[0] = move(orientation[0], dronePosition[0]);
                    break;
                case 'L':
                    orientation[0] = OrientationService.lFrom(orientation[0]);
                    break;
                case 'R':
                    orientation[0] = OrientationService.rFrom(orientation[0]);
                    break;
                default:
                    new Exception("Move not found");
                    break;
            }

        });


        List<String> newAddressList = drone.address.filter(ad -> ad != drone.address.head());

        DroneService.reportPosition(dronePosition[0], orientation[0], drone.outputFile);

        return new Drone(newAddressList, dronePosition[0], orientation[0], drone.cityMap, drone.name);

    }

    public static Position move(Orientation orientation, Position oldPosition){

        Position position = oldPosition;
        switch (orientation) {
            case N:
                position = new Position(position.x, position.y + 1);
                break;
            case S:
                position = new Position(position.x, position.y - 1);
                break;
            case O:
                position = new Position(position.x + 1, position.y);
                break;
            case E:
                position = new Position(position.x - 1, position.y);
                break;
            default:
                break;
        }

        return position;
    }


    public static Drone prepareDroneToDelivery(List<String> delivery, City city, String name){
        return new Drone(delivery, new Position(0, 0), Orientation.N, city, name);
    }

    public static void dispatchDrone(Drone drone){
        Drone droneDelivery = DroneService.goToAddress(drone);
        while (droneDelivery.address.size() > 0){
            droneDelivery = DroneService.goToAddress(droneDelivery);
        }
    }

    private static void reportPosition(Position position, Orientation orientation, String droneOutput){

        String message = "Entrega en: (" + position.x + ", " + position.y + " - " + orientation + ")";
        Try.of(() -> (FileService.writeDeliveryMessage(droneOutput, message)));
    }
}
