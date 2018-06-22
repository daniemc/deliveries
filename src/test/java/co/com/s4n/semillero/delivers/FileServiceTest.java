package co.com.s4n.semillero.delivers;
import co.com.s4n.semillero.deliveries.domain.services.FileService;
import io.vavr.control.Try;
import org.junit.Test;
public class FileServiceTest {

    @Test
    public void writeFile(){
        String message = "test";
        Try write = Try.of(() -> FileService.writeDeliveryMessage(message));
        System.out.println(write);
    }
}
