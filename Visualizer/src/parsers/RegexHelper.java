package parsers;

import Model.DataPoint;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by batto on 08-Feb-17.
 */
public class RegexHelper {
    public static String systemProcessesRegex = "^system\\s+(\\w+)(?:\\s*,\\s*(\\w+))*;";

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
        Matcher matcher = Pattern.compile("\\((\\d+(?:\\.\\d+)?),(\\d+(?:\\.\\d+)?)\\)").matcher(text);
        while(matcher.find()) {
            DataPoint d = new DataPoint();
            d.setClock(Double.parseDouble(matcher.group(1)));
            d.setValue(Double.parseDouble(matcher.group(2)));
            dataPoints.add(d);
        }
        return dataPoints;
    }

    public static boolean variableNameMatches(String var1, String var2) {
        Pattern p = Pattern.compile("(\\w*).*");
        Matcher m1 = p.matcher(var1);
        Matcher m2 = p.matcher(var2);

        m1.find();
        m2.find();

        return m1.group(1).equals(m2.group(1));
    }

    public static List<String> parseProcessesFromSystem(String input) {
        Matcher entireGroupMatcher = Pattern.compile("^system\\s+(\\w+(?:\\s*,\\s*\\w+)*);", Pattern.MULTILINE).matcher(input);
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
}
