package week12;
// 조건에 해당하는 사람들의 숫자를 순서대로 배열에 담아 return
// 개발언어 and 직군 and 경력 and 소울푸드
// '-' 표시도 존재

import java.util.ArrayList;

public class PG_kakao {
    public int[] solution(String[] info, String[] query) {
        ArrayList<Integer> arr = new ArrayList<>();
        int flag = 0;
        int cnt = 0;
        for (int i = 0; i < query.length; i++) {
            cnt = 0;
            String[] qArr = query[i].split(" and | ");
            for (int j = 0; j < info.length; j++) {
                flag = 1;
                String[] infArr = info[j].split(" ");
                for (int k = 0; k < qArr.length - 1; k++) {
                    if (qArr[k].equals("-") || qArr[k].equals(infArr[k])) continue;
                    else {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    if (Integer.parseInt(qArr[4]) <= Integer.parseInt(infArr[4]))
                        cnt++;
                }
            }
            arr.add(cnt);
        }
        int[] answer = arr.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        PG_kakao T = new PG_kakao();
        String[] info = {
                "java backend junior pizza 150"
                ,"python frontend senior chicken 210"
                ,"python frontend senior chicken 150"
                ,"cpp backend senior pizza 260"
                ,"java backend junior chicken 80"
                ,"python backend senior chicken 50"};

        String[] query = { // 조건
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };
        T.solution(info, query);
        for(int x: T.solution(info, query)) {
            System.out.println(x);
        }

    }
}
