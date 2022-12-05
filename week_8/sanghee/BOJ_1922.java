package MinimumSpanningTree;
// boj 1922

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1922 {
    static int N, M;
    static int[] parent;
    static PriorityQueue<Edge> pq;
    static List<Edge> mstPath;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 정점의 개수
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        // Union Find 테이블 초기화
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        // 간선의 개수
        M = Integer.parseInt(br.readLine());
        // 가중치 낮은 간선을 담기 위한 우선순위 큐
        pq = new PriorityQueue<>();
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(from, to, cost));
        }

        mstPath = new ArrayList<>();
        MSTByKruskal(); // 크루스칼 알고리즘
        printAnswer(); // 정답 출력
    }

    private static void MSTByKruskal() {
        for(int i=1; i<=M; i++) {
            Edge edge = pq.poll();
            int a = find(edge.start);
            int b = find(edge.end);

            // 사이클을 형성하는 간선 여부 확인
            if(a == b) continue;
            union(a, b);
            mstPath.add(edge);
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        int costSum = 0; // MST 간선들의 가중치 합
        for (int i=0; i < mstPath.size(); i++) {
            costSum += mstPath.get(i).weight;
        }
        sb.append(costSum);
        System.out.println(sb.toString());
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    public Edge(int s, int e, int w) {
        this.start=s;
        this.end=e;
        this.weight=w;
    }

    @Override
    public int compareTo(Edge n) {
        return this.weight-n.weight; // 오름차순
    }
}