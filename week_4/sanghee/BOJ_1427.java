package sort;
import java.io.*;
import java.util.*;
public class BOJ_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        Integer[] arr = new Integer[n];  //int형이 아닌 Integer형으로 선언
        for (int i = 0; i < n; i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));  //배열에 수 저장
        }
        Arrays.sort(arr, Collections.reverseOrder());  //내림차순으로 정렬
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
    }
}