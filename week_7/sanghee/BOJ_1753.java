package Dijkstra;
//첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
// 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다.
// 둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다.
// 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
// 이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다.
// 선형탐색을 하면 n*n -> o(n^2)
// 가장 큰 값을 출력 -> 시간복잡도 단축 priorityQueue
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class BOJ_1753 {
    static ArrayList<Node>[] list;
    private static int V;
    private static int E;
    private static int[] distance;
    private static int start;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        start = sc.nextInt();
        list = new ArrayList[V + 1];
        distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(distance, INF);
        distance[start] = 0;
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(); // 출발
            int v = sc.nextInt(); // 도착
            int w = sc.nextInt(); // 가중
            list[u].add(new Node(v, w));
        }
        dijkstra();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) { // Q가 비어있지 않다면 계속해서 하나씩 꺼내도록.
            Node node = queue.poll();
            if (distance[node.vertex] < node.edge) {
                continue;
            }
            for (int i = 0; i < list[node.vertex].size(); i++) {
                Node node2 = list[node.vertex].get(i);
                int vertex2 = node2.vertex;
                int edge2 = node2.edge + node.edge;
                if (distance[vertex2] > edge2) {
                    distance[vertex2] = edge2;
                    queue.add(new Node(vertex2, edge2));
                }
            }
        }

    }

    public static class Node implements Comparable<Node> {
        int vertex;
        int edge;

        public Node(int vertex, int edge) {
            this.vertex = vertex;
            this.edge = edge;
        }

        @Override
        public int compareTo(Node o) {
            return edge - o.edge;
        }
    }
}
