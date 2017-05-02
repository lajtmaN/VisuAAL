package Helpers;

import Model.Settings;
import Model.topology.LatLng;
import Model.topology.LatLngBounds;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

/**
 * Created by lajtman on 23-03-2017.
 */
public class GoogleMapsHelper {
    public static LatLng getDefaultLocation() {
        double lat = Settings.Instance().getDefaultMapLocationLatitude();
        double lng = Settings.Instance().getDefaultMapLocationLongitude();
        return new LatLng(lat, lng);
    }

    /**
     * Calculate distance between two points in latitude and longitude in meters.
     * @param latLng1
     * @param latLng2
     * @return
     */
    public static double distanceBetween(LatLng latLng1, LatLng latLng2) {
        return distance(latLng1.lat, latLng2.lat, latLng1.lng, latLng2.lng, 0, 0);
    }

    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     * Borrowed from: http://stackoverflow.com/a/16794680
     * @returns Distance in Meters
     */
    private static double distance(double lat1, double lat2, double lon1,
                                   double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    public static Pair<Double, Double> calculateSizeInMeters(LatLngBounds bounds) {
        LatLng sw = bounds.getSouthWest();
        LatLng ne = bounds.getNorthEast();
        LatLng nw = new LatLng(ne.lat, sw.lng);

        double widthOnAllCells = GoogleMapsHelper.distanceBetween(nw, ne);
        double heightOnAllCells = GoogleMapsHelper.distanceBetween(nw, sw);
        return new Pair<Double, Double>(widthOnAllCells, heightOnAllCells);
    }

    public static LatLong convertToLatLong(LatLng location) {
        return new LatLong(location.lat, location.lng);
    }

    public static Marker createMarker(LatLng location, String description) {
        MarkerOptions options = new MarkerOptions();
        options.position(convertToLatLong(location));
        options.title(description);
        options.label(description);

        return new Marker(options);
    }
}
