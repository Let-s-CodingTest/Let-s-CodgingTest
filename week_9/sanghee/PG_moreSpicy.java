import java.util.PriorityQueue;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        int answer = 0;
        while(pq.peek() < K){ // priority queue에서 K보다 작은 수가 없을 때까지
            // 모든 음식을 K이상으로 만들 수 없는 경우
            if(pq.size()==1 && pq.poll()<K) {
                return -1;
            }
            int mix = pq.poll() + (pq.poll() * 2);
            pq.add(mix);
            // 섞어야 하는 최소 횟수를 return
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        MoreSpicy T = new MoreSpicy();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        System.out.println(T.solution(scoville, k));
    }
}