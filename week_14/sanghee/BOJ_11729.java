import java.io.*;

public class BOJ_11729 {
    public void hanoi(int n, int from, int by, int to) throws IOException {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, from, to, by);
        bw.write(from + " " + to + "\n");
        hanoi(n - 1, by, from, to);
    }

    public static void main(String[] args) throws IOException {
        BOJ_11729 T = new BOJ_11729();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = (int) Math.pow(2, N) - 1;

        System.out.println(count);
        T.hanoi(N, 1, 2, 3);

        bw.flush();
        br.close();
        bw.close();
    }
}