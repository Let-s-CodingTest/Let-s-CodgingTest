package BOJ_14621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Edge {
    int start;
    int end;
    int cost;

    Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}
public class seeyun_BOJ_14621 { // BOJ 14621: 나만 안되는 연애 (MST) - Kruskal Algorithm
    static int[] parents;
    static ArrayList<Edge> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] universities = new char[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            universities[i] = st.nextToken().charAt(0);
        }

        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Edge(u, v, d));
        }

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        Collections.sort(list, Comparator.comparingInt(o -> o.cost));

        int count = 0;
        int answer = 0;

        // Kruskal Algorithm
        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);

            if (find(edge.start) != find(edge.end)) { // cycle 이 아니라면
                if (universities[edge.start] != universities[edge.end]) { // 남남 녀녀 가 아니라면
                    count++;
                    answer += edge.cost;

                    union(edge.start, edge.end);
                }
            }
        }

        // 모든 학교를 연결하는 경로가 없을 경우
        if (count != N - 1) { // 간선 갯수 = 노드 갯수 - 1 이여야 함
            answer = -1;
        }
        System.out.println(answer);

    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
        }
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

}
