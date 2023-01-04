package DP;

import java.util.stream.IntStream;

public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) triangle[i][j] += triangle[i - 1][j];
                else if (j == triangle[i].length - 1) triangle[i][j] += triangle[i - 1][j - 1];
                else triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }
        int len = triangle.length - 1;
        answer = IntStream.of(triangle[len]).max().orElse(0);

        return answer;
    }
    public static void main(String[] args) {
        IntegerTriangle T = new IntegerTriangle();
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        System.out.println(T.solution(triangle));
    }
}
