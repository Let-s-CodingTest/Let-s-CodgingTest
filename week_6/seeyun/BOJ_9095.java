import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
    static int N;
    static int M;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[11]; // 주어지는 정수 n은 양수이며 11보다 작다
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            M = Integer.parseInt(br.readLine());

            sb.append(Integer.valueOf(dp[M]) + "\n");
        }


        System.out.print(sb.toString());
    }
}
