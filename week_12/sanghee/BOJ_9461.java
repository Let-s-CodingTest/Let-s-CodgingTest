package week12;

import java.util.Scanner;

public class BOJ_9461 {
    static int t,n;
    static long dp[]; // 메모이제이션

    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        t=sc.nextInt();
        dp = new long[101];
        dp[1] =1; //초기 3개의 값 저장
        dp[2]=1;
        dp[3] =1;

        for(int i=0;i<t;i++) {
            n = sc.nextInt();
            for(int j=4;j<=n;j++) { //3개를 저장했으므로 4개부터 시작
                dp[j] = dp[j-2] + dp[j-3];
            }
            System.out.println(dp[n]);
        }

    }
}