import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class seeyun_BOJ_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 길이가 다르다면
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }

                // 길이가 같다면
                // 각 자릿수 더하기
                int o1Sum = 0;
                int o2Sum = 0;
                for (int i = 0; i < o1.length(); i++) {
                    char ch1 = o1.charAt(i);
                    char ch2 = o2.charAt(i);

                    if (Character.isDigit(ch1)) {
                        o1Sum += ch1 - '0';
                    }
                    if (Character.isDigit(ch2)) {
                        o2Sum += ch2 - '0';
                    }
                }

                if (o1Sum != o2Sum) {
                    return o1Sum - o2Sum;
                }

                return o1.compareTo(o2);
            }
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
