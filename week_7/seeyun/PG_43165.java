package seeyun;

public class PG_43165 { // 타겟넘버(DFS/BFS)

    static int[] numbers;
    static int target;
    public static void main(String[] args) {
        numbers = new int[]{1, 1, 1, 1, 1};
        target = 3;

        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        return dfs(0, 0);
    }

    static int dfs(int idx, int value) {
        if (idx < numbers.length) {
            return dfs(idx + 1, value + numbers[idx]) + dfs(idx + 1, value - numbers[idx]);
        }
        if (idx == numbers.length) {
            return value == target ? 1 : 0;
        }
        return 0;
    }
}
