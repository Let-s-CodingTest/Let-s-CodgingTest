package BFS;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7569 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int[][] arr, dis;
    static int n, m;
    static Queue<dot> Q = new LinkedList<>();

    public static void main(String[] args) {
        BOJ_7569 T = new BOJ_7569();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) Q.offer(new dot(i, j));
            }
        }
        T.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]==0) flag = false;
            }
        }
        if(flag){
            for(int i = 0; i<n; i++){
                for(int j= 0; j<m; j++){
                    answer=Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }
        else System.out.println(-1);
    }
    public void BFS(){
        while(!Q.isEmpty()){
            dot tmp = Q.poll();
            for(int i = 0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx >= 0 && nx<n && ny>= 0 && ny < m && arr[nx][ny]==0){
                    arr[nx][ny]=1;
                    Q.offer(new dot(nx,ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }
}

class dot {
    int x;
    int y;

    dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}