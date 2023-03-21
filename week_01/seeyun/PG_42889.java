import java.util.Arrays;
import java.util.HashMap;

public class PG_42889 {
    static int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> map = new HashMap<>();

        // 스테이지 별 인원 구하기 (1 ~ 클리어(N + 1) 까지)
        int[] usersAtStages = new int[N + 2]; // idx 1 부터 사용

        for (int stage : stages) {
            usersAtStages[stage]++;
        }

        // 실패율 = 해당 스테이지 인원 / 해당 스테이지에 있거나 통과한 인원
        int numUser = stages.length;

        for (int i = 0; i < N; i++) {
            double failRate = 0.0;
            if (usersAtStages[i + 1] != 0 && numUser != 0) {
                failRate = (double)usersAtStages[i + 1] / (double)numUser;
            }
            numUser -= usersAtStages[i + 1];

            map.put(i, failRate);
        }



        return new int[0];

    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        System.out.println(Arrays.toString(solution(N, stages)));
    }
}
