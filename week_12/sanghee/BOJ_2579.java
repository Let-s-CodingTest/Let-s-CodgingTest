package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N+1];

        for(int i=1; i<=N; i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[N+1][3];

        dp[1][1] = score[1];
        if(N >= 2) {
            dp[2][1] = score[2];
            dp[2][2] = score[1] + score[2];
        }
        for(int i=3; i <= N; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + score[i];
            dp[i][2] = dp[i-1][1] + score[i];
        }
        System.out.print(Math.max(dp[N][1], dp[N][2]));
    }
}