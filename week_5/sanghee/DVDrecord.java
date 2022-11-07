

import java.util.Arrays;
import java.util.Scanner;

/* 문제
1. 라이브 공연을 DVD에 녹화 하는데, 라이브의 공연 순서가 뒤바뀌면 안된다
2. 1번과 5번 노래를 녹음하고 싶다면 1~5 사이 모든 노래도 순서대로 녹화해야한다.
3. 녹화길이를 최소한 줄이려고 한다. -> DVD의 최소용량 크기 리턴
4. M개의 DVD는 모두 같은 크기여야 한다. 최소 용량에 맞춰 동일하게 제작 하는 것 같음.
5. M개의 DVD에 N개의 노래를 모두 녹음하려 한다.
6. 노래의 총 시간은 10,000분을 넘지 않는다.
 */
/* 설계
예시 1,2,3,4,5,6,7,8,9 / M = 3
1. (1,2,3,4,5) = 15 / (6,7) = 13 / (8,9) = 17
(1,2,3,4,5,6) = 21 / (7,8) = 15 / (9) = 9
2. 곡들 사이의 순서를 변경할 수 없으니, 이상태에서 나누었을때 가능한 최소용량은 17이다
3. 이걸 어떻게 이분 탐색으로 알고리즘을 만들까? -> 문제에서 요구하는 답이 lt와 rt 사이에 있다고 확신하는 경우만 사용한다.
 */

public class DVDrecord {
    private int count(int[]arr,int catacity){ // capacity는 1장의 DVD 수용 용량 -> 몇장 필요할 지를 return
        int cnt = 1,sum=0; // DVD 장수, 곡들의 합
        for(int x : arr){
            if(sum+x > catacity){
                cnt++;
                sum=x; // x부터 다음 DVD에 저장할거니까 x로 초기화
            }else sum+=x;
        }
        return cnt;
    }
    private int solution(int n, int m, int[] arr) {
//        Arrays.toString(arr); 곡의 순서가 바뀌면 안되니 정렬하면 안될거같다.
        int answer = 0, sum=0;
        for(int i = 0; i<n; i++) sum += arr[i]; // 비효율 적이므로 stream 클래스를 사용했다.
        int lt = Arrays.stream(arr).max().getAsInt(); //google에서 stream클래스 메소드를 찾아보기! -> // max()를 int로 바꿔줘야함
        int rt = Arrays.stream(arr).sum(); // sum은 기본형 int형으로 반환

        while(lt <= rt){
            int mid = (lt + rt)/2;
            if(count(arr, mid)<=m) { // DVD 개수와 작거나 같으면
                answer = mid;
                rt = mid - 1;
            }else lt = mid+1;
        }
        return answer;
    }
    public static void main(String[] args) {
        DVDrecord T = new DVDrecord();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 부른 노래의 개수
        int M = sc.nextInt(); // DVD 레코드의 개수
        int []arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(N,M,arr));
    }
}
