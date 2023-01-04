package study;
//입장권에 5번이 쓰여 있으면 5번 좌석에 앉아야 한다.
// 단, 자기의 바로 왼쪽 좌석 또는 바로 오른쪽 좌석으로는 자리를 옮길 수 있다
// “VIP 회원”들이 있다. 이 사람들은 반드시 자기 좌석에만 앉아야 하며 옆 좌석으로 자리를 옮길 수 없다.
//  VIP 회원들의 좌석 번호들이 주어졌을 때, 사람들이 좌석에 앉는 서로 다른 방법의 가짓수를 구하는 프로그램을 작성하시오.

// logic
// 1개 좌석 -> (1),
// 2개 좌석 -> (1,2)(2,1)
// 3개 좌석 -> (1,2,3)(1,3,2)(2,1,3),
// 4개 좌석 -> (1,2,3,4)(2,1,3,4)(1,2,4,3)(1,3,2,4)(2,1,4,3)
// VIP석 사이의 좌석 개수를 피보나치 수열로 구한 뒤 각 값을 곱한다

import java.util.Scanner;

public class BOJ_2302 {

    static int [] seat;
    static final int max = 41;

    public static void fibo(int num){
        seat = new int[max];
        seat[0] = 1;
        seat[1] = 1;
        if(num>1) {
            for (int i = 2; i <= num; i++) {
                seat[i] = seat[i - 1] + seat[i - 2];
            }
        }
    }

    public static void main(String[] args) {
        BOJ_2302 T = new BOJ_2302();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 좌석 개수
        int M = sc.nextInt(); // 고정석 개수
        int[] vip = new int[M]; // 고정석의 위치

        for (int i = 0; i < vip.length; i++) {
            vip[i] = sc.nextInt();
        }

        fibo(N - M);

        int answer = 1;
        int currentIdx = 0;
        for (int i = 0; i < vip.length; i++) {
            answer *= seat[vip[i] - currentIdx - 1];
            currentIdx = vip[i];
        }
        answer *= seat[N-currentIdx];
        System.out.println(answer);
    }
}
