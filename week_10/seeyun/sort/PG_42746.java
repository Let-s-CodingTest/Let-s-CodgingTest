package seeyun.sort;

import java.util.*;

public class PG_42746 { // 가장 큰 수
    public String solution(int[] numbers) {;
        List<String> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        int[][] arr = {{0,1}, {1, 2}};


        if (list.get(0).equals("0")) {
            return "0";
        }

        return String.join("",list);
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        PG_42746 sol = new PG_42746();

        System.out.println(sol.solution(numbers));
    }
}
