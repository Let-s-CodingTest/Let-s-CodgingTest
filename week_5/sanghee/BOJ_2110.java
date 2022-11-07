

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2110 {
    public static int[] house;
    public int solution(int n, int m) {
        int answer = 0;
        Arrays.sort(house);
        int lt = 1;
        int rt = house[n - 1] - house[0] + 1;    // 최소 거리가 가질 수 있는 최댓값

        while (lt <= rt) {

            int mid = (lt + rt) / 2;
            if (canInstall(mid) < m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        answer = lt-1;
        return answer;
    }
    // distance에 대해 설치 가능한 공유기 개수를 찾는 메소드
    public static int canInstall(int distance) {

        // 첫 번째 집은 무조건 설치한다고 가정
        int count = 1;
        int lastLocate = house[0];

        for(int i = 1; i < house.length; i++) {
            int locate = house[i];

            if(locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;

    }
    public static void main(String[] args) {
        BOJ_2110 T = new BOJ_2110();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = sc.nextInt();
        }
        System.out.println(T.solution(N,M));
    }
}
