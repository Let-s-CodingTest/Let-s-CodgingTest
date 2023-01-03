package BOJ_1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class seeyun_BOJ_1107 {
    static boolean[] brokens;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        int targetLen = target.length();
        int N = Integer.parseInt(br.readLine());

        brokens = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            brokens[Integer.parseInt(st.nextToken())] = true;
        }

        // 100에서 + - 하거나
        // 숫자를 누른 후+ - 카운트
        int answer = Math.abs(Integer.parseInt(target) - 100);


        for (int i = 0; i < 1000001; i++) {
            int cnt = check(i);
            if (cnt != 0) {

            }
            cnt++;
        }

    }

    static int check(int i) {
        return 0;
    }


}
