package seeyun.level2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PG_12939 { // 최댓값과 최솟값

    static String findMinAndMax (ArrayList<Integer> list){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : list) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return Integer.toString(min) + " " + Integer.toString(max);
    }

    static ArrayList<Integer> stringToIntegerArrayList(String s) {
        StringTokenizer st = new StringTokenizer(s);
        ArrayList<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        return list;
    }

    public static void main(String[] args) throws IOException {
        // 공백을 기준으로 int 배열에 담는다. (의문: -1 을 그대로 담을 수 있으려나)
        String s = "-1 -2 -3 -4";
        ArrayList<Integer> list = stringToIntegerArrayList(s);

//        for (Integer integer : list) {
//            System.out.println("integer = " + integer);
//        }

        System.out.println(findMinAndMax(list));

    }


}
