import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        // 1 부터 빼지만, N 이 빼는 숫자보다 작아지면..? -> 바로 return

        long num = 1;
        int cnt = 0;

        while (true) {
            if (N < num) {
                break;
            }
            N -= num;
            num++;
            cnt++;
        }

        System.out.println(cnt);

    }
}
