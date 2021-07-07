package Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex {
    public static boolean checkDateTime(String str) {
        String regex = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}