package study;
/*
1. 게임 -> 이길 때도 있지만, 질때도 있었다.
2. 게임을 중단했다가 다시 게임을 시작했다.
3. 지금의 승률은 100%가 되었지만, 이전의 기록이 전체 승률을 깎아먹는다.
4. 게임횟수 x, 이긴게임 y , z= y/x
5. 최소 게임을 몇 번 더해야 z가 변하는지 구하는 프로그램 작성
6. 절대 변하지 않는다면 -1을 출력한다.
1 ≤ X ≤ 1,000,000,000
0 ≤ Y ≤ X
 */
public class BOJ_1072 {
    public long solution(long x, long y){
        long z = 100 * y / x; // 현재 승률
        long lt = 1, rt = x; // 승률을 바꾸기 위해 해야하는 최소,최대 게임 횟수

        if(z == 100){ // ex 47 47
            return -1;
        }
        while(lt < rt){
            long mid = (lt+rt)/2;
            long tmpX = x+mid;
            long tmpY = y+mid;

            long changeZ = 100 * tmpY / tmpX;
            if(changeZ > z){
                rt = mid;
            } else {
                lt = mid+1;
            }
        }
        return rt;
    }
    public static void main(String[] args) {
        BOJ_1072 T = new BOJ_1072();
        long x = 10;
        long y = 8;
        System.out.println(T.solution(x, y));
    }
}
