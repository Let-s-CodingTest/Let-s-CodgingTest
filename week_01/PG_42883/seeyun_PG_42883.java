import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class seeyun_PG_42883 {
    public static void main(String[] args) {
        String number = "1924";
        int k = number.length();

        System.out.println(solution(number, k));
    }

    static String solution(String number, int k) {
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < number.length(); i++) {
            list.add(number.charAt(i));
        }

        List<Character> sortedList = new ArrayList<>(list.size());

        for (int i = 0; i < list.size(); i++) {
            sortedList.add(list.get(i));
        }

        Collections.sort(sortedList);

        for (int i = 0; i < k; i++) {
            int j = 0;
            while (j < list.size()) {
                if (sortedList.get(i) == list.get(j)) {
                    list.remove(j);
                    break;
                }
                j++;
            }
        }

        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

    }
}

