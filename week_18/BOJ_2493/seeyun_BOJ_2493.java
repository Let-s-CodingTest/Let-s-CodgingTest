package BOJ_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class seeyun_BOJ_2493 {
    static class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /*
        0) towers array (1부터 시작) + 스택 사용
        1) 자신보다 크거나 같은 타워를 찾을때까지 pop & 비교
        1-2) 찾으면 스택 peek 출력, 스택에 idx 추가
        2) 스택이 isEmpty 면 0 출력, 스택에 idx 추가

         */

        Deque<Tower> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int idx = 1; idx <= N; idx++) {
            int height = Integer.parseInt(st.nextToken());

            while (true) {
                if (dq.isEmpty()) {
                    sb.append("0 ");
                    dq.push(new Tower(idx, height));
                    break;
                }
                else if (!dq.isEmpty()) {
                    Tower prevTower = dq.peek();
                    // 왼쪽으로 송신 가능 (전 타워 >= 현 타워)
                    if (prevTower.height >= height) {
                        sb.append(prevTower.idx + " ");
                        dq.push(new Tower(idx, height));
                        break;
                    }
                    // 왼쪽으로 송신 불가 (전 타워 < 현 타워)
                    else if (prevTower.height < height) {
                        dq.pop();
                    }
                }
            }
        }

        System.out.println(sb.toString());
    }
}
