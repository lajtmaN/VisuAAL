package Model.topology;

import com.google.maps.model.LatLng;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.LatLongBounds;

import java.io.*;

/**
 * Created by lajtman on 29-03-2017.
 */
public class LatLngBounds implements Externalizable {

    private LatLng sw;
    private LatLng ne;

    public LatLngBounds(LatLongBounds bounds) {
        this(bounds.getSouthWest(), bounds.getNorthEast());
    }
    public LatLngBounds(LatLong sw, LatLong ne) {
        this(new LatLng(sw.getLatitude(), sw.getLongitude()), new LatLng(ne.getLatitude(), ne.getLongitude()));
    }
    public LatLngBounds(LatLng sw, LatLng ne) {
        this.sw = sw;
        this.ne = ne;
    }
    public LatLngBounds() {//Only for Externalization

    }

    public LatLng getSouthWest() {
        return sw;
    }

    public LatLng getNorthEast() {
        return ne;
    }

    public LatLongBounds getAsLatLongBounds() {
        return new LatLongBounds(new LatLong(sw.lat, sw.lng), new LatLong(ne.lat, ne.lng));
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(sw.lat);
        out.writeDouble(sw.lng);
        out.writeDouble(ne.lat);
        out.writeDouble(ne.lng);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        double swLat = in.readDouble();
        double swLng = in.readDouble();
        sw = new LatLng(swLat, swLng);

        double neLat = in.readDouble();
        double neLng = in.readDouble();
        ne = new LatLng(neLat, neLng);
    }
}
