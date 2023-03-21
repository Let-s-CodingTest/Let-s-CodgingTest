package BOJ_1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class seeyun_BOJ_1904 {

    static int[] dp = new int[1000001]; //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

//        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = -1;
        }

        System.out.println(recur(N));
    }

    static int recur(int N) {
        if (dp[N] == -1) {
            dp[N] = (recur(N - 1) + recur(N - 2)) % 15746;
        }

        return dp[N];
    }
}
