package week13_study;

//이 동물원에는 사자들은 가로로도 세로로도 붙어 있게 배치할 수는 없다
//2*N 배열에 사자를 배치하는 경우의 수
//한 마리도 배치하지 않는 경우도 포함

// 경우의 수를 9901로 나눈 나머지를 출력
public class BOJ_1309 {
    public static void main(String[] args) {
        int N = 4;
        int dp[][] = new int[N+1][3];
        int num = 9901;
        int count = 0;
        // x, x (0) x,o (1) o,x (2)
        dp[1][0] =1;
        dp[1][1] =1;
        dp[1][2] =1;

        for (int i = 2; i <= N; i++) {
//            System.out.println(i);
            dp[i][2] = (dp[i-1][0]+dp[i-1][1]) % num;
//            System.out.println(dp[N][2]);
            dp[i][1] = (dp[i-1][0]+dp[i-1][2]) % num ;
            dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2]) % num;
        }


        long ans = (dp[N][0] + dp[N][1] + dp[N][2]) % num;
        System.out.println(ans);
    }
}
