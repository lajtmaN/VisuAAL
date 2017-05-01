package Helpers;


/**
 * Created by lajtman on 01-05-2017.
 */
public class StringHelper {
    public static int countOccurrences(String searchInText, char charToSearchFor) {
        int count = 0;
        for (char c : searchInText.toCharArray()) {
            if (c == charToSearchFor)
                count++;
        }
        return count;
    }
}
