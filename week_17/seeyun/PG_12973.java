import java.util.*;

class Solution
{
    public int solution(String s) // 짝지어 제거하기 #스택
    {
        Deque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (dq.isEmpty()) {
                dq.add(c);
            }
            else if (!dq.isEmpty()) {
                if (dq.getLast() != c) {
                    dq.add(c);
                }
                else if (dq.getLast() == c) {
                    dq.removeLast();
                }
            }
        }

        return dq.isEmpty() ? 1 : 0;
    }
}