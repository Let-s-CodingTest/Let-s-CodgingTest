import java.util.*;

public class PG_128476 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : tangerine) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        List<Integer> keylist = new ArrayList<>(map.keySet());
        Collections.sort(keylist, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        for (Integer e : keylist) {
            if (k <= 0)
                break;
            answer++;
            k -= map.get(e);
        }
        return answer;
    }

    public static void main(String[] args) {
        PG_128476 T = new PG_128476();
        int k = 6;
        int [] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(T.solution(k, tangerine));
    }
}
