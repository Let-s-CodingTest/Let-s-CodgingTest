package BOJ_1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class seeyun_BOJ_1915 { // 가장 큰 정사각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] dp = new int[N][M];
        int max = 0;

        for(int i = 0 ; i < N; i++) {
            char[] line = br.readLine().toCharArray();

            for(int j = 0 ; j < M; j++) {
                arr[i][j] = Character.getNumericValue(line[j]);
                dp[i][j] = arr[i][j];
                if(i >= 1 && j >= 1) {
                    if (dp[i - 1][j] > 0 && dp[i - 1][j - 1] > 0 && dp[i][j - 1] > 0 && dp[i][j] > 0) {
                        int min = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                        dp[i][j] = min + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

}
