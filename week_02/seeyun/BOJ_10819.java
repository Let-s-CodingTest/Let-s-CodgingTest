import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);

        // 큰수 작은수 큰수 순으로 재배열

        System.out.println(getMaxDiff(arr));

    }

    static int getMaxDiff(int arr[]) {
        int diff = 0;

        for (int i = 1; i < arr.length; i++) {
            diff += Math.abs(arr[i] - arr[i - 1]);
        }

        return diff;
    }
}
