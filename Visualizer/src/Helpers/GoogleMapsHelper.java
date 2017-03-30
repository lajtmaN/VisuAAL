package Helpers;

import Model.Settings;
import Model.topology.LatLngBounds;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeolocationApi;
import com.google.maps.model.AddressType;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeolocationPayload;
import com.google.maps.model.LatLng;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.LatLongBounds;

import java.util.Arrays;

/**
 * Created by lajtman on 23-03-2017.
 */
public class GoogleMapsHelper {
    private static GeoApiContext context;

    static {
        context = new GeoApiContext().setApiKey(Settings.Instance().getGoogleAPIKey());
    }

    public static LatLng getCurrentLocation() {
        try {
            return GeolocationApi
                    .geolocate(context, new GeolocationPayload())
                    .await().location;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getCurrentAddress() {
        return convertLatLngToAddress(getCurrentLocation());
    }

    public static String convertLatLngToAddress(LatLng latLng) {
        try {
            return GeocodingApi
                    .reverseGeocode(context, latLng)
                    .resultType(AddressType.STREET_ADDRESS)
                    .await()[0].formattedAddress;
        } catch (Exception e) {
            return null;
        }
    }

    public static double distanceBetween(LatLng p1, LatLng p2) {
        LatLong first = new LatLong(p1.lat, p1.lng);
        LatLong sec = new LatLong(p2.lat, p2.lng);
        return first.distanceFrom(sec);
    }

    public static Pair<Double, Double> calculateGridSizeInMeters(LatLngBounds bounds) {
        LatLng sw = bounds.getSouthWest();
        LatLng ne = bounds.getNorthEast();
        LatLng nw = new LatLng(ne.lat, sw.lng);

        double widthOnAllCells = GoogleMapsHelper.distanceBetween(nw, ne);
        double heightOnAllCells = GoogleMapsHelper.distanceBetween(nw, sw);
        return new Pair<Double, Double>(widthOnAllCells, heightOnAllCells);
    }
}
