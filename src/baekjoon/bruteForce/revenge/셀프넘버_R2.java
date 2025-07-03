package baekjoon.bruteForce.revenge;

public class 셀프넘버_R2 {
    public static void main(String[] args) {
        // 숫자의 개수 범위가 1 ~ 10000까지 이므로
        boolean[] visited = new boolean[10001];

        for(int i = 1 ; i <= 10_000; i++){
            int num = d(i);
            if( num <= 10_000 )visited[num] = true;
        } // for

        for(int i = 1 ; i <= 10_000; i++){
            if(!visited[i]) System.out.println(i);
        }
    }

    public static int d(int num){
        int sum = num;
        while(num > 0){
            sum += num %10;
            num /= 10;
        } // while
        return sum;
    }
}
