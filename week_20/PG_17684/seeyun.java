package PG_17684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class seeyun {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static List<Country> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int size = Integer.parseInt(info[0]);
        int min = Integer.parseInt(info[1]);
        int max = Integer.parseInt(info[2]);

        int[][] countries = new int[size][size];
        boolean[][] connected = new boolean[size][size];

        // 배열 입력
        StringTokenizer st;
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                countries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        // 하나라도 연결할 나라가 있다면 반복
        while (true) {
            boolean isConnected = false;

            // 인접한 나라 탐색 (for loop)
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < 4; k++) {
                        int x2 = i + dx[k];
                        int y2 = j + dy[k];

                        // 상하좌우 범위가 유효하지 않다면 건너뛰기
                        if (!(x2 >= 0 && x2 < size && y2 >= 0 && y2 < size)) {
                            continue;
                        }
                        // 이미 연결되었다면 건너뛰기
                        if (connected[x2][y2]) {
                            continue;
                        }

                        // 연합 조건 충족 시, 상호 connected 체크, isConnected 체크
                        int difference = Math.abs(countries[i][j] - countries[x2][y2]);
                        if (difference >= min && difference <= max) {
                            connected[i][j] = true;
                            connected[x2][y2] = true;

                            isConnected = true;
                        }
                    }
                }
            }
        }

    }

//    static int bfs(int x, int y) {
//        Queue<Country> q = new LinkedList<>();
//        list = new ArrayList<>();
//
//        q.offer(new Country(x, y));
//        list.add(new Country(x, y));
//        visited[x][y] = true;
//
//        int sum = board[x][y];
//        while(!q.isEmpty()) {
//            Country current = q.poll();
//
//            for(int i = 0; i < 4; i++) {
//                int nx = current.x + dx[i];
//                int ny = current.y + dy[i];
//                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
//                    int diff = Math.abs(board[current.x][current.y] - board[nx][ny]);
//                    if(l <= diff && diff <= r) {
//                        q.offer(new Node(nx, ny));
//                        list.add(new Node(nx, ny));
//                        sum += board[nx][ny];
//                        visited[nx][ny] = true;
//                    }
//                }
//            }
//        }
//        return sum;
//    }

    static class Country {
        int x;
        int y;

        public Country(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
