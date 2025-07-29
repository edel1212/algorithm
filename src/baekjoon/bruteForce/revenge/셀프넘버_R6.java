package baekjoon.bruteForce.revenge;

public class 셀프넘버_R6 {
    public static void main(String[] args) {
        for(int i = 1; i <= 10000; i++){
            int dNum = d(i);
            if(i != dNum) System.out.println(i);
        } // for

        boolean[] visited = new boolean[10_001];
        for(int i = 1 ; i <= 10_000; i++){
            if(!visited[i]) System.out.println(i);
        } //for
    }

    public static int d(int num){
        int sum = num;
        while(0 < num){
            sum += num%10;
            num /= 10;
        } // for
        return sum;
    }
}
