package co.com.s4n.semillero.deliveries.domain.services;

import co.com.s4n.semillero.deliveries.domain.app.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DeliverService {

    public static void createDeliveries(){
        String fileName = "in.txt";
        ClassLoader classLoader = DeliverService.class.getClassLoader();
        try (Stream<String> stream = Files.lines(Paths.get(classLoader.getResource(fileName).getFile()))) {
            stream.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
