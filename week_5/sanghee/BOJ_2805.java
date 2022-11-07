package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2805 {
    public int solution(int m, int[] arr){
        int answer = 0;
        Arrays.sort(arr); // 10, 15, 17, 20
        int lt = 0, rt = Arrays.stream(arr).max().getAsInt(); // rt = 나무 중 가장 큰 것 기준
        int idx = 1;
        // 이분 탐색
        while(lt <= rt){
            int mid = (lt + rt) /2;
            int sum = 0;
            for(int tree : arr){
                if(tree - mid > 0){ // 0 이상일 경우
                    sum += (tree-mid); // 나무 토막 길이 추가
                }
            }

            if(sum < m){ // 필요한 나무 토막보다 합이 작을 경우
                rt = mid - 1;
            } else { // 클 경우
                lt = mid + 1;
            }
        }
        answer = lt - 1;
        return answer;
    }
    public static void main(String[] args) {
        BOJ_2805 T = new BOJ_2805();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
//        int[] arr = new int[] {4, 42, 40, 26, 46};
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(M,arr));
    }
}
