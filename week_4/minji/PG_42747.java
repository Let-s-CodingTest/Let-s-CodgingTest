import java.util.Arrays;

public class PG_42747 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n=citations.length;
        for(int i=0; i<n; i++){
            if(citations[i]>=n-i){
                return n-i;
            }
        }
        return answer;
    }
}
