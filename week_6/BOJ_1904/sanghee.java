package study;

import java.io.*;


/*
0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다.
현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.
타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다.
우리의 목표는 N이 주어졌을 때 1 or 00타일들로 지원이가 만들 수 있는 모든 가짓수를 세는 것이다.
 */
/*
n = 1 일 때 1
n = 2 일 때 11 00(O) /   100 001(x)
n = 3 일 때 100 001 111
n = 4 일 때 0000 1100 0011 1001 1111
n = 5 일 때 10000 00001 00100 11001 10011 11100 00111 11111
1과 00
 */
public class BOJ_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 2) {
            System.out.println(n);
        } else {
            int[] tiles = new int[n + 1];
            tiles[1] = 1;
            tiles[2] = 2;

            for (int i = 3; i <= n; i++) {
                tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 15746;
            }

            System.out.println(tiles[n]);
        }
    }
}
