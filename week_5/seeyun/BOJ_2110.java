package seeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 { // 공유기 설치

    static int numOfRouters;
    static int[] housesLocations;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numOfHouses = Integer.parseInt(st.nextToken());
        numOfRouters = Integer.parseInt(st.nextToken());

        housesLocations = new int[numOfHouses];

        for (int i = 0; i < numOfHouses; i++) {
            housesLocations[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(housesLocations);

        int minPossibleDistance = 1; // 공유기 간에 최소 거리가 가질 수 있는 최소값
        int maxPossibleDistance = housesLocations[numOfHouses - 1] - housesLocations[0]; // 공유기 간에 최소거리가 가질 수 있는 최대값

        System.out.println(binarySearch(minPossibleDistance,maxPossibleDistance));


    }

    static int binarySearch(int low, int high) {
        high++; // upperbound 특징
        int mid;

        while(low < high) {
            mid = (low + high) / 2;

            if (calculateNumOfRoutersInstallable(mid) < numOfRouters) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low - 1; // 탐색 끝
    }

    static int calculateNumOfRoutersInstallable(int distance) {
        int count = 1;
        int prevRouterLocation = housesLocations[0];

        for (int i = 1; i < housesLocations.length; i++) {
            int curRouterLocation = housesLocations[i];

            if (curRouterLocation - prevRouterLocation >= distance) {
                count++;
                prevRouterLocation = curRouterLocation;
            }
        }

        return count;
    }

}
