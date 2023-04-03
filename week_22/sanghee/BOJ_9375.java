import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_9375 {
    static HashMap<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            int n = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            int[] arr = new int[map.size()]; // 1, 2
            Iterator<String> keys = map.keySet().iterator();
            int idx = 0;
            while (keys.hasNext()) {
                arr[idx++] = map.get(keys.next());
            }

            int sum = n;
            if (map.size() == 1) {
                System.out.println(sum);
            } else {
                // 의상 가지수 조합결과
                int tmp = 1;
                for (int j = 0; j < arr.length; j++) {
                    tmp *= arr[j];
                }

                sum += tmp;
                System.out.println(sum);
            }
        }
    }
}