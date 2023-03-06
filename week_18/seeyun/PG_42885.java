package seeyun;

import java.util.Arrays;

public class PG_42885 {
    public int solution(int[] people, int limit) {
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
