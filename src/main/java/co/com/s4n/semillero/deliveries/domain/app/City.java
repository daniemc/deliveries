package co.com.s4n.semillero.deliveries.domain.app;

public class Map {
    public int nLimit;
    public int sLimit;
    public int eLimit;
    public int oLimit;

    public Map(int nLimit, int sLimit, int eLimit, int oLimit){
        this.nLimit = nLimit;
        this.sLimit = sLimit;
        this.eLimit = eLimit;
        this.oLimit = oLimit;
    }
}
