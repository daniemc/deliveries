package co.com.s4n.semillero.deliveries.domain.services;

import co.com.s4n.semillero.deliveries.domain.app.Orientation;
import co.com.s4n.semillero.deliveries.domain.app.Position;

public class OrientationService {

    public static Orientation lFromN(){
        return Orientation.O;
    }

    public static Orientation lFromO(){
        return Orientation.S;
    }

    public static Orientation lFromS(){
        return Orientation.E;
    }

    public static Orientation lFromE(){
        return Orientation.N;
    }

    public static Orientation rFromN(){
        return Orientation.E;
    }

    public static Orientation rFromO(){
        return Orientation.N;
    }

    public static Orientation rFromS(){
        return Orientation.E;
    }

    public static Orientation rFromE(){
        return Orientation.S;
    }
}
