// 택배 배달 & 빈 상자는 수거

// i번째 집은 물류창고에서 거리 i만큼 떨어져 있습니다.
// 또한 i번째 집은 j번째 집과 거리 j - i만큼 떨어져 있습니다. (1 ≤ i ≤ j ≤ n)

// 트럭에는 재활용 택배 상자를 최대 수용 cap개
// 각 집마다 "배달할" 재활용 택배 상자의 개수, "수거할" 빈 재활용 택배 상자의 개수를 알고 있을 때,
// 트럭 하나로 "모든 배달과 수거를 마치고" 물류창고까지 돌아올 수 있는 최소 이동 거리를 구하려 합니다.

//1 ≤ cap ≤ 50
//1 ≤ n ≤ 100,000

//deliveries의 길이 = pickups의 길이 = n
//deliveries[i]는 i+1번째 집에 배달할 재활용 택배 상자의 개수를 나타냅니다.
//pickups[i]는 i+1번째 집에서 수거할 빈 재활용 택배 상자의 개수를 나타냅니다.

import java.util.Stack;

public class PG_150369 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> deliverStack = new Stack<>();
        Stack<Integer> pickupStack = new Stack<>();
        for(int tmp : deliveries) {
            deliverStack.push(tmp);

        }for(int tmp : pickups) {
            pickupStack.push(tmp);
        }
        while(!deliverStack.empty() && !pickupStack.empty()) {
            answer += Math.max((deliverStack.peek()+1)*2, (pickupStack.peek()+1)*2);

            int box = 0;
            while(!deliverStack.empty() && box <= cap) {
                if(deliveries[deliverStack.peek()]+box <= cap) {
                    box += deliveries[deliverStack.peek()];
                }else {
                    deliveries[deliverStack.peek()] -= (cap-box);
                    break;
                }
                deliverStack.pop();
            }

            box = 0;
            while(!pickupStack.empty() && box <= cap) {
                if(pickups[pickupStack.peek()]+box <= cap) {
                    box += pickups[pickupStack.peek()];
                }else {
                    pickups[pickupStack.peek()] -= (cap-box);
                    break;
                }
                pickupStack.pop();
            }
        }

        while(!deliverStack.empty()) {
            answer += (deliverStack.peek()+1)*2;

            int box = 0;
            while(!deliverStack.empty() && box <= cap) {
                if(deliveries[deliverStack.peek()]+box <= cap) {
                    box += deliveries[deliverStack.peek()];
                }else {
                    deliveries[deliverStack.peek()] -= (cap-box);
                    break;
                }
                deliverStack.pop();
            }
        }

        while(!pickupStack.empty()) {
            answer += (pickupStack.peek()+1)*2;

            int box = 0;
            while(!pickupStack.empty() && box <= cap) {
                if(pickups[pickupStack.peek()]+box <= cap) {
                    box += pickups[pickupStack.peek()];
                }else {
                    pickups[pickupStack.peek()] -= (cap-box);
                    break;
                }
                pickupStack.pop();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PG_150369 T = new PG_150369();
        int cap = 4;
        int n = 5;
        int deliveries[] = {1, 0, 3, 1, 2};
        int pickups[] = {0, 3, 0, 4, 0};
        System.out.println(T.solution(cap, n ,deliveries, pickups));
    }
}
