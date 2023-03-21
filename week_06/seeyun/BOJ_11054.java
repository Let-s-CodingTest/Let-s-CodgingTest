import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054 { // 가장 긴 바이토닉 부분 수열
    static int[] arr;
    static Integer[] ascDp;
    static Integer[] dscDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ascDp = new Integer[N];
        dscDp = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            ascLIS(i);
            dscLIS(i);
        }

        int max = ascDp[0] + dscDp[0];
        for(int i = 1; i < N; i++) {
            max = Math.max(max, ascDp[i] + dscDp[i]);
        }
        System.out.println(max - 1);


    }


    static int ascLIS(int N) {
        if (ascDp[N] == null) {
            ascDp[N] = 1;

            for (int i = N - 1; i >= 0; i--) {
                if (arr[N] > arr[i]) {
                    ascDp[N] = Math.max(ascDp[N], ascLIS(i) + 1); // 크면 + 1 해야하므로
                }
            }
        }
        return ascDp[N];
    }

    static int dscLIS(int N) {
        if (dscDp[N] == null) {
            dscDp[N] = 1;

            for (int i = N + 1; i < dscDp.length; i++) {
                if (arr[N] > arr[i]) {
                    dscDp[N] = Math.max(dscDp[N], dscLIS(i) + 1);
                }
            }
        }
        return dscDp[N];
    }





}
