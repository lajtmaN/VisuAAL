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

    public static double calculateLengthInMeters(LatLongBounds bounds) {
        return calculateLengthInMeters(bounds.getSouthWest(), bounds.getNorthEast());
    }

    public static double calculateLengthInMeters(LatLong sw, LatLong ne) {
        double hypo = sw.distanceFrom(ne);
        return Math.sin(Math.toRadians(45)) * hypo / Math.sin(Math.toRadians(90));
    }
}
