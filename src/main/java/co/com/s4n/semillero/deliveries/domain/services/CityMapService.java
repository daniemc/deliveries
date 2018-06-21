package co.com.s4n.semillero.deliveries.domain.services;

import co.com.s4n.semillero.deliveries.domain.app.City;
import co.com.s4n.semillero.deliveries.domain.app.Orientation;
import co.com.s4n.semillero.deliveries.domain.app.Position;

public class CityMapService {

    public static Boolean isValidMove(Orientation orientation, City city, Position position){
        Boolean resp = true;
        switch (orientation){
            case N:
                resp = position.y + 1 <= city.nLimit;
                break;
            case E:
                resp = position.x + 1 <= city.eLimit;
                break;
            case S:
                resp = position.y - 1 >= city.sLimit;
                break;
            case O:
                resp = position.x - 1 >= city.oLimit;
                break;
            default:
                break;
        }
        return resp;
    }
}
