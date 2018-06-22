package co.com.s4n.semillero.deliveries.domain.services;

import io.vavr.collection.List;
import io.vavr.control.Try;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FileService {

    public static List<String> readDeliveriesFile(String fileName) throws Exception{

        URI uri = ClassLoader.getSystemResource(fileName).toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath);
        return List.ofAll(Files.lines(path));

    }

    public static Boolean writeDeliveryMessage(String fileName, String message) throws Exception{

        if (fileName != "") {
            String path = new File("src/main/resources/"+fileName).getAbsolutePath();
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.write(message);
            writer.newLine();
            writer.close();
        } else {
            return false;
        }
        return true;
    }

    public static List<String> listDeliveriesFiles() throws Exception {

        String folderPath = new File("src/main/resources").getAbsolutePath();

        Stream<String> paths = Files.walk(Paths.get(folderPath))
                .filter(Files::isRegularFile)
                .filter(file -> file.getFileName().toString().startsWith("in"))
                .map(path -> path.getFileName().toString());

        ArrayList<String> fileList = new ArrayList<>();
        Consumer<String> setFile = file -> {
            fileList.add(file);
        };
        paths.forEach(setFile);
        List<String> returnList = List.ofAll(fileList);

        return returnList;

    }


}
