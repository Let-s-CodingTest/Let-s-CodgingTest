package sort;

import java.util.Arrays;
import java.util.Scanner;

/*
1. N개의 정수로 이루어진 수열에서 두 개를 고른다
2. 차이가 M이상 이지만 M과 가장 가까운 수를 구하는 프로그램
 */
public class BOJ_2230 {
    public int solution(int[] arr, int M){
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        int answer = Integer.MAX_VALUE;
        int i=0,j= 0;
        while(i<M) {
            if (arr[i] - arr[j] < M) {
                i++;
                continue;
            }
            if (arr[i] - arr[j] == M) {
                answer = M;
                break;
            }
            answer = Math.min(answer, arr[i] - arr[j]);
            j++;
        }
        return answer;
    }

    public static void main(String[] args) {
        BOJ_2230 T = new BOJ_2230();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr, M));
    }
}
