package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;


public class BOJ_1915 {
    public int maxSquareArea(int[][] array) {
        int maxSize = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {

                if(array[i][j] != 0){
                    // 가로,세로길이가 동일해야한다.
                    // 인접한 배열의값이 1 이상이어야 한다. -> 아니라면 유지
                    // 모두 1이라면
                    int minSize = min(array[i-1][j], array[i][j-1]);
                    array[i][j] = min(minSize, array[i-1][j-1])+1;
                    maxSize = Math.max(maxSize, array[i][j]);
                }
            }
        }

        int area = maxSize * maxSize;
        return area;
    }
    public static void main(String[] args) throws IOException {
        BOJ_1915 T = new BOJ_1915();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int array[][] = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= n ; j++) {
                array[i][j] = tmp.charAt(j-1) - '0';
            }
        }
        System.out.println(T.maxSquareArea(array));

    }
}
