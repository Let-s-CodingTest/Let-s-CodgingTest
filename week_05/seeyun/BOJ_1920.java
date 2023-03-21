package seeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String[] strNumbers = str1.split(" ", N);

        int M = Integer.parseInt(br.readLine());
        String str2 = br.readLine();
        String[] strKeys = str2.split(" ", M);

        // 값을 찾을 숫자배열을 정렬
        Arrays.sort(strNumbers);

        StringBuilder sb = new StringBuilder();

        for (String key : strKeys) {
            int result = Arrays.binarySearch(strNumbers, key);

            if (result < 0) {
                sb.append("0\n" );
            } else if (result >= 0) {
                sb.append("1\n");
            }
        }

        System.out.println(sb.toString());


    }
}
