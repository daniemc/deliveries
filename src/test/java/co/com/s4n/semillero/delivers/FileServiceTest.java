package co.com.s4n.semillero.delivers;
import co.com.s4n.semillero.deliveries.domain.services.FileService;
import io.vavr.control.Try;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FileServiceTest {

    @Test
    public void writeFile(){
        String message = "test";
        Try write = Try.of(() -> FileService.writeDeliveryMessage(message));
        assertTrue(write.isSuccess());
    }

    @Test
    public void listFolderTest(){
        Try read = Try.of(() -> FileService.listDeliveriesFiles());
        assertTrue(read.isSuccess());
    }
}
