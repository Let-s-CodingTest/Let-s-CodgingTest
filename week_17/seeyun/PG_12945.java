class Solution {
    public int solution(int n) { // 피보나치 수
        int[] fib = new int[n + 1];

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < fib.length; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1234567;
        }
        return fib[n];
    }
}