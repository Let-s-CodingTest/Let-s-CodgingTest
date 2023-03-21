package seeyun.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class PG_12941 { // 최솟값 만들기
    static int getMinimum(int[] arr1, int[] arr2) {
        int answer = 0;

        Arrays.sort(arr1);

        arr2 = IntStream.of(arr2)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();


        for (int i = 0; i < arr1.length; i++) {
            answer += arr1[i] * arr2[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 2};
        int[] arr2 = {5, 4, 4};

        System.out.println(getMinimum(arr1, arr2));
    }
}
