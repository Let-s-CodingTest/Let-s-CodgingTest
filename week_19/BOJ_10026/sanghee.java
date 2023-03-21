package boj;
// 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다.
// 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다.
// 색약인 사람의 경우 : 색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다
// 적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_10026 {
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static public final int[] dy4 = new int[]{1, 0, -1, 0};
    static public final int[] dx4 = new int[]{0, 1, 0, -1};

    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N]; // R || G || B

        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            for (int j = 0; j < N; ++j) {
                map[i][j] = line.charAt(j);
            }
        }

        BFSNormal bfsNormal = new BFSNormal();
        BFSSameRedGreen bfsSameRedGreen = new BFSSameRedGreen();
        bfsNormal.setSameColor(bfsNormal);
        bfsSameRedGreen.setSameColor(bfsSameRedGreen);

        int rNormal = bfsNormal.countAreas();
        int rSRG = bfsSameRedGreen.countAreas();
        bw.write(Integer.toString(rNormal));
        bw.write(' ');
        bw.write(Integer.toString(rSRG));

        bw.flush();
        bw.close();
    }
    interface sameColor {
        boolean isSameColor(int y, int x, char color);
    }
    // 색약 o
    static class BFSSameRedGreen extends BFS implements sameColor {
        @Override
        public boolean isSameColor(int y, int x, char color) {
            char destinationColor = map[y][x];
            if(('R'==color)||('G'==color)) {
                return ((destinationColor=='R')||('G'==destinationColor)); // 구역확인
            }
            return destinationColor == color;
        }
    }
    // 색약 x
    static class BFSNormal extends BFS implements sameColor {
        @Override
        public boolean isSameColor(int y, int x, char color) {
            return (map[y][x] == color);
        }
    }

    static class BFS {
        sameColor mSameColor;

        public void setSameColor(sameColor implSameColor) {
            mSameColor = implSameColor;
        }
        int countAreas() {
            int r = 0;
            boolean[][] visited = new boolean[N][N];

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if(!visited[i][j]) {
                        ++r;// 구역 ++
                        searchBFS(i, j, visited);
                    }
                }
            }
            return r;
        }
        void searchBFS(int beginY, int beginX, boolean[][]visited) {
            Deque<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{beginY, beginX});
            visited[beginY][beginX] = true; // 방문 표시

            while(queue.size() > 0) {
                int[] item = queue.pop();
                int sy = item[0];
                int sx = item[1];
                char color = map[sy][sx];

                for (int i = 0; i < dx4.length; ++i) {
                    int dy = sy + dy4[i];
                    int dx = sx + dx4[i];

                    if(isIn(dy, dx) && (!visited[dy][dx])) {
                        if(mSameColor.isSameColor(dy, dx, color)) {
                            queue.add(new int[] {dy, dx});
                            visited[dy][dx] = true;
                        }
                    }

                }
            }
        }
        boolean isIn(int y, int x) {
            return ((0<=x) && (x<N) && (0<=y) && (y<N));
        }
    }
}
