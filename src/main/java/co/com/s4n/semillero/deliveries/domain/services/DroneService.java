package co.com.s4n.semillero.deliveries.domain.services;

import co.com.s4n.semillero.deliveries.domain.app.Drone;
import co.com.s4n.semillero.deliveries.domain.app.Orientation;
import co.com.s4n.semillero.deliveries.domain.app.Position;
import io.vavr.collection.List;
import io.vavr.control.Try;

import java.util.concurrent.atomic.AtomicInteger;

public class DroneService {

    public static Drone goToAddress(Drone drone){

        final Orientation[] orientation = {drone.orientation};

        AtomicInteger newy = new AtomicInteger(drone.position.y);
        AtomicInteger newx = new AtomicInteger(drone.position.x);


        drone.address.head().chars().forEach(c -> {

            switch (orientation[0]){
                case N:
                    switch (c){
                        case 'A':
                            newy.getAndIncrement();
                            break;
                        case 'L':
                            orientation[0] = OrientationService.lFromN();
                            break;
                        case 'R':
                            orientation[0] = OrientationService.rFromN();
                            break;
                        default:
                            break;
                    }
                    break;
                case E:
                    switch (c){
                        case 'A':
                            newx.getAndIncrement();
                            break;
                        case 'L':
                            orientation[0] = OrientationService.lFromE();
                            break;
                        case 'R':
                            orientation[0] = OrientationService.rFromE();
                            break;
                        default:
                            break;
                    }
                    break;
                case S:
                    switch (c){
                        case 'A':
                            newy.getAndDecrement();
                            break;
                        case 'L':
                            orientation[0] = OrientationService.lFromS();
                            break;
                        case 'R':
                            orientation[0] = OrientationService.rFromS();
                            break;
                        default:
                            break;
                    }
                    break;
                case O:
                    switch (c){
                        case 'A':
                            newx.getAndDecrement();
                            break;
                        case 'L':
                            orientation[0] = OrientationService.lFromO();
                            break;
                        case 'R':
                            orientation[0] = OrientationService.rFromO();
                            break;
                        default:
                            break;
                    }
                default:
                    new Exception("Error");
                    break;
            }
        });

        Position newPosition = new Position(newx.intValue(), newy.intValue());
        Orientation newOrientation = orientation[0];
        List<String> newAddressList = drone.address.filter(ad -> ad != drone.address.head());

        DroneService.reportPosition(newPosition, newOrientation);

        return new Drone(newAddressList, newPosition, newOrientation);

    }

    public static Drone prepareDroneToDelivery(List<String> delivery){
        return new Drone(delivery, new Position(0, 0), Orientation.N);
    }

    public static void dispatchDrone(Drone drone){
        Drone droneDelivery = DroneService.goToAddress(drone);
        while (droneDelivery.address.size() > 0){
            droneDelivery = DroneService.goToAddress(droneDelivery);
        }
    }

    private static void reportPosition(Position position, Orientation orientation){
        // TODO
        // report position to txt file
        String message = "Entrega en: (" + position.x + ", " + position.y + " - " + orientation + ")";
        //System.out.println(message);
        Try writeMessage = Try.of(() -> (FileService.writeDeliveryMessage(message)));
    }
}
