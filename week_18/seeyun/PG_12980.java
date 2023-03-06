package seeyun;

public class PG_12980 { // 점프와 순간 이동
    public int solution(int n) {
        int answer = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            n--;
            answer++;
        }

        return answer;
    }
}
