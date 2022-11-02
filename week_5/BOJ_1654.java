import java.util.Scanner;

public class BOJ_1654 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();
        int[] lines=new int[n];
        int end=0;
        for(int i=0; i<n; i++){
            lines[i]=sc.nextInt();
            if(end<lines[i]) end=lines[i];
        }
        int start=0;
        int mid=0;
        while(start<=end){
            mid=(start+end)/2;
            int count=0;
            for(int line : lines){
                count+=line/mid;
            }
            if(count>=n){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        System.out.println(end);
    }
}
