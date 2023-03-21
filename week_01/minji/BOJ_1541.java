import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result=0;
        String str = sc.nextLine();
        String[] expressions= str.split("-");
        for(int i=0; i<expressions.length; i++){
            String[] expression=expressions[i].split("\\+");

            if (i == 0) {
                for(int j=0; j<expression.length; j++){
                    result+=Integer.parseInt(expression[j]);
                }
            }else {
                for(int j=0; j<expression.length; j++){
                    result-=Integer.parseInt(expression[j]);
                }
            }

        }
        System.out.println(result);
    }
}
