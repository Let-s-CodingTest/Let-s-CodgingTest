// 부분 수열의 합
import java.util.Scanner;

public class Main {
    static int cnt=0, answer=0;
    static int n, s;
    static int[] arr;
    public void DFS(int idx, int sum){
        if(idx==n) {    // 배열의 끝
            if (sum == s) {
                cnt++;
            }
            return ;
        }else{
            DFS(idx+1, sum);
            DFS(idx+1, sum + arr[idx]);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // 수열 개수
        s = sc.nextInt();   // (조건) 더한 값 제시
        arr = new int[n];    // 값 넣을 배열

        for(int i = 0; i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        T.DFS(0, 0);

        if(s == 0) answer = cnt-1;      // 공집합일 경우 제외
        else answer = cnt;
        System.out.println(answer);

    }
}
