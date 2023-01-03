package PG_138476;

import java.util.*;

public class seeyun_PG_138476 {
    public static int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : tangerine) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());

        System.out.println(list.toString());

        Integer cnt = 0;
        for (Integer e : list) {
            k -= e;
            cnt++;

            if (k <= 0) {
                return cnt.intValue();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] testArr1 = {1, 3, 2, 5, 4, 5, 2, 3};
        int[] testArr2 = {1, 3, 2, 5, 4, 5, 2, 3};
        int[] testArr3 = {1, 1, 1, 1, 2, 2, 2, 3};

        int k1 = 6;
        int k2 = 4;
        int k3 = 2;

        seeyun_PG_138476 test = new seeyun_PG_138476();
        System.out.println(test.solution(k1, testArr1));
        System.out.println(test.solution(k2, testArr2));
        System.out.println(test.solution(k3, testArr3));
    }




}
