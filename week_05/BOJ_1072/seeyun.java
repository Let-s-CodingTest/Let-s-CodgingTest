package BOJ_1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class seeyun {

    static int numOfGames;
    static int numOfWins;
    static int winRate;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numOfGames = Integer.parseInt(st.nextToken());
        numOfWins = Integer.parseInt(st.nextToken());


        winRate = calculateWinRate(numOfGames, numOfWins);
        int low = 0;
//            int high = Integer.MAX_VALUE;
        int high = 1000000000;

        System.out.println(binarySearch(0, high));



    }

    static int binarySearch(int low, int high) {
        int mid;
        int answer = -1;

        while(low <= high) {
            mid = (low + high) / 2;

            if (isHigherWinRate(mid)) {
                high = mid - 1;
                answer = mid;
            } else {
                low = mid + 1;
            }
        }

        return answer; // 탐색 끝
    }

    static boolean isHigherWinRate(int num) {
        return winRate < calculateWinRate(numOfGames + num, numOfWins + num);
    }

    static int calculateWinRate(int x, int y) {
        return (int) ((long) y * 100 / x);
    }

}
