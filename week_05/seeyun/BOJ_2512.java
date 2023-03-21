package seeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {

    static int[] budgets;
    static long maxBudget;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        budgets = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;

        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            max = Math.max(budgets[i], max);
        }

        maxBudget = Long.parseLong(br.readLine());

        System.out.println(binarySearch(maxBudget, 0, max));

    }

    static int binarySearch(long goal, int low, int high) {
        high++;
        int mid;

        while(low < high) {
            mid = (low + high) / 2;
//            System.out.println("mid = " + mid);

//            System.out.println("isBudgetCoverable = " + isBudgetCoverable(mid));
            if (!isBudgetCoverable(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low - 1; // 탐색 끝
    }

    static boolean isBudgetCoverable(int upperLimit) {
        long expectedBudget = 0;

        for (int budget : budgets) {
            expectedBudget += Math.min(budget, upperLimit);
        }

        return maxBudget >= expectedBudget;
    }
}
