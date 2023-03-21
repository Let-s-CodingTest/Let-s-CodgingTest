// 동전 0

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int coinNum = sc.nextInt();
        int money = sc.nextInt();

        int [] coin = new int[coinNum];
        int count = 0;

        for(int i = 0; i < coin.length; i++){
            coin[i] = sc.nextInt();
        }
        for(int i = coinNum-1; i >= 0 ; i--){    // 가장 큰 화폐 단위부터 나누며 동전의 개수를 구한다
            if(coin[i] <= money){
                count += (money / coin[i]);
                money = (money % coin[i]);
            }
        }
        System.out.println(count);
    }
}
