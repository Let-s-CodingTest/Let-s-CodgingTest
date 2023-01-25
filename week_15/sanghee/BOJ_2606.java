import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(map[i], 0);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        visited[1] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int k = queue.poll();

            for (int i = 1; i < visited.length; i++) {
                if (!visited[i] && map[k][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}