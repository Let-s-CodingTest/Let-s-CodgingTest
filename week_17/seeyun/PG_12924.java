class Solution {
    public int solution(int n) { // 숫자의 표현
        int answer = 1;
        for (int i = 1; i <= n; i++) {
            int sum = i;
            for (int j = i + 1; j <= n; j++) {
                if (sum > n) {
                    break;
                }
                else if (sum == n) {
                    answer++;
                    break;
                }
                sum += j;
            }
        }
        return answer;
    }
}