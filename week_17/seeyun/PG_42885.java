import java.util.*;

class Solution {
    public int solution(int[] people, int limit) { // 구명보트 (효율성 테스트 실패)
        /*
        조건1: 무게 제한 이하로 사람을 태운다
        조건2: 최대 2명까지 태울 수 있다(1차, 2차 구출)
        조건3: 최소한의 구명보트 갯수를 구한다

        풀이법:
        0) boolean[] isSaved 배열 활용
        1) people 배열 정렬
        2) people[n] 이 구출되었는지 확인
        3) 아직 구출되지 않았고, limit - people[n] 이하인 사람이 있는지 검색
        4-1) 있다면 둘 다 구출 체크 -> continue
        4-2) 없다면 people[n]만 구출 체크
        5) 구명보트++;
        */

        people = Arrays.stream(people)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        boolean[] isSaved = new boolean[people.length];
        int numBoats = 0;
        for (int i = 0; i < people.length; i++) {
            if (isSaved[i]) {
                continue;
            }

            // 구출 확정(1차 구출)
            isSaved[i] = true;
            numBoats++;

            // System.out.println("numBoats = " + numBoats);
            // System.out.println("i = " + i);

            int remainedLimit = limit - people[i];
            for (int j = i + 1; j < people.length; j++) {
                if (isSaved[j]) {
                    continue;
                }

                if (people[j] <= remainedLimit) {
                    // j번째 사람 구출 확정(2차 구출)
                    isSaved[j] = true;
                    // System.out.println("j = " + j);
                    break;
                }
            }

        }
        return numBoats;
    }
}