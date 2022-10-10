import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] timetables=new int[n][2];
        for(int i=0; i<n; i++){
            timetables[i][0]=sc.nextInt();
            timetables[i][1]=sc.nextInt();
        }

        Arrays.sort(timetables, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1]==o2[1]){ //종료시간이 같을 경우 시작 시간이 빠른 순
                    return o1[0]-o2[0];
                }else{
                    return o1[1]-o2[1];
                }
            }
        });
        int ans=1;
        int end_time=timetables[0][1];
        for(int i=1; i<n; i++){
            if(end_time<=timetables[i][0]){
                end_time=timetables[i][1];
                ans+=1;
            }
        }
        System.out.println(ans);
    }
}
