package co.com.s4n.semillero.deliveries.domain.services;

import io.vavr.collection.List;

import java.io.BufferedWriter;
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

        Path path = FileService.getPath(fileName);

        List<String> stream = List.ofAll(Files.lines(path));

        return stream;
    }

    public static Boolean writeDeliveryMessage(String message) throws Exception{
        String fileName = "out.txt";
        Path path = FileService.getPath(fileName);
        Writer output;
        output = new BufferedWriter(new FileWriter(path.toString(), true));  //clears file every time
        ((BufferedWriter) output).newLine();
        output.append(message);
        output.close();
        return true;
    }

    private static Path getPath(String fileName) throws Exception{
        URI uri = ClassLoader.getSystemResource(fileName).toURI();
        String mainPath = Paths.get(uri).toString();
        return Paths.get(mainPath);
    }
}
