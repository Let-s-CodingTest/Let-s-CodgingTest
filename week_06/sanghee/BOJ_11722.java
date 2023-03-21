package DP;
import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;
// 최대 증가 부분 수열(LIS)
public class BOJ_11722 {
    public static int [] dp;
    public int solution(int n,int[] map){
        //각 원소당 가장 긴 감소 부분 수열
        //map[j] > map[i]
        int result = 0;
        for (int i=1; i<=n; i++) {
            dp[i] = 1;
            for (int j=1; j<i; j++) {
                if (map[j] > map[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        BOJ_11722 T = new BOJ_11722();

        int[] map = new int[n + 1];
        dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(n,map));
    }
}