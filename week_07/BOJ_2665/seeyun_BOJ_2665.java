package BOJ_2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class seeyun_BOJ_2665 { // 미로 만들기
    static class Square {
        // 이중 배열의 경우, [y][x] 가 된다
        int y;
        int x;

        Square(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int[][] map;
    static int[][] visited;

    static int[] dy = { -1, 1, 0, 0 }; // 상하좌우 기준
    static int[] dx = { 0, 0, -1, 1 }; // 상하좌우 기준

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new int[N][N];

        // map 과 visited 초기화
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
                visited[i][j] = Integer.MAX_VALUE; // 최소를 구하기 위해 최대값으로 초기화
            }
        }

        bfs(0, 0);

        System.out.println(visited[N - 1][N - 1]);
    }

    static void bfs(int y, int x) {
        Queue<Square> queue = new LinkedList<>();

        queue.add(new Square(y,x));
        visited[0][0] = 0;

        while (!queue.isEmpty()) {
            Square square = queue.poll();

            for (int i = 0; i < 4; i++) {
                int y2 = square.y + dy[i];
                int x2 = square.x + dx[i];

                if (x2 < 0 || y2 < 0 || x2 >= N || y2 >= N) { // 범위 밖이라면
                    continue;
                }

                if (visited[y2][x2] <= visited[square.y][square.x]) { // 전에 더 작은 값이 들어있다면
                    continue;
                }

                if (map[y2][x2] == 1) { // 이동 가능하다면
                    queue.add(new Square(y2, x2));
                    visited[y2][x2] = visited[square.y][square.x];
                } else if (map[y2][x2] == 0) { // 이동이 불가하다면
                    queue.add(new Square(y2, x2));
                    visited[y2][x2] = visited[square.y][square.x] + 1;
                }
            }


        }


    }

}
