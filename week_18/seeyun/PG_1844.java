package seeyun;

import java.util.*;

public class PG_1844 { // 게임 맵 최단거리 (bfs)
    // x y 좌표를 담는 칸 객체
    static class Square {
        final int x;
        final int y;

        public Square(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // 상하좌우 (행렬이기에 반대로 입력)
    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        return bfs(maps);
    }
    static int bfs(int[][] maps) {
        // 0, 0에서 시작
        int x = 0;
        int y = 0;

        int width = maps.length;
        int height = maps[0].length;

        Queue<Square> q = new LinkedList<>();
        q.add(new Square(x, y));

        while(!q.isEmpty()) {
            Square curSquare = q.remove();

            for (int i = 0; i < 4; i++) {
                x = curSquare.x + dx[i];
                y = curSquare.y + dy[i];

                // x y 좌표 유효성 체크
                if (x <= -1 || x >=  width || y <= - 1 || y >= height) {
                    continue;
                }
                // 벽 유무 체크
                if (maps[x][y] == 0) {
                    continue;
                }
                // 첫 방문 시에만 최단 거리 기록
                if (maps[x][y] == 1) {
                    maps[x][y] = maps[curSquare.x][curSquare.y] + 1;
                    q.add(new Square(x, y));
                }
            }
        } // while 끝

        int answer = maps[width - 1][height - 1];
        return answer == 1 ? -1 : answer;
    }
}
