import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder d = new StringBuilder();
        int max = 0;
        int idx = 0;
        for(int i=0; i<number.length()-k; i++) {            // 전체 개수 : number의 개수
            for (int j = idx; j <= k+i; j++) {              // index부터 number의 전체 길이까지 반복
                if (max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            d.append(max);
        }
        answer += d;
        return answer;
    }
}
public class sanghee_42883 {
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int k = sc.nextInt();

        System.out.println(s.solution(num, k));
    }
}

