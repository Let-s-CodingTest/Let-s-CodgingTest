package PG_49191;

import java.util.ArrayList;

public class seeyun_PG_49191 { // 순위 검색
    public int[] solution(String[] info, String[] query) {
        ArrayList<Applicant> applicants = new ArrayList<>();

        // info 값을 Applicant 배열에 입력
        for (String s : info) {
            String[] infoData = s.split(" ");
            applicants.add(new Applicant(Languages.valueOf(infoData[0]), Fields.valueOf(infoData[1]), Years.valueOf(infoData[3]), Foods.valueOf(infoData[4])));
        }

        // query 배열 크기만큼 int 정답 배열 생성
        int queryLen = query.length;
        int[] answer = new int[queryLen];

        // query 가 - 이면
        for (String s : query) {
            String[] queryData = s.split(" ");

        }


        return answer;
    }

    static class Applicant {
        Languages language;
        Fields field;
        Years year;
        Foods food;

        Applicant(Languages language, Fields field, Years year, Foods food) {
            this.language = language;
            this.field = field;
            this.year = year;
            this.food = food;
        }
    }

    enum Languages { java, python, cpp }
    enum Fields { backend, frontend}
    enum Years { junior, senior }
    enum Foods { chicken, pizza }

    public static void main(String[] args) {


    }

}
