package co.com.s4n.semillero.deliveries.domain.services;

import co.com.s4n.semillero.deliveries.domain.app.*;
import io.vavr.collection.Iterator;
import io.vavr.control.Try;

import io.vavr.collection.List;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeliverService {

    private static List<String> deliveriesList(){
        Try<List<String>> deliveriesList =
                Try.of(() -> (FileService.readDeliveriesFile()))
                .recoverWith(Exception.class, Try.of(() -> {
                    List<String> defaultStream = List.empty();
                    return defaultStream;
                }))
                .map(list -> list);

        return deliveriesList.get();
    }

    private static Iterator<List<String>> partitionDeliveries(List<String> list, int size) {

        return list.grouped(size);

    }

    public static Iterator<List<String>> createDeliveries(){
        List<String> initialDeliveriesList = DeliverService.deliveriesList();
        return  DeliverService.partitionDeliveries(initialDeliveriesList, 3);
    }

}
