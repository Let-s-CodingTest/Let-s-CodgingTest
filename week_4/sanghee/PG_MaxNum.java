
package sort;
import java.util.Arrays;
import java.util.Comparator;

public class MaxNum {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        for(int i = 0; i<numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
        if(str[0].equals("0")) return "0";

        for(String s : str) answer+= s;

        return answer;
    }

    public static void main(String[] args) {
        MaxNum T = new MaxNum();
        int numbers[] = {3, 30, 34, 5, 9};
        int numbers2[] = {6, 10, 2};
        System.out.println(T.solution(numbers));
        System.out.println(T.solution(numbers2));

    }
}
