public class sanghee {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        while(n>0){
            sb.append(n%k);
            n = n/k;
        }
        sb=sb.reverse();

        String [] primeNumber = sb.toString().split("0");

        for(String i : primeNumber){
            if(!i.equals("") && !i.equals("1") && prime(Long.parseLong(i))){
                answer ++;
            }
        }
        return answer;
    }

    boolean prime(Long n){
        for(int i=2; i<= Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        sanghee T = new sanghee();
        System.out.println(T.solution(437674,3));
    }
}
