package parsers;

import Model.DataPoint;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by batto on 08-Feb-17.
 */
public class RegexHelper {
    public static String getFirstMatchedValueFromRegex(String regex, String text) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        if (matcher.find())
            return matcher.group(1);
        return null;
    }

    public static ArrayList<DataPoint> getDataPointsForString(String text) {
        ArrayList<DataPoint> dataPoints = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\((\\d+(?:\\.\\d+)?),(\\d+(?:\\.\\d+)?)\\)").matcher(text);
        while(matcher.find()) {
            DataPoint d = new DataPoint();
            d.setClock(Double.parseDouble(matcher.group(1)));
            d.setValue(Double.parseDouble(matcher.group(2)));
            dataPoints.add(d);
        }
        return dataPoints;
    }
}
