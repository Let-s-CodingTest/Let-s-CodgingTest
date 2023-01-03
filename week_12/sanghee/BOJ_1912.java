package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1912 {
    private static int dp(int arr[], int N) {
        int dp[] = new int[N + 1];
        dp[1] = arr[1];

        if (N >= 2) {
            for (int i = 2; i <= N; i++) {
                if (arr[i] < arr[i] + dp[i - 1]) {
                    dp[i] = dp[i - 1] + arr[i];
                } else {
                    dp[i] = arr[i];
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];
        String str[] = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(str[i - 1]);
        }
        br.close();

        int res = dp(arr, N);
        System.out.println(res);
    }
}
