// factorial : 런타임에러 (stack overflow)
import java.util.Scanner;

public class Main{
    public int Main(int n){
        if(n == 1) return 1;
        else return n * factorial(n-1);
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(T.factorial(num));
    }
}