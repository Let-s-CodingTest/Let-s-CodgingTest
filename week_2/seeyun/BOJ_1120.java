import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // B의 subString 과 A 를 비교

        String A = st.nextToken();
        String B = st.nextToken();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++) { //
            for (int j = i + A.length(); j <= B.length(); j++) {
                String subB = B.substring(i, j);

                min = Math.min(min, getDiff(A, subB));
            }
        }

        System.out.println(min);



    }

    static int getDiff(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff;
    }
}
