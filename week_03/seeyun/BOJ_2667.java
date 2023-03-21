import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667 {
    public static int N;
    public static int[][] matrix;
    public static boolean[][] visit;
    public static ArrayList<Integer> counter;
    public static int count;
    public static int[] X_move = {1, -1, 0, 0};
    public static int[] Y_move = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix =  new int[N][N];
        visit = new boolean[N][N];
        counter = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < N; j++){
                matrix[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(matrix[i][j] == 1 && !visit[i][j]){
                    count = 1;
                    recur(i, j);
                    counter.add(count);
                }
            }
        }
        Collections.sort(counter);
        System.out.println(counter.size());
        for(int num:counter) System.out.println(num);
    }

    public static void recur(int x, int y){
        visit[x][y] = true;
        for(int i = 0; i < 4; i++){
            int x_new = x + X_move[i];
            int y_new = y + Y_move[i];
            if(x_new >= 0 && y_new >= 0 && x_new < N && y_new < N){
                if(matrix[x_new][y_new] == 1 && !visit[x_new][y_new]){

                    recur(x_new, y_new);
                    count++;
                }
            }
        }
    }
}
