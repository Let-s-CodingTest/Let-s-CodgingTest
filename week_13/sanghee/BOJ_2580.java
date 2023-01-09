package Week13;

import java.util.*;
public class BOJ_2580 {

    static ArrayList<Node> list; //0이 있는 좌표를 저장한다.
    static int[][] board;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        list = new ArrayList<>();
        board = new int[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                board[i][j] = scan.nextInt();
                if(board[i][j] == 0) list.add(new Node(i, j));
            }
        }

        backtracking(0);
    }

    public static void backtracking(int idx) {
        if(idx == list.size()) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        Node node = list.get(idx);
        for(int i = 1; i <= 9; i++) {
            if(check(node.x, node.y, i)) {
                board[node.x][node.y] = i;
                backtracking(idx + 1);
                board[node.x][node.y] = 0;
            }
        }
    }
    public static boolean check (int x, int y, int value) {
        //가로, 세로 검사
        for(int i = 0; i < 9; i++) {
            if(board[x][i] == value) return false;//가로줄에 value와 같은 값이 있다면 false
            if(board[i][y] == value) return false;//세로줄에 value와 같은 값이 있다면 false
        }

        //9칸 검사
        int nx = x / 3 * 3; //9칸의 시작x 좌표를 구함
        int ny = y / 3 * 3; //9칸의 시작y좌표를 구함
        for(int i = nx; i < nx + 3; i++) {
            for(int j = ny; j < ny + 3; j++) {
                if(board[i][j] == value) return false;
            }
        }

        return true;
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
