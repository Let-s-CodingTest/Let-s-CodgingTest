package BOJ_1431;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class minji {
    public static int sumOfNum(String num){
        int sum=0;
        for(int i=0; i<num.length(); i++){
            if(Character.isDigit(num.charAt(i))){
                sum+=Character.getNumericValue(num.charAt(i));
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[] numbers=new String[n];
        for(int i=0; i<n; i++){
            numbers[i]=sc.next();
        }
        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){ //길이가 같으면
                    if(sumOfNum(o1)==sumOfNum(o2)){ //합이 같으면
                        return o1.compareTo(o2); //사전순
                    }else{
                        return Integer.compare(sumOfNum(o1), sumOfNum(o2));
                    }
                }else{
                    return o1.length()-o2.length();
                }
            }
        });
        for(String number : numbers){
            System.out.println(number);
        }
    }
}
