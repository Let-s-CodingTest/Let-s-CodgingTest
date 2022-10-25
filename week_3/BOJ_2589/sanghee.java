
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2589 {
    static int n, m;
    static int answer = Integer.MIN_VALUE; // 이동거리의 최대값을 넣을예정
    static ArrayList<Dot> list = new ArrayList<>();
    static int[][] arr;
    static boolean [][] visited;
    static int dist[][];
    static Character map [][];
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);

        map = new Character [n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];
        for(int i=0; i<n; i++) {    // 값을 넣음
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j]= str.charAt(j);
                if(map[i][j]=='L') {
                    list.add(new Dot(i,j));
                }
            }
        }
        for(int i = 0; i<list.size(); i++){
            Dot a = list.get(i);
            visited = new boolean[n][m];
            BFS(a);
        }
        System.out.println(answer);
    }

    public static void BFS(Dot dot){   // start, end
        Queue<Dot> q = new LinkedList<>();
        q.add(dot);
        visited[dot.x][dot.y] = true;
        dist = new int[n][m];
        while(!q.isEmpty()){
            Dot a = q.poll();
            for(int i = 0; i<4; i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if(map[nx][ny]=='L' && !visited[nx][ny]) {
                        visited[nx][ny]= true;
                        dist[nx][ny] = dist[a.x][a.y]+1;
                        q.add(new Dot(nx,ny));
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                answer = Math.max(answer, dist[i][j]);
            }
        }
    }
}
class Dot{
    public int x, y;
    Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
}