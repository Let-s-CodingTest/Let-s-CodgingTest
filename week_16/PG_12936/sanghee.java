package Week16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문제 설명
 */
// 1번부터 n번까지 번호가 매겨져 있습니다
// n명이 사람을 줄을 서는 방법은 여러가지 방법
// (사람 수) n < 20 / (방법의 수 중 k번째 방법을 출력) k < n!
// (전체 경우의 수) n! = 1 * ... * n

/**
 * 입출력 예
 */
// ### n = 3 , k = 5 ###

// 1,2,3 (0)
// 1,3,2 (1)
//-------
// 2.1.3 (2)
// 2.3,1 (3)
//-------
// 3.1.2 (4)
// 3,2,1 (5)

// 총 경우의 개수 : 3!
// 앞 자리 수를 기준으로 블록을 나눴을 때
// 한 블록의 개수 : 3!/3 = 2
// k = 5인데, 인덱스로 표기하기 위해 k-1 = 4로 설정하고 계산
// k의 위치 : (k-1) 4 / (블록의 개수) 2  = 2
/**
-> 2번 인덱스 블록에 위치한다.
-> 첫 번째 값이 3인 것을 확인했고, 남은 1,2 중 k가 어느 위치인지 찾는다. 이를 남은 숫자가 없을때까지 반복한다.
-> int[] arr에 담는다.
*/

// ### n-1 = 2, current k의 위치 : (k)2 % (블록의 개수) 2 = 0 ###

// 1,2 (0)
// -------
// 2,1 (1)

// 총 경우의 개수 : 2!
// 앞 자리 수를 기준으로 블록을 나눴을 때
// 한 블록의 개수 : 2!/2 = 1
// k의 위치 : 0번째
/**
 -> 0번 인덱스에 위치한다.
 -> 두 번째 값은 1로 확인. int[] arr에 담는다.
*/


// ### n-1 = 1, current k의 위치 : (k) 0 % (블록의 개수) 1 = 0

// 2 (0)

// 총 경우의 개수 : 1!
// 한 블록의 개수 1!/1 = 1
// k의 위치 : 0번째

// ### n -1 = 0 ### -> 종료

public class PG_12936 {
    public int[] solution(int n, long k) {
        List<Integer> arr = new ArrayList<>();
        long factorial = 1;
        for (int i = 1; i <= n; i++) { // 팩토리얼 담기
            arr.add(i);
            factorial *= i;
        }

        int[] answer = new int[n];
        int answerIndex = 0;            // k번째 위치의 사람을 담을 배열
        k --;
        while(!arr.isEmpty()){
            long block = factorial/arr.size(); // 한 블럭의 개수 : 총 경우의 개수 n! / n
            int curIndex = (int) (k / block);  // 현재 k의 위치 :  k / 한 블럭의 개수

            factorial /= arr.size();           // 다음 n에 대한 경우의 수
            answer[answerIndex++] = arr.remove(curIndex); // 지금 k번째에 위치한 사람을 answer에 담는다.

            k = k % block;      // 다음 k의 인덱스 위치 준비
        }

        return answer;
    }

    public static void main(String[] args) {
        PG_12936 k = new PG_12936();
        System.out.println(Arrays.toString(k.solution(3, 5)));
    }
}
