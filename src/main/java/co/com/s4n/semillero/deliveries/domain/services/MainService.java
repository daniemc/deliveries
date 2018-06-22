package co.com.s4n.semillero.deliveries.domain.services;

import co.com.s4n.semillero.deliveries.domain.app.Drone;
import co.com.s4n.semillero.deliveries.domain.app.City;
import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import io.vavr.concurrent.Future;
import io.vavr.control.Try;
import sun.print.resources.serviceui;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MainService {

    public static void deliveries(List<String> deliveriesFiles){
        //Listar todos los archivos, pasarlos por deliveri service y hacer el list de futures de drone

        ExecutorService service = Executors.newFixedThreadPool(20);
        deliveriesFiles.take(20).flatMap(file -> Future.of(service, () -> {
            Iterator<List<String>> deliveriesList = DeliverService.createDeliveries(file, 10);
            String[] nameParts = file.split(Pattern.quote("."));

            if(nameParts.length == 2 && nameParts[0].length() == 4){

                AtomicInteger deliveryCount = new AtomicInteger(1);
                City city = new City(10, 10, -10, -10);
                deliveriesList.forEach(delivery -> {

                    Drone drone = DroneService.prepareDroneToDelivery(delivery, city, nameParts[0]);
                    Try.of(() -> FileService.writeDeliveryMessage(drone.outputFile,"Starts delivery: " + deliveryCount.getAndIncrement() + " ---"));
                    DroneService.dispatchDrone(drone);
                });
            }
            return "complete";
        }));


    }

    public static void deliveriesList(){
        Try.of(() -> FileService.listDeliveriesFiles())
                .onSuccess(fileList -> MainService.deliveries(fileList));
    }
}
