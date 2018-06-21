package co.com.s4n.semillero.deliveries.domain.services;

import co.com.s4n.semillero.deliveries.domain.app.Drone;
import co.com.s4n.semillero.deliveries.domain.app.City;
import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import io.vavr.control.Try;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


public class MainService {

    public static void deliveries(){
        //Listar todos los archivos, pasarlos por deliveri service y hacer el list de futures de drone

        Iterator<List<String>> deliveriesList = DeliverService.createDeliveries("in.txt");
        AtomicInteger deliveryCount = new AtomicInteger(1);
        City city = new City(10, 10, -10, -10);
        deliveriesList.forEach(delivery -> {
            Drone drone = DroneService.prepareDroneToDelivery(delivery, city, List.of(1));
            Try.of(() -> FileService.writeDeliveryMessage("Starts delivery: " + deliveryCount.getAndIncrement() + " ---"));
            DroneService.dispatchDrone(drone);
        });
    }

    public static void deliveriesList(){
        Stream<String> listFiles = Try.of(() -> FileService.listDeliveriesFiles());

        listFiles.onSuccess(files -> {
            System.out.println(files);
            files.map(file -> {
                System.out.println(file);
                return true;
            });

        });
    }
}
