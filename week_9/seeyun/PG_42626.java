package seeyun;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PG_42626 { // 더 맵게
    static int solution(int[] scoville, int K) {
        int cnt = 0;

        if (scoville.length == 0) {
            return -1;
        }

        PriorityQueue<Integer> que = new PriorityQueue<>();
        Collections.addAll(que, Arrays.stream(scoville).boxed().toArray(Integer[]::new));

        // 두개를 꺼내서 섞고 다시 집어넣기를 반복
        while (que.peek() < K) {
            try {
                int food1 = que.poll();
                int food2 = que.poll();

                que.offer(food1 + (food2 * 2));
                cnt++;
            } catch (Exception e) {
                cnt = -1;
            }

        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }
}
