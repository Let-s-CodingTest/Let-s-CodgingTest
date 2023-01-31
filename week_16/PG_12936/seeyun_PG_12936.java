import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> list = new ArrayList<>();
        long factorial = 1;
        int index = 0;

        for(int i=1; i<=n; i++) {
            factorial *= i;
            list.add(i);
        }

        k--;
        while(n > 0) {
            factorial /= n;
            int value = (int) (k / factorial);
            answer[index++] = list.get(value);
            list.remove(value);

            k %= factorial;
            n--;
        }

        return answer;
    }
}