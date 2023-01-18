import java.util.Stack;

public class seeyun_PG_150369 {

    static Stack<Integer> deliveryStack;
    static Stack<Integer> pickupStack;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        deliveryStack = new Stack<>();
        pickupStack = new Stack<>();

//        // add pickups to pickupStack excluding 0 values
//        for (int delivery : deliveries) {
//            if (delivery > 0) {
//                deliveryStack.add(delivery);
//            }
//        }
//
//        // add deliveries to deliveryStack excluding 0 values
//        for (int pickup : pickups) {
//            if (pickup > 0) {
//                pickupStack.add(pickup);
//            }
//        }

        for(int i = 0; i < n; i++) {
            if(deliveries[i] > 0) {
                deliveryStack.add(i);
            }
            if(pickups[i] > 0) {
                pickupStack.add(i);
            }
        }

        while (!deliveryStack.empty() && !pickupStack.empty()) {
            answer += Math.max((deliveryStack.peek() + 1) * 2, (pickupStack.peek() + 1) * 2);

            popUntilDeliveryStackIsEmpty(cap, deliveries);

            popUntilPickupStackIsEmpty(cap, pickups);
        }

        while (!deliveryStack.empty()) {
            answer += (deliveryStack.peek() + 1) * 2;

            popUntilDeliveryStackIsEmpty(cap, deliveries);
        }

        while (!pickupStack.empty()) {
            answer += (pickupStack.peek() + 1) * 2;

            popUntilPickupStackIsEmpty(cap, pickups);
        }

        return answer;
    }

    static void popUntilDeliveryStackIsEmpty(int cap, int[] deliveries) {
        int boxInTruck = 0;
        while (!deliveryStack.empty() && boxInTruck <= cap) {
            if (deliveries[deliveryStack.peek()] + boxInTruck <= cap) {
                boxInTruck += deliveries[deliveryStack.peek()];
            } else {
                deliveries[deliveryStack.peek()] -= (cap - boxInTruck);
                break;
            }
            deliveryStack.pop();
        }
    }
    private void popUntilPickupStackIsEmpty(int cap, int[] pickups) {
        int boxInTruck = 0;
        while (!pickupStack.empty() && boxInTruck <= cap) {
            if (pickups[pickupStack.peek()] + boxInTruck <= cap) {
                boxInTruck += pickups[pickupStack.peek()];
            } else {
                pickups[pickupStack.peek()] -= (cap - boxInTruck);
                break;
            }
            pickupStack.pop();
        }
    }




}

