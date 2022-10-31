import java.util.Arrays;
import java.util.Comparator;

public class PRG_42746 { // 가장 큰 수
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        // convert int[] into String[]
        String[] strArr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        // sort in DESC order
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        // return "0" if "0"s exist in a row (since number "00" does not make sense)
        if (strArr[0].equals("0")) {
            return "0";
        }

        // add up the String
        for (String str : strArr) {
            sb.append(str);
        }

        return sb.toString();
    }
}
