package PG_12913;

public class seeyun_PG_12913 { // 땅따먹기 (dp)
    int solution(int[][] land) {
        final int numOfCol = 4;

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < numOfCol; j++) {
                land[i][j] += findMaxExceptIdx(land[i - 1], j);
            }
        }

        int answer = -1;
        for (int i = 0; i < numOfCol; i++) {
            answer = Math.max(land[land.length - 1][i], answer);
        }

        return answer;
    }
    static int findMaxExceptIdx(int[] arr, int idx) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i == idx) {
                continue;
            }
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
