import java.util.Arrays;
import java.util.Scanner;

public class BOJ_5052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int tc=0; tc<t; tc++){
            int n=sc.nextInt();
            String[] numbers=new String[n];
            for(int k=0; k<n; k++){
                numbers[k]=sc.next();
            }
            Arrays.sort(numbers);
            //System.out.println(Arrays.toString(numbers));
            boolean flag=false;
            for(int i=0; i<n; i++) {
                for(int j=i+1; j<n; j++) {
                    if(numbers[i].length()>numbers[j].length()) break;
                    String splitNum=numbers[j].substring(0, numbers[i].length());
                    //System.out.println(splitNum);
                    if(Integer.parseInt(splitNum) > Integer.parseInt(numbers[i])){
                        break;
                    }
                    if(splitNum.equals(numbers[i])){
                        System.out.println("NO");
                        flag=true;
                        break;
                    }
                }
                if (flag==true) break;
            }
            if(flag==false) System.out.println("YES");
        }
    }
}
