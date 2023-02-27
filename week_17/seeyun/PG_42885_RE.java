import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) { // 구명보트 (model answer 참고)
        /*
        solution:
        1) sort people array
        2) use idxMax and idxMin variable
        3) shift them towards middle if under limit
        4) count
        */
        Arrays.sort(people);

        int idxMax = people.length - 1;
        int idxMin = 0;

        int numBoats = 0;
        for (; idxMax >= idxMin; idxMax--) {
            if (people[idxMax] + people[idxMin] <= limit) {
                idxMin++;
            }
            numBoats++;
        }
        return numBoats;
    }
}