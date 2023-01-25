import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {

    static int n;
    static int[] p;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = Integer.parseInt(s);
        p = new int[n];
        sum = new int[n];
        s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(p);

        int prev = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + prev + p[i];
            prev = prev + p[i];
        }
        System.out.println(sum);
    }
}