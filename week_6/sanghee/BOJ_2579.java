package DP;

import java.util.Arrays;
import java.util.Scanner;

/* Q
1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
3. 마지막 도착 계단은 반드시 밟아야 한다.
 */
public class BOJ_2579 {
    static int[] dy;
    public int solution(int n,int[] arr) {
        dy[1] = arr[1];
        dy[2] = arr[2]+arr[1];
        dy[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]);
        for (int i = 4; i <= n; i++) {
            dy[i] = Math.max(dy[i-3]+arr[i] +arr[i-1], dy[i-2]+arr[i]);
//            System.out.println(dy[i]);
        }
        return dy[n];
    }

    public static void main(String[] args) {
        BOJ_2579 T = new BOJ_2579();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int [n+1];
        int[] tmp = new int[n+1];
        for (int i = 1; i < tmp.length; i++) {
            tmp[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(tmp));
        System.out.println(T.solution(n, tmp));
    }
}
