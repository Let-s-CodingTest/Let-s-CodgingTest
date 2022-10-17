// 숨바꼭질 : 런타임 에러(ArrayIndexOutOfBounds)

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    int answer = 0;
    int[] dis={1, -1, 2};
    int[] ch;       // queue에 한번 들어왔는지 확인
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e){
        ch= new int[100000];
        ch[s] = 1;  // 출발 지점
        Q.offer(s);
        int L=0;    // tree에서 level = 0
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int x=Q.poll(); // queue에서 노드를 꺼낸다
                for(int j = 0; j<3; j++){
                    int nextX=0;
                    if(dis[j]==2 || dis[j]==-2) nextX = x*dis[j];
                    else nextX = x+dis[j];

                    if(nextX==e) return L+1;  // q에 집어넣으려는 그 값이 14라면? nextX -> level : x+1
                    if(nextX>=0 && nextX<=100000 && ch[nextX]==0){  // 자식 노드의 범위, queue에 들어간 적 없는 수
                        ch[nextX]=1;
                        Q.offer(nextX);
                    }
                }
            }
            L++;    // Level up
        }
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.BFS(s, e));
    }
}
