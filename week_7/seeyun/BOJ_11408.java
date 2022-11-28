package seeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11408 { // 열혈강호 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //  로직: 최대 해결할 수 있는 일의 수 => 업무 당 몇명이 해결가능하냐 => 적은 사람 순으로 정렬
        //  구현: arrayList<HashMap<Integer, List<Integer>>, List<Integer> == 문제당 비용 얼마.

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>(M);

        ArrayList<HashMap<Integer, List<Integer>>> hrList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

//            for (int )

//            int k = Integer.parseInt(st.nextToken());
//            for (int j = 0; j < k; j++) {
//                hrList.add(i, );
//            }
        }

    }
}
