package Helpers;

import Model.Settings;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeolocationApi;
import com.google.maps.model.AddressType;
import com.google.maps.model.GeolocationPayload;
import com.google.maps.model.LatLng;

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
        try {
            return GeocodingApi
                    .reverseGeocode(context, getCurrentLocation())
                    .resultType(AddressType.STREET_ADDRESS)
                    .await()[0].formattedAddress;
        } catch (Exception e) {
            return null;
        }
    }
}
