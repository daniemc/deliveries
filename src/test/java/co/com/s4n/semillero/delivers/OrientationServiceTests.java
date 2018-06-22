package co.com.s4n.semillero.delivers;

import co.com.s4n.semillero.deliveries.domain.app.Orientation;
import co.com.s4n.semillero.deliveries.domain.services.OrientationService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class OrientationServiceTests {

    @Test
    public void lFromTest(){
        Orientation or1 = OrientationService.lFrom(Orientation.N);
        Orientation or2 = OrientationService.lFrom(Orientation.E);
        Orientation or3 = OrientationService.lFrom(Orientation.S);
        Orientation or4 = OrientationService.lFrom(Orientation.O);

        assertEquals(Orientation.E, or1);
        assertEquals(Orientation.S, or2);
        assertEquals(Orientation.O, or3);
        assertEquals(Orientation.N, or4);
    }

    @Test
    public void rFromTest(){
        Orientation or1 = OrientationService.rFrom(Orientation.N);
        Orientation or2 = OrientationService.rFrom(Orientation.O);
        Orientation or3 = OrientationService.rFrom(Orientation.S);
        Orientation or4 = OrientationService.rFrom(Orientation.E);

        assertEquals(Orientation.O, or1);
        assertEquals(Orientation.S, or2);
        assertEquals(Orientation.E, or3);
        assertEquals(Orientation.N, or4);
    }

    @Test
    public void lFromTestFail(){
        Orientation or1 = OrientationService.lFrom(Orientation.N);
        Orientation or2 = OrientationService.lFrom(Orientation.E);
        Orientation or3 = OrientationService.lFrom(Orientation.S);
        Orientation or4 = OrientationService.lFrom(Orientation.O);

        assertNotEquals(Orientation.S, or1);
        assertNotEquals(Orientation.O, or2);
        assertNotEquals(Orientation.N, or3);
        assertNotEquals(Orientation.E, or4);
    }

    @Test
    public void rFromTestFail(){
        Orientation or1 = OrientationService.rFrom(Orientation.N);
        Orientation or2 = OrientationService.rFrom(Orientation.O);
        Orientation or3 = OrientationService.rFrom(Orientation.S);
        Orientation or4 = OrientationService.rFrom(Orientation.E);

        assertNotEquals(Orientation.S, or1);
        assertNotEquals(Orientation.E, or2);
        assertNotEquals(Orientation.N, or3);
        assertNotEquals(Orientation.O, or4);
    }
}