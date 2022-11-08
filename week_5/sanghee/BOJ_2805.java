package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

/* 문제
1. 나무 M미터가 필요한데, 목재 절단기에 높이 H를 지정해야한다
2. H미터 위로 올라가 나무를 자른다.
3. H보다 큰 나무는 H 위치 절단하고, 더 작은 나무는 잘리지 않을 것이다
4. 나무 높이의 합 >= M
 */
/* 설계
예시 20 15 10 17로 설정했을 때, 높이H를 15로 설정하면
15 15 10 15가 될 것이고, 상근이는 길이가 5와 2인 나무를 들고갈 것이다.
나무를 필요한 M개에 맞게 잘라 가려고 하므로 M=7이면 높이최댓값 H는=15가 될 것이다.

 */
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
