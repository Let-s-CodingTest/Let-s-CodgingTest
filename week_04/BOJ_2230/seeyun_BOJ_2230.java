import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class seeyun_BOJ_2230 {

    static int[] arr;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        min = Integer.MAX_VALUE;
        // 3 key -> 4
        // 1 3 5

        for (int i = 0; i < N - 1; i++) {
            // binary search for M + arr[i]
            int closestIdx = binarySearch(M + arr[i], i + 1, N - 1);
            int closestAnswer = arr[closestIdx] - arr[i];
//            System.out.println("closestIdx = " + closestIdx);
//            System.out.println("closestAnswer= " + closestAnswer);

            if (closestAnswer >= M) {
                min = Math.min(min, closestAnswer);
            }
        }

        System.out.println(min);

    }

    static int binarySearch(int key, int low, int high) {
        int mid;
        int closestIdx = low;

        while(low <= high) {
            mid = (low + high) / 2;

            if(key == arr[mid]) {
                return mid;
            } else if(key < arr[mid]) {
                high = mid - 1;
                closestIdx = mid;

            } else {
                low = mid + 1;
            }
        }

        return closestIdx; // 탐색 실패
    }
}
