package seeyun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

    static int[][] graph;
    static boolean[] checked;
    static int n;
    static int m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new int[1001][1001];
        checked = new boolean[1001];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

        dfs(start);

        checked = new boolean[1001];
        System.out.println();

        bfs(start);
    }

    public static void dfs(int i) {
        checked[i] = true;
        System.out.print(i + " ");

        for (int j = 1; j <= n; j++) {
            if (graph[i][j] == 1 && checked[j] == false) {
                dfs(j);
            }
        }
    }

    public static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        checked[i] = true;
        System.out.print(i + " ");

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int j = 1; j <= n; j++) {
                if (graph[temp][j] == 1 && checked[j] == false) {
                    queue.offer(j);
                    checked[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}
