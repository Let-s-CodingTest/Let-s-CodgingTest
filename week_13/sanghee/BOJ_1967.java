package Week13;

import java.io.BufferedReader;
        import java.io.*;
        import java.util.*;

public class BOJ_1967 {
    static ArrayList<node>[] arrayList;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            arrayList[p].add(new node(c,w));
            arrayList[c].add(new node(p,w));
        }

        String temp[] = searchDiameter(new node(0,0)).split(" ");
        String result[] = searchDiameter(new node(Integer.parseInt(temp[0]),0)).split(" ");
        System.out.print(result[1]);
    }

    static String searchDiameter(node start) {
        Queue<node> q = new LinkedList<>();
        boolean visited[] = new boolean[n];
        int cost[] = new int[n];
        q.offer(start);
        visited[start.n] = true;

        while(!q.isEmpty()) {
            node cur = q.poll();
            for(node i: arrayList[cur.n]) {
                if(!visited[i.n]) {
                    visited[i.n] = true;
                    cost[i.n] += cost[cur.n] + i.w;
                    q.offer(i);
                }
            }
        }
        int maxInd = 0, maxVal = 0;
        for(int i = 0; i < n; i++) {
            if(maxVal < cost[i]) {
                maxVal = cost[i];
                maxInd = i;
            }
        }
        return maxInd+" "+maxVal;
    }
    static class node {
        int n;
        int w;
        node(int n, int w){
            this.n = n;
            this.w = w;
        }
    }
}