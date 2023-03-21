package seeyun.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PG_12951 { // JadenCase 문자열 만들기
    static String toJadenCase(String s) {
        // all letter to lowercase
        s = s.toLowerCase();

        Matcher m = Pattern.compile("\\b[a-z]").matcher(s);

        StringBuilder sb = new StringBuilder();
        int last = 0;
        while (m.find()) {
            sb.append(s.substring(last, m.start()));
            String str = m.group(0);
            char ch = Character.toUpperCase(str.charAt(0));
            sb.append(Character.toString(ch) + str.substring(1));
            last = m.end();
        }
        sb.append(s.substring(last));

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3people  unFollowed me";

        System.out.println(toJadenCase(s));
    }
}
