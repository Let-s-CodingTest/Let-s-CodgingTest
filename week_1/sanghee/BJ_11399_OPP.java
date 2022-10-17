// ATM - 객체지향 프로그래밍

import java.util.*;
class Sort implements Comparable<Sort> {    // Comparable<T>의 구현부
    public int m, s;    //minute, sequence
    Sort(int m, int s){
        this.m = m;
        this.s = s;
    }
    @Override
    public int compareTo(Sort o) {          // Sort 규칙 정의
        // 이용시간(m)를 기준으로 오름차순 정렬
        // 만약 이용시간(m)이 동일한 경우, 순서(s)를 기준으로 비교하고 오름차순 정렬
        if(this.m == o.m) return this.s - o.s;
        else return this.m - o.m;
    }
}
public class Main {
    public int solution(ArrayList<Sort> arr, int num){
        int answer = 0;
        Collections.sort(arr);
        for(int i=0; i<num; i++){       // 입력한 숫자만큼 반복
            for(int j=0; j<=i; j++) {   // i의 ATM 사용 시간 :  i = 0 부터  자기자신까지의 모든 이용자의 사용시간을 누적
                answer += arr.get(j).m; // 사용시간을 모두 결합
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Sort> arr = new ArrayList<>();

        for(int i = 1; i<num+1; i++){
            int m = sc.nextInt();
            arr.add(new Sort(m, i));
        }
        System.out.println(T.solution(arr, num));
    }
}
