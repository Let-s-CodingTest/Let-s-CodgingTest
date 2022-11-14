package DP;

import java.util.Scanner;

public class BOJ_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, n, i, j, cnt;
        T = sc.nextInt();
        int DP[] = new int[T];

        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        System.out.printf("%d", T);

        for(i = 0; i < T; i++) {
            n = sc.nextInt();
            for(j = 4; j <= n; j++) {
                DP[j] = DP[j-1] + DP[j-2] + DP[j-3];
            }
            System.out.printf("%d\n", DP[n]);
        }
    }
}
