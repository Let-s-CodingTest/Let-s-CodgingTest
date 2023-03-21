import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] arr = new String[str.length()];

        long total = 0L;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.substring(i, i + 1);
            total += Character.valueOf(str.charAt(i));
        }

        Arrays.sort(arr, Collections.reverseOrder());

        String answer = "-1";

        // number must contain 0 && all digits must add up to a multiple of 3
        if (arr[arr.length - 1].equals("0") && total % 3 == 0) {
            answer = String.join("", arr);

        }

        System.out.println(answer);


    }
}
