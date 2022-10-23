import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {

    static int[][] check;
    static boolean[] checked;
    static int n;
    static int m;
    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        start = 1;

        check = new int[101][101];
        checked = new boolean[101];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            check[x][y] = check[y][x] = 1;
        }



    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        checked[start] = true;
       
    }
}
