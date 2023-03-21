package seeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654 {
    static int[] ropes;
    static int numOfRopesToMake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        numOfRopesToMake = Integer.parseInt(st.nextToken());

        ropes = new int[N];
        long max = 0;

        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, ropes[i]);
        }

        System.out.println(binarySearch(numOfRopesToMake, 0, max));


    }

    static Long binarySearch(int goal, long low, long high) {
        high++;
        long mid;

        while(low < high) {
            mid = (low + high) / 2;
//            System.out.println("mid = " + mid);
            int numOfRopes = calculateNumOfRopesMade(mid);
//            System.out.println("numOfRopes = " + numOfRopes);

            if (numOfRopes < goal) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low - 1; // 탐색 끝
    }

    static int calculateNumOfRopesMade(Long lengthToCut) {
        int numOfRopesMade = 0;

        for (int rope : ropes) {
            numOfRopesMade += rope / lengthToCut;
        }

        return numOfRopesMade;
    }
}
