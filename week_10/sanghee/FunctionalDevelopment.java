package stack;

import java.util.ArrayList;

public class FunctionalDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) Math.ceil((100F - progresses[i]) / speeds[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        int count = 1;
        int target = days[0];

        for (int i = 1; i < days.length; i++) {
            // 이 작업이 훨씬 오래 걸릴 경우
            if (target < days[i]) {
                target = days[i];
                list.add(count);
                count = 1;
            }
            else count++;
        }
        list.add(count);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }
}
