package pg;

import java.util.ArrayList;
// 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임
// 조건 1. 같은 블록은 여러 2×2에 포함될 수 있으며, 지워지는 조건에 만족하는 2×2 모양이 여러 개 있다면 한꺼번에 지워진다.
// 조건 2. 블록이 지워진 후에 위에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다.
public class PG_17679 {
    static char table[][];
    static boolean visited[][];
    public int solution(int n, int m, String[] board) {
        int answer = 0;
        int flag = 0;
        table = new char[n][m];
        for(int i=0; i<n; i++){
            table[i] = board[i].toCharArray();
        }
        while(true){
            flag=0;
            visited = new boolean[n][m];
            for(int i=0; i<n-1; i++){
                for(int j=0; j<m-1; j++){
                    flag+=checkMatrix(i, j);
                }
            }
            if(flag==0) break;
            for(int j=0; j <m; j++){
                ArrayList<Character> list = new ArrayList<>();
                for(int i=n-1; i>=0; i--){
                    // false인 것만 동적배열에 넣기
                    if(!visited[i][j]){
                        list.add(table[i][j]);
                    }else
                        answer++;
                }
                // 동적배열에서 꺼내면서 다시 쌓기
                for(int i=n-1, idx=0; i>=0; i--, idx++){
                    if(idx<list.size()){
                        table[i][j] = list.get(idx);
                    }else{
                        table[i][j] = '0';
                    }
                }
            }
        }
        return answer;
    }
    // 2*2 블록인지 체크
    static int checkMatrix(int r, int c){
        char target = table[r][c];
        if(target!='0' && target==table[r+1][c] && target==table[r][c+1] && target==table[r+1][c+1]){
            visited[r][c]=true;
            visited[r+1][c]=true;
            visited[r][c+1]=true;
            visited[r+1][c+1]=true;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        PG_17679 T = new PG_17679();
        int m = 4, n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(T.solution(m,n,board));
    }
}
