// 잃어버린 괄호

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String []str = sc.next().split("-");            // String을 연산기호 - 를 기준으로 분해
        int sum = Integer.MAX_VALUE;            // 최소값 저장

        for(int i=0; i<str.length;i++){
            int tmp = 0;
            String[] calc = str[i].split("\\+");       // 연산기호 + 를 기준으로 분해
            for(int j = 0; j<calc.length; j++) {
                tmp += Integer.parseInt(calc[j]);           // 정수들 모두 결합(+)
            }
            if(sum == Integer.MAX_VALUE) {    // 첫번째 숫자 묶음(초기값 그대로)
                sum = tmp;                    // 더한 값 대입
            }else{
                sum -= tmp;                   //  첫번째 숫자 이후 누적 결합된 숫자묶음들은 빼기(-) 연산
            }
            System.out.println(sum);
        }
    }
}
