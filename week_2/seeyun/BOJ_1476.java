import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 편리한 몫 계산을 위해 1이 아닌 0을 기준점으로 잡음
        int E = Integer.parseInt(st.nextToken()) - 1;
        int S = Integer.parseInt(st.nextToken()) - 1;
        int M = Integer.parseInt(st.nextToken()) - 1;

        int E2 = 0; // 0 ~ 14
        int S2 = 0; // 0 ~ 27
        int M2 = 0; // 0 ~ 18

        // 지구년도는 1년 부터 시작
        int cnt = 1;

        while (true) {
            if (E2 == E && S2 == S && M2 == M) {
                break;
            }

            E2 = (E2 + 1) % 15;
            S2 = (S2 + 1) % 28;
            M2 = (M2 + 1) % 19;

            cnt++;
        }

        System.out.println(cnt);


    }
}
