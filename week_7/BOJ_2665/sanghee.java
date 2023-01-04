/*
8
11100110
11010010
10011010
11101100
01000111
00110001
11011000
11000111
 */
public class BOJ_2665 {
    static int n, answer;
    static int[] row = new int[]{1, 0, -1, 0};
    static int[] col = new int[]{-1, 0, 1, 0};

    static int [][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0;i<n;i++) {
            String[] str = br.readLine().split("");
            for(int j =0;j<n;j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        bfs();
        System.out.println(answer);
    }

    public static void bfs() {
        // 이중 배열에서 더 낮은 숫자가 우선순위가 높은 방식(Comparator)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        visited[0][0]= true;

        pq.offer(new int[] {0,0,0}); // 값 추가

        while(!pq.isEmpty()) {
            int [] temp = pq.poll();

            for(int i=0;i<4;i++) {
                int nx = temp[0]+row[i];
                int ny = temp[1]+col[i];

                if(isIn(nx,ny) && !visited[nx][ny]) {
                    visited[nx][ny]= true;
                    if(map[nx][ny]==1) pq.offer(new int[] {nx,ny,temp[2]});
                    else pq.offer(new int[] {nx,ny, temp[2]+1});

                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) return false;
        return true;
    }
}
