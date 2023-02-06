import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_20191 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String str = sc.nextLine();

        ArrayList<Integer>[] positionList = new ArrayList[26];
        for(int i = 0 ; i < str.length() ; i ++) {
            char c = str.charAt(i);
            int charToInt = c - 'a';

            if(positionList[charToInt] == null) {
                positionList[charToInt] = new ArrayList<>();
            }
            positionList[charToInt].add(i);
        }

        int index = -1;     // 현재 str에서의 위치
        int ans = 1;
        for(int i = 0 ; i < target.length() ; i ++) {
            char c = target.charAt(i);
            int charToInt = c - 'a';

            if(positionList[charToInt] == null) {
                ans = -1;
                break;
            } else {
                if(positionList[charToInt].get(positionList[charToInt].size() - 1 ) <= index) {
                    ans ++;
                    index = positionList[charToInt].get(0);
                } else {
                    index = search(index, 0, positionList[charToInt].size() - 1, positionList[charToInt]);
                }
            }
        }
        System.out.println(ans);
    }

    //index보다 크면서 가장 작은 값
    static int search(int index, int left, int right, ArrayList<Integer> list) {
        while(left < right) {
            int mid = (left + right) / 2 + 1;

            if(list.get(mid) > index && list.get(mid - 1) <= index ) {
                return list.get(mid);
            } else if(list.get(mid) > index && list.get(mid - 1) >= index) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}