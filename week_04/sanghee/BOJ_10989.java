package sort;
import java.io.*;
import java.util.*;
public class BOJ_10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  //N 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());  //배열에 수 저장하기
        }
        Arrays.sort(arr);  //배열을 오름차순으로 정렬
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.print(sb);
    }
}
