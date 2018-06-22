package co.com.s4n.semillero.delivers;
import co.com.s4n.semillero.deliveries.domain.services.FileService;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileServiceTest {

    @Test
    public void writeFile(){
        String message = "test";
        String outputFile = "test.txt";
        Try write = Try.of(() -> FileService.writeDeliveryMessage(outputFile, message));
        assertTrue(write.isSuccess());
        assertEquals(true, write.get());
    }

    @Test
    public void readFile(){
        String message = "test";
        String outputFile = "test.txt";
        Try write = Try.of(() -> FileService.writeDeliveryMessage(outputFile, message))
                .andThen(() -> {
                    Try.of(() -> FileService.readDeliveriesFile("test.txt"))
                            .andThen(resultw -> {
                                assertTrue(resultw.get().length() > 0);
                                assertEquals("test", resultw.get(0));
                            });
                });
    }

    @Test
    public void writeFileFail(){
        String message = "test";
        String outputFile = "";
        Try write = Try.of(() -> FileService.writeDeliveryMessage(outputFile, message));
        assertEquals(false, write.get());
    }

    @Test
    public void listFolderTest(){
        Try read = Try.of(() -> FileService.listDeliveriesFiles());
        assertTrue(read.isSuccess());
    }
}
