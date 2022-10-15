package minji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_9663 {
    static int n;
    static int ans;
    static List<Integer> boards=new ArrayList<>();

    public static boolean check(int x){
        for(int i=0; i<x; i++){
            if(boards.get(x) == boards.get(i)){
                return false;
            }else if(Math.abs(boards.get(x) - boards.get(i))==x-i){
                return false;
            }
        }
        return true;
    }
    public static void dfs(int x){
        if(x==n){
            ans+=1;
            return;
        }
        for(int i=0; i<n; i++){
            boards.set(x, i);
            if(check(x)==true){
                dfs(x+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0; i<n; i++){
            boards.add(0);
        }
        ans=0;
        dfs(0);
        System.out.println(ans);
    }
}
