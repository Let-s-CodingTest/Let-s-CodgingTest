import java.io.*;
import java.util.Arrays;

public class seeyun_BOJ_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] grades = new int[N + 1];

        for (int i = 1; i < grades.length; i++) {
            grades[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(grades);

        long sum = 0;

        for (int i = 1; i < grades.length; i++) {
            int degree = grades[i] - i;

            if (degree < 0) {
                degree *= (-1);
            }
            sum += degree;
        }

        System.out.println(sum);
    }
}

