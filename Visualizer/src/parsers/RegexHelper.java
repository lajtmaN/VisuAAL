package parsers;

import Model.DataPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by batto on 08-Feb-17.
 */
public class RegexHelper {
    private static final String DataPointRegex = "\\((\\d+(?:\\.\\d+)?),(\\d+(?:\\.\\d+)?)\\)";
    private static final String SystemProcessesRegex = "^system\\s+(\\w+(?:\\s*,\\s*\\w+)*);";
    private static final String intPattern = "^-?\\d+$",
                                doublePattern = "^-?\\d+(.\\d+)?$";

    public static String getFirstMatchedValueFromRegex(String regex, String text) {
        return getNthMatchedValueFromRegex(regex, text, 1);
    }

    public static String getNthMatchedValueFromRegex(String regex, String text, int N) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        if (matcher.find())
            return matcher.group(N);
        return null;
    }

    public static ArrayList<DataPoint> getDataPointsForString(String text) {
        ArrayList<DataPoint> dataPoints = new ArrayList<>();
        Matcher matcher = Pattern.compile(DataPointRegex).matcher(text);
        while(matcher.find()) {
            DataPoint d = new DataPoint();
            d.setClock(Double.parseDouble(matcher.group(1)));
            d.setValue(Double.parseDouble(matcher.group(2)));
            dataPoints.add(d);
        }
        return dataPoints;
    }

    public static List<String> parseProcessesFromSystem(String input) {
        Matcher entireGroupMatcher = Pattern.compile(SystemProcessesRegex, Pattern.MULTILINE).matcher(input);
        Pattern processPattern = Pattern.compile("\\w+", Pattern.MULTILINE);
        ArrayList<String> matchedGroups = new ArrayList<>();
        while (entireGroupMatcher.find()) {
            Matcher m = processPattern.matcher(entireGroupMatcher.group(1));
            while (m.find()) {
                matchedGroups.add(m.group(0));
            }
        }
        return matchedGroups;
    }

    public static boolean isValidInt(String intText) {
        return getNthMatchedValueFromRegex(intPattern, intText, 0) != null;
    }

    public static boolean isValidDouble(String doubleText) {
        return getNthMatchedValueFromRegex(doublePattern, doubleText, 0) != null;
    }
}
