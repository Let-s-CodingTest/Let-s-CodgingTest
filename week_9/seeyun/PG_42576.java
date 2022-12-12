package seeyun;

import java.util.HashMap;

public class PG_42576  {
    public String solution(String[] participants, String[] completions) {
        HashMap<String, Integer> map = new HashMap<>();

        // answer 초기화
        String answer = participants[0];

        // 참가 인원을 map에 담고, 중복된 인원은 value + 1을 해준다
        for (String participant : participants) {
            if (map.containsKey(participant)) {
                int value = map.get(participant);

                map.put(participant, value + 1);
            } else {
                map.put(participant, 1);
            }
        }

        // particiants 와 completions 매칭 체크: completions 요소대로 map.get() 을 하여 해당 value 를 1 씩 뺀다
        for (String completedParticipant : completions) {
            if (map.containsKey(completedParticipant)) {
                int value = map.get(completedParticipant);
                map.put(completedParticipant, value - 1);
            }
        }

        // 만약 value 가 0이 아니라면 key를 반환한다
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }
}