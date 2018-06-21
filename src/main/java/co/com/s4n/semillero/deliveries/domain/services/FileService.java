package co.com.s4n.semillero.deliveries.domain.services;

import io.vavr.collection.List;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {

    public static List<String> readDeliveriesFile() throws Exception{
        String fileName = "in.txt";
        URI uri = ClassLoader.getSystemResource(fileName).toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath);
        List<String> stream = List.ofAll(Files.lines(path));
        return stream;
    }

    public static Boolean writeDeliveryMessage(String message) throws Exception{
        String fileName = "out.txt";
        String path = new File("src/main/resources/"+fileName).getAbsolutePath();
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        writer.write(message);
        writer.newLine();
        writer.close();

        return true;
    }


}
