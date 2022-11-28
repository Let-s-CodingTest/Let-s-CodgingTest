package FloydWarshall;
//i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재
import java.util.*;
import java.io.*;

public class BOJ_11403 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        // 초기화
        int[][] arr=new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    // i->k , k->j 가 존재하다면 1로 설정
                    // k = 거쳐가는 노드
                    if(arr[i][k]==1&&arr[k][j]==1) arr[i][j]=1;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
