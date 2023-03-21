package study;

import java.util.Arrays;

/*
1. 정수 배열 두 개 A[n] B[m] 주어진다
2. 부 배열 => A[i], A[i+1], …, A[j-1], A[j]  (1<=i<=j<=n)
3. A의 부 배열의 합에 B의 부 배열의 합을 더해서 T가 되는,
모든 부배열의 쌍의 개수 구하기
// 블로그 참고!
 */
public class BOJ_2143 {
    static int T;

    public int solution(int n, int m, int[]nArr, int[]mArr){
        int answer = 0;
        int[] subNArr, subMArr;

        // 배열 A로 만들 수 있는 부배열을 누적합하는 배열
        int size = 0;
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            size += i;
        }
        subNArr = new int[size];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            idx = i;
            while(idx < n){
                sum += nArr[idx++];
                subNArr[idx++] = sum;
            }
        }

        // 배열 B의 부배열을 누적합하는 배열
        size = 0;
        idx = 0;
        for (int i = 1; i <= m; i++) {
            size += i;
        }
        subMArr = new int[size];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            idx = i;
            while(idx < m){
                sum += mArr[idx++];
                subMArr[idx++] = sum;
            }
        }

        //이분탐색
        for (int num : subArrA) {
            int tar = T - num; // 타겟 숫자

            //타겟 숫자의 왼쪽을 찾는다.			
            int left= lower_idx(tar ,subArrB);

            //타겟 숫자의 오른쪽을 찾는다.
            int right = upper_idx(tar ,subArrB);

            //total에 더한다.
            total +=(right - left);
        }
        System.out.println(total);
    }

    private static int lower_idx(int target, int[] arr) {
        int st = 0;
        int en = arr.length;
        while (st < en) {
            int mid = (st+en)/2;

            if(arr[mid] >= target) {
                en=mid;
            }else {
                st = mid+1;
            }
        }
        return st;
    }
    private static int upper_idx(int target, int[] arr) {
        int st = 0;
        int en = arr.length;

        while (st < en) {
            int mid = (st+en)/2;
            if(arr[mid] > target) {
                en=mid;
            }else {
                st = mid+1;
            }
        }
        return st;

    }
    public static void main(String[] args) {
        T = 5;
        int n = 4;
        int[] nArr = new int[]{1, 3, 1, 2}; //1 3 1 2
        int m = 3;
        int[] mArr = new int[]{1, 3, 2};
    }
}
