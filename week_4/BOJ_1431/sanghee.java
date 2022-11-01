package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
1길이가 다르면, 짧은 것 우선
2길이가 같으면, 자리수 합이 더 작은 것 우선
3. 1,2가 안되면 사전순으로 비교
 */
public class BOJ_1431 {
    public void solution(String[] serialArr){
        Arrays.sort(serialArr, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    int sumo1 = 0, sumo2 = 0;
                    for(int i=0; i<o1.length(); i++) {
                        if(o1.charAt(i)>='1' && o1.charAt(i)<='9')
                            sumo1 += (o1.charAt(i)-'0');
                        if(o2.charAt(i)>='1' && o2.charAt(i)<='9')
                            sumo2 += (o2.charAt(i)-'0');
                    }
                    if(sumo1==sumo2)
                        return o1.compareTo(o2);
                    return Integer.compare(sumo1, sumo2);
                }

                return Integer.compare(o1.length(), o2.length());
            }
        }); // 1.길이에 따라 정렬 2.숫자에 따라 정렬
//        System.out.println(Arrays.toString(serialArr));


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BOJ_1431 T = new BOJ_1431();
        int num = sc.nextInt();
        String[] serialArr = new String[num];

        for (int i = 0; i < serialArr.length; i++) {
            serialArr[i] = sc.next();
        }
        T.solution(serialArr);

        for(String x : serialArr){
            System.out.println(x);
        }
    }
}
//String[]