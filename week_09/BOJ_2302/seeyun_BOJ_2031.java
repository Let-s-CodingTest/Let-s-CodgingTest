package BOJ_2302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class seeyun_BOJ_2031 {
    static Integer[] dp;
    static final int MAX = 41;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        dp = new Integer[MAX];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        int[] vips = new int[M];

        for (int i = 0; i < vips.length; i++) {
            vips[i] = Integer.parseInt(br.readLine());
        }

        int prev = 1;
        int answer = 1;

        for (int vip : vips) {
            answer *= fibonacci(vip - prev);
            prev = vip + 1;
        }

        // 마지막 칸 경우의 수
        answer *= fibonacci(N + 1 - prev);

        System.out.println(answer);
    }

    static Integer fibonacci(int n) {
        if (dp[n] != null) {
            return dp[n];
        }

        return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }

}
