// 회의실 배정 - 객체지향 프로그래밍

import java.util.*;
class Time implements Comparable<Time> {   // Comparable<T> 인터페이스의 구현부
    public int s, e;
    Time(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Time o) {  // Time 규칙 정의
        // end time을 기준으로 오름차순 정렬
        // 만약 동일할 경우 start time을 기준으로 비교하고 오름차순 정렬
        if(this.e == o.e) return this.s - o.s;
        else return this.e - o.e;
    }
}
public class Main {
    public int solution(ArrayList<Time> arr,int num){
        int cnt = 0;
        Collections.sort(arr);  // Time의 규칙에 맞게 Collection을 정렬
        int et = 0;
        for(Time ob : arr){
            if(ob.s >= et){
                cnt++;
                et=ob.e;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0; i < num; i++){
            int s = sc.nextInt();
            int t = sc.nextInt();
            arr.add(new Time(s, t));
        }
        System.out.println(T.solution(arr, num));

    }
}
