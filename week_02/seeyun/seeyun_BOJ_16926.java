import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class seeyun_BOJ_16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 큰 벨트 회전 -> 가장 작은 벨트까지
        // 첫 벨트: 1) [0, 0] ->  2) [N - 1, 0] -> 3) [N - 1, M - 1] -> 4) [0, M - 1]
        // 두번째 벨트: 1) [++, ++] -> 2) [--, ++] -> 3) [++, --] -> 4) [--, --]


        int x_start = 0;
        int x_end = N - 1;
        int y_start = 0;
        int y_end = M - 1;

        while (true) {
            // 시작 위치가 한 가운데를 지나가면 stop
            if (x_start > N / 2 || y_start > M / 2) {
                break;
            }

            // 실제 돌려야하는 횟수 = R % 전체 둘레 길이
            int cir = 2 * (x_end - x_start) + (y_end - y_start);
            int rep = R % cir;


            for (int i = y_start; i <= y_end; i++) {

//                arr[x_start][i]
            }

            // 다 돌렸다면 다음 벨트로
            x_start++;
            x_end--;
            y_start++;
            y_end--;
        }

    }

    static void swap(int[][] arr, int x1, int y1, int x2, int y2) {
        int temp = 0;

        temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }
}

