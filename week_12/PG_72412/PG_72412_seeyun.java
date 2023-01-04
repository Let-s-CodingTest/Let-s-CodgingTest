package PG_72412;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PG_72412_seeyun {
    static HashMap<String, ArrayList<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        int[] answer = new int[query.length];

        // query -> map
        for (String i : info) {
            String[] strArr = i.split(" ");
            combination("", 0, strArr);
        }

        int idx = 0;
        for (String q : query) {
            String str = q.replace(" and ", "");
            String[] temp = str.split(" ");
//            Collections.sort(m)
        }
        return answer;
    }

    static void combination(String str, int depth, String[] info) {
        // add score at last
        if (depth == 4) {
            int score = Integer.parseInt(info[4]);
            if (map.containsKey(str)) {
                map.get(str).add(score);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(score);
                map.put(str, temp);
            }
            return;
        }
        // NULL("-") cases + NOTNULL cases
        combination(str + "-", depth + 1, info);
        combination(str + info[depth], depth + 1, info);
    }
}
