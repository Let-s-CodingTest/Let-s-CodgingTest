public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = answer[i].replace('1', '#');
            answer[i] = answer[i].replace('0', ' ');

            // 자릿수 맞추기
            while(answer[i].length() != n)
                answer[i]  = " " + answer[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        PG_secretMap T = new PG_secretMap();
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(T.solution(5,arr1,arr2));
    }
}
