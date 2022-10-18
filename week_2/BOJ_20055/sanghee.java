import java.util.Scanner;

public class Main {
    static int n, k;    // 컨테이너 칸의 길이, 최소로 운영가능한 내구도 개수
    static int[] belt;  // 벨트 내구도
    static int answer = 1;
    static boolean[] robot;
    public int solution(int n, int k) {
        while (true) {
            // 벨트 회전
            int temp = belt[n * 2];
            for (int i = n * 2; i > 1; i--) {
                belt[i] = belt[i - 1];
            }
            belt[1] = temp;

            // 로봇의 위치 이동
            for (int i = n; i > 1; i--) {
                robot[i] = robot[i - 1];
            }
            robot[1] = false;

            // 로봇 내리기
            if (robot[n]) {
                robot[n] = false;
            }

            // 가장 먼저 벨트에 올라간 로봇부터 이동
            for (int i = n - 1; i > 0; i--) {
                if (robot[i] && !robot[i + 1] && belt[i + 1] >= 1) {
                    belt[i + 1]--;      // 내구도 1 줄고
                    robot[i] = false;   // 원래 로봇의 위치 false
                    robot[i + 1] = true;// 다음 위치 true
                }
            }

            // 로봇 올리기
            if (belt[1] > 0) {
                robot[1] = true;
                belt[1]--;
            }

            if(isPossible()) {
                break;
            }else{
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPossible(){
        int count = 0;  // 내구도 0인 벨트칸을 세는 변수
        for(int i = 1; i< belt.length; i++){
            if(belt[i] == 0) count++;
            if(count>=k) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        belt = new int[n*2 + 1];
        robot = new boolean[n+1];    // 로봇 유무를 넣는 배열 객체 생성

        for(int i = 1; i<belt.length+1; i++){
            belt[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k));
    }
}