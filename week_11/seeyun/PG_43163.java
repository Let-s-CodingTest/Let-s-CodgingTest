package seeyun;

import java.util.*;
class Word {
    String str;
    int cnt;

    Word(String str, int cnt) {
        this.str = str;
        this.cnt = cnt;
    }
}
public class PG_43163 {

    public int solution(String begin, String target, String[] words) {
        // words 가 target을 포함하는지 체크
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        return bfs(begin, target, words);
    }


    static int bfs(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word temp = queue.poll();

            for (int i = 0; i < words.length; i++) {
                if (isConvertible(temp.str, words[i]) && !visited[i]) {
                    if (words[i].equals(target)) {
                        return temp.cnt + 1;
                    }
                    visited[i] = true;
                    queue.offer(new Word(words[i], temp.cnt + 1));
                }
            }
        }

        return 0;


    }

    static boolean isConvertible(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }

        return cnt == 1;
    }
}
