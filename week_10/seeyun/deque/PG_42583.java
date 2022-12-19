package seeyun.deque;

import java.util.*;

public class PG_42583 { // 다리를 지나는 트럭
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(bridge_length, 0));
        Deque<Integer> q = new ArrayDeque<>(list);

        int time = 0;
        int totalWeight = 0;
        int totalNum = 0;

        for (int truck_weight : truck_weights) {
            do {
                time++;
                int out = q.pollFirst();
                if (out != 0) {
                    totalNum--;
                    totalWeight -= out;
                }
                // 요소 추가 불가능
                if (!(isUnderWeight(totalWeight, truck_weight, weight) && isUnderNumber(totalNum, bridge_length))) {
                    q.add(0);
                } else {
                    break;
                }
            } while (true);

            q.add(truck_weight);

            totalNum++;
            totalWeight += truck_weight;

        }

        return time + bridge_length; // 막차 통과 시간
    }
    static boolean isUnderWeight(int totalWeight, int truck_weight, int weight) {
        if (totalWeight + truck_weight <= weight) {
            return true;
        }
        return false;
    }

    static boolean isUnderNumber(int totalNum, int bridge_length) {
        if (totalNum < bridge_length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = { 10,10,10,10,10,10,10,10,10,10 };

        PG_42583 sol = new PG_42583();
        System.out.println(sol.solution(bridge_length, weight, truck_weights));
    }
}
