package co.com.s4n.semillero.deliveries.domain.services;

import io.vavr.collection.List;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileService {

    public static List<String> readDeliveriesFile(String fileName) throws Exception{

        URI uri = ClassLoader.getSystemResource(fileName).toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath);
        return List.ofAll(Files.lines(path));

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

    public static Stream<String> listDeliveriesFiles() throws Exception {

        String folderPath = new File("src/main/resources").getAbsolutePath();

        Stream<String> paths = Files.walk(Paths.get(folderPath))
                .filter(Files::isRegularFile)
                .filter(file -> file.getFileName().toString().startsWith("in"))
                .map(path -> path.getFileName().toString());
        return paths;

    }


}
