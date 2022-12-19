package seeyun.string;

import java.util.Scanner;

public class BOJ_5622 { // 다이얼
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String num = in.next();
        int time = 0;
        String[] dial = new String[] {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

        in.close();

        for (int i = 0; i < num.length(); i++) {
            for (int j = 0; j < dial.length; j++ ) {
                if (dial[j].contains(Character.toString(num.charAt(i))))
                    time += j + 3;
            }
        }

        System.out.println(time);
    }
}