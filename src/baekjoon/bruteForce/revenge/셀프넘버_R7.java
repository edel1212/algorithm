package baekjoon.bruteForce.revenge;

public class 셀프넘버_R7 {
    public static void main(String[] args) {
        boolean[] visited = new boolean[10_001];
        for(int i =  1 ; i <= 10_000; i++){
            int dNum = d(i);
            if( dNum <= 10_000 ) visited[dNum] = true;
        } // for

        for(int i = 1 ; i <= 10_000; i++){
            if(!visited[i]) System.out.println(i);
        } // for
    }

    public static int d(int num){
        int sum = num;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        } // while
        return sum;
    }
}
