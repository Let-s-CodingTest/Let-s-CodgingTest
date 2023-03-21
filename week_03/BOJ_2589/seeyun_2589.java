import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class seeyun_2589 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static char[][] map;
    static boolean[][] visited;
    static int[][] distance;
    static int N;
    static int M;
    static int max = 0;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 지도 입력받기
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    bfs(new Pos(i, j));

                    //
                    for (int k = 0; k < M; k++) {
                        Arrays.fill(visited[k], false);
                        Arrays.fill(distance[k], 0);
                    }
                }
            }
        }

    }

    static void bfs(Pos pos) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(pos);
        visited[pos.x][pos.y] = true;

        while (!queue.isEmpty()) {
            Pos tempPos = queue.poll(); // 여기서 객체가 필요하겠군

            for (int i = 0; i < 4; i++) {
                int x2 = tempPos.x + dx[i];
                int y2 = tempPos.y + dy[i];

                if (isInsideMap(x2, y2) && isNotVisitedLand(x2, y2)) {
                    queue.offer(new Pos(x2, y2));
                    visited[x2][y2] = true;
                    distance[x2][y2] = distance[tempPos.x][tempPos.y] + 1;
                }
            }
        }
    }

    static boolean isInsideMap(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M) {
            return true;
        }

        return false;
    }

    static boolean isNotVisitedLand(int x, int y) {
        if (map[x][y] == 'L' && !visited[x][y]) {
            return true;
        }

        return false;
    }

    static int findMax(int[][] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                Math.max(max, arr[i][j]);
            }
        }

        return max;
    }
}

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}