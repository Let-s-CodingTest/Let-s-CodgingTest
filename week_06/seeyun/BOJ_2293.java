import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293 {

    static int N;
    static int M;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        dp = new int[M + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            // dp[i] = dp[i - coin] + dp[i]
            for (int j = arr[i]; j <= M; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[M]);

    }

}
