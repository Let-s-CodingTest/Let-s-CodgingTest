package MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 합집합
            if (command == 0) {
                union(a, b);
            }
            // 같은 집합인지 확인
            else {
                System.out.println(find(a) != find(b) ? "NO" : "YES");
            }
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        // 작은 수로 합치기
        if (x < y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        // 경로 압축
        return parents[x] = find(parents[x]);
    }

}