import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_1339 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        String[] words=new String[N];
        int[] alphabet=new int[26];
        for(int i=0; i<N; i++) {
            words[i] = sc.next();
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<words[i].length(); j++){
                alphabet[(int)words[i].charAt(j)-65]+=Math.pow(10, words[i].length()-j-1);
            }
        }
        Arrays.sort(alphabet);
        //System.out.println(Arrays.toString(alphabet));
        int sum=0;
        int num=9;
        for(int i=alphabet.length-1; i>=0; i--){
            if(alphabet[i]==0){
                break;
            }
            sum+=alphabet[i]*num;
            num-=1;
        }
        System.out.println(sum);
    }
}
