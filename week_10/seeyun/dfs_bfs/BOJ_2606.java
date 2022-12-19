package seeyun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {

    static int[][] graph;
    static boolean[] checked;
    static int n;
    static int m;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        int start = 1;
        count = 0;

        graph = new int[101][101];
        checked = new boolean[101];

        for (int i = 1; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }



    }

    public static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        checked[i] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int j = 1; j <= n; j++) {
                if (graph[temp][j] == 1 && checked[j] == false) {
                    queue.offer(j);
                    count++;
                    checked[j] = true;
                }
            }

        }
       
    }
}
