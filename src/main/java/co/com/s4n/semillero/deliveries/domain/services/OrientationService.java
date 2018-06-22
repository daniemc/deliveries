package co.com.s4n.semillero.deliveries.domain.services;

import co.com.s4n.semillero.deliveries.domain.app.Orientation;
import co.com.s4n.semillero.deliveries.domain.app.Position;

public class OrientationService {

    public static Orientation lFrom(Orientation orientation){
        Orientation newOrientation = orientation;
        switch (orientation){
            case N:
                newOrientation = Orientation.E;
                break;
            case E:
                newOrientation = Orientation.S;
                break;
            case S:
                newOrientation = Orientation.O;
                break;
            case O:
                newOrientation = Orientation.N;
                break;
            default:
                break;
        }
        return newOrientation;
    }

    public static Orientation rFrom(Orientation orientation){
        Orientation newOrientation = orientation;
        switch (orientation){
            case N:
                newOrientation = Orientation.O;
                break;
            case O:
                newOrientation = Orientation.S;
                break;
            case S:
                newOrientation = Orientation.E;
                break;
            case E:
                newOrientation = Orientation.N;
                break;
            default:
                break;
        }
        return newOrientation;
    }

}
