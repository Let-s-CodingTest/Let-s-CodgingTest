import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1541 {

    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, "-");

        while (st.hasMoreTokens()) {
            s = st.nextToken();

            int sum = 0;
            StringTokenizer st2 = new StringTokenizer(s, "+");

            while (st2.hasMoreTokens()) {
                sum += Integer.parseInt(st2.nextToken());
            }

            if (result == Integer.MIN_VALUE) { // result가 Integer.MIN_VALUE라면 맨 첫번째 항으로 생각
                result = sum; // 첫째항이므로 그냥 넣어준다.
            }
            else {
                result -= sum;
            }
        }


        System.out.println(result);
    }
}