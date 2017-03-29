package Helpers;

import Model.Settings;
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

    public static double distanceBetween(LatLong p1, LatLong p2) {
        return p1.distanceFrom(p2);
    }

    public static Pair<Double, Double> calculateGridSizeInMeters(LatLongBounds bounds) {
        LatLong sw = bounds.getSouthWest();
        LatLong ne = bounds.getNorthEast();
        LatLong nw = new LatLong(ne.getLatitude(), sw.getLongitude());

        double widthOnAllCells = GoogleMapsHelper.distanceBetween(nw, ne);
        double heightOnAllCells = GoogleMapsHelper.distanceBetween(nw, sw);
        return new Pair<Double, Double>(widthOnAllCells, heightOnAllCells);
    }
}
