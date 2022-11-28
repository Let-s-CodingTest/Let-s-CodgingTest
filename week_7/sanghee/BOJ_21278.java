package FloydWarshall;
// 건물 X 의 접근성은 X 에서 가장 가까운 호석이 두마리 치킨집까지 왕복하는 최단 시간이다
// 건물의 개수 N과 도로의 개수 M 이 주어진다.
// 이어서 M 개의 줄에 걸쳐서 도로의 정보 Ai , Bi

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_21278 {
    final static int INF = 100000;

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);

        try {
            // 입력 시작
            String nums = br.readLine().trim();
            StringTokenizer stk = new StringTokenizer(nums);

            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            int buildings[][] = new int[n+1][n+1];

            for (int i = 1; i <= m; i++) {
                nums = br.readLine().trim();
                stk = new StringTokenizer(nums);

                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                buildings[a][b] = 1;
                buildings[b][a] = 1;
            }

            // i == j인 경우 제외
            // 값이 0인(노드가 직접적으로 연력되지 않은) 인덱스 값들을 최대 값
            for (int i = 1; i < buildings.length; i++)
                for (int j = 1; j < buildings[i].length; j++)
                    if(i != j && buildings[i][j] == 0)
                        buildings[i][j] = INF;

            // 플로이드 마샬을 실행합니다.
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i < buildings.length; i++) {
                    for (int j = 1; j < buildings.length; j++) {
                        if(buildings[i][j] > buildings[i][k] + buildings[k][j])
                            buildings[i][j] = buildings[i][k] + buildings[k][j];
                    }
                }
            }

            int minSum = INF;
            String result = "";

            // 두 개의 치킨집을 가정하고(i,j) 모든 건물들(k)과의 거리 총합 중 최소 값을
            // "(j,k) + (j,k+1) + j(k+2) ..." 은 모든 건물들과 거리 총합
            for (int i = 1; i < buildings.length; i++) {
                for (int j = i+1; j < buildings.length; j++) {
                    int sum = 0;
                    // 둘 중 최소값을 넣는다.
                    for (int k = 1; k < buildings.length; k++) {
                        sum += Math.min(buildings[i][k],buildings[j][k]);
                    }

                    if(minSum > sum) {
                        minSum = sum;
                        result = i + " " + j + " " + minSum * 2;
                    }
                }
            }
            System.out.println(result);

            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}