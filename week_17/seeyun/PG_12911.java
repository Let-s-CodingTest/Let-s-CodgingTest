class Solution {
    public int solution(int n) { // 다음 큰 숫자
        int answer = n + 1;
        String nBinary = Integer.toBinaryString(n);

        while(true) {
            String answerBinary = Integer.toBinaryString(answer);
            // 1 갯수가 같다면 exit
            if (countOnes(nBinary) == countOnes(answerBinary)) {
                break;
            }
            answer++;
        }

        return answer;
    }

    static int countOnes(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}