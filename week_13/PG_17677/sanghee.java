package week13_study;

import java.util.ArrayList;

// 집합 간의 유사도를 검사
// 교집합 / 합집합
// 다중집합 A = {1, 1, 2, 2, 3}, 다중집합 B = {1, 2, 2, 4, 5}라고 하면, 교집합 , B 사이
// 교집합 A ∩ B = {1, 2, 2}, 합집합 A ∪ B = {1, 1, 2, 2, 3, 4, 5}
// 유사도 3/7
// 다중집합 중 한쪽 집합은 min(1,2) 다른쪽은 max(1,2)

// 대소문자 구분 없고
// 영문자가 아니면 삭제
public class PG_17677 {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        split(str1, arrayList1);
        split(str2, arrayList2);

        if(arrayList1.size() == 0 && (arrayList2.size() == 0)) answer = 65536; // 공집합
        else{
            int sum = arrayList1.size()+arrayList2.size();
            int overlap = 0;
            for (int i = 0; i < arrayList1.size(); i++) {
                for (int j = 0; j < arrayList2.size(); j++) {
                    if(arrayList1.get(i).equals(arrayList2.get(j))){
                        arrayList2.remove(j);
                        sum --;
                        overlap ++;
                        break;
                    }
                }
            }
            if(overlap == 0) answer = 0;
            else {
                System.out.println(sum);
                System.out.println(overlap);
                double similarity = overlap / (double)sum;
                answer = (int) (similarity*65536);
            }
        }

        return answer;
    }
    public static ArrayList split(String str,ArrayList<String> arrayList) {
        for (int i = 0; i < str.length() -1; i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' && str.charAt(i + 1) >='A' && str.charAt(i + 1) <= 'Z') {
                String tmp = "";
                tmp += str.charAt(i);
                tmp += str.charAt(i + 1);
                arrayList.add(tmp);
            }
        }
        return arrayList;
    }
    public static void main(String[] args) {
        PG_17677 T = new PG_17677();
        String str1 = "handshake";
        String str2 = "shake hands";
        System.out.println(T.solution(str1,str2));
    }
}
