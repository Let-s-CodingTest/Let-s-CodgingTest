package seeyun;

import java.util.Arrays;

public class PG_12982 { // 예산
    static int solution(int[] amounts, int budget) {
        int count = 0;

        Arrays.sort(amounts);

        for (int amount : amounts) {
            if (amount > budget) {
                break;
            }

            budget -= amount;
            count++;
        }

        return count;
    }
    public static void main(String[] args) {
        int[] amounts1 = {1, 3, 2, 5, 4};
        int budget1 = 9;

        int[] amounts2 = {2, 2, 3, 3};
        int budget2 = 10;

        System.out.println(solution(amounts1, budget1));
        System.out.println(solution(amounts2, budget2));

    }
}
