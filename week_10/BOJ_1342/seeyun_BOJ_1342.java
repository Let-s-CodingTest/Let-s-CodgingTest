package BOJ_1342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class seeyun_BOJ_1342 { // 행운의 문자열 (incomplete)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        HashMap<String, Integer> map = new HashMap();


        // 다음 문자가 같은지 비교
        // 순서를 섞는 로직.. 움..

        //
        //
    }
    static int recursive(HashMap<String, Integer> map, String prev, int cnt) {
        // cnt 가 1 일떄, prev 가 아닌 알파벳 경우의 수 만큼 return

        int sum = map.entrySet().stream()
                    .filter(e -> !e.getKey().equals(prev))
                    .map((Map.Entry::getValue))
                    .reduce(0, Integer::sum);

        return cnt == 1 ? sum : recursive(map, prev, cnt -1);

    }


}
