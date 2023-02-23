import java.util.Arrays;

class Solution {
    public int solution(int[] number) { // 삼총사
        int answer = 0;
        /*
         * 조건1: 3 정수를 더해야함
         * 조건2: 정수의 합은 반드시 0이여야 함
         *
         풀이법:
         1) 정렬
         2) 두 합이 0 보다 클 경우 pass -> next 첫번째 숫자
         3) 세 합이 0 보다 클 경우 pass -> next 두번째 숫자
         4) 세 합이 0 과 같을 경우 answer++
         */

        Arrays.sort(number);

        for (int i = 0; i < number.length; i++) {
            if (number[i] > 0) {
                break;
            }
            for (int j = i + 1; j < number.length; j++) {
                int sum = number[i] + number[j];
                if (sum > 0) {
                    break;
                }
                for (int k = j + 1; k < number.length; k++) {
                    if (sum + number[k] > 0) {
                        break;
                    }
                    else if (sum + number[k] == 0) {
                        answer++;
                        // System.out.println(number[i] + " " + number[j] + " " + number[k]);
                    }
                }
            }
        }
        return answer;
    }
}