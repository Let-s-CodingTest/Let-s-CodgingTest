import java.util.Arrays;

public class PRG_42747 { // H-Index
    public int solution(int[] citations) {

        Arrays.sort(citations);

        int answer = 0;

        // h번 이상 인용된 논문이 h편 이상인 h의 최댓값을 구해야함
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

}
