class Solution { // 타겟 넘버
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target, 0);
    }
    static int dfs(int[] numbers, int idx, int target, int value) {
        if (idx == numbers.length) {
            return value == target ? 1 : 0;
        }

        return dfs(numbers, idx + 1, target, value + numbers[idx]) +
                dfs(numbers, idx + 1, target, value - numbers[idx]);
    }
}