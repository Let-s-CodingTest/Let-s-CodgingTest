package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// total 20, 50미터에 한 병씩 -> 거리 max = 20 * 50
// 편의점에 들렸을 때, 빈 병은 버리고 새 맥주 병을 살 수 있다 , 박스의 max = 20
// 편의점, 상근이네 집, 페스티벌 의 좌표가 주어진다
// 테스트 케이트 (tc ≤ 50)
// 편의점 수 n (0 ≤ n ≤ 100)
public class BOJ_9205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc =Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int N = Integer.parseInt(br.readLine());
            Node[] location = new Node[N + 2];
            boolean [] check = new boolean[N + 2];
            Queue<Node> q = new LinkedList<>();

            boolean success = false;
            String[] str;

            for (int j = 0; j < N + 2; j++) {
                str = br.readLine().split(" ");
                location[j] = new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            }

            Node start = location[0]; // 시작 위치
            Node end = location[N+1]; // 도착 위치
            q.add(start);
            while(!q.isEmpty()) {
                Node current = q.poll();
                if(current.equals(end)){
                    success = true;
                    break;
                }
                for (int k = 0; k < N+2; k++) {
                    if (check[i] == 0 &&Math.abs(current.x - location[i].x) + Math.abs(current.y - location[i].y) <= 1000) {
                        q.add(location[i]);
                        check[i] = 1;   
                    }
                }
            }
            if(success){
                System.out.println("happy");
            }
            else{
                System.out.println("sad");
            }
        }
    }
}
class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

