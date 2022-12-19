package seeyun.hash;

import java.util.HashMap;
import java.util.Iterator;

public class PG_42578 { // 위장
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        // key => type, value => count
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // calculate num of cases with "none"
        Iterator<Integer> iterator = map.values().iterator();
        int answer = 1;

        while (iterator.hasNext()) {
            answer *= iterator.next().intValue() + 1;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        PG_42578 sol = new PG_42578();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(sol.solution(clothes));

    }
}
