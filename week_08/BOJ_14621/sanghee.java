package study;
//line 1 > 학교의 수 N와 학교를 연결하는 도로의 개수 M
//line 2 > 학교가 남초 대학교라면 M, 여초 대학교라면 W
// M개의 줄에 u v d가 주어지며 u학교와 v학교가 연결되어 있으며 이 거리는 d
// 모든 정점을 구성하는 최단 거리 길이를 구하자 -> 같은 성별의 대학교만 연결되지 않도록 간선을 처리
// 학교를 연결하는 경로가 없을 경우 -1을 출력한다

import java.io.*;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class sanghee {
    static int[] parent;
    static ArrayList<Dot> schools;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        schools = new ArrayList<>();

        String[] gender = new String[N + 1];
        String checkGender = br.readLine();
        st = new StringTokenizer(checkGender);

        // input
        for (int i = 1; i <= N; i++) {
            gender[i] = st.nextToken();
        }
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (!gender[u].equals(gender[v])) {
                schools.add(new Dot(u, v, d));
            }
        }
        int result = solve(N);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int find(int x) {
        if(parent[x]==x) return x;
        else return parent[x]=find(parent[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b]=a;
    }
    public static int solve(int m) {
        parent = new int[m+1];
        for (int i = 1; i <= m ; i++) {
            parent[i] = i;
        }
        Collections.sort(schools);
        int result = 0;
        int schoolCount = 0;

        for(Dot school : schools){
            Dot schoolNode = school;
            if(find(schoolNode.start) != find(schoolNode.end)) {
                union(schoolNode.start, schoolNode.end);
                result += schoolNode.distance;
                schoolCount++;
            }
        }
        if(schoolCount == m-1) return result;
        else return -1;
}
    static class Dot implements Comparable<Dot> {
        int start;
        int end;
        int distance;

        public Dot( int s, int e, int d){
            this.start = s;
            this.end = e;
            this.distance = d;
        }

        @Override
        public int compareTo (Dot n){ // 거리 기준 오름차순 정렬
            return this.distance - n.distance;
        }
    }
}
