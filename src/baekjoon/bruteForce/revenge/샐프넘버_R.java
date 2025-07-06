package baekjoon.bruteForce.revenge;


public class 샐프넘버_R {
    static boolean[] visited = new boolean[10_001];

    public static void main(String[] args){
        for(int i = 1; i <= 10_000; i++){
            int dNum = d(i);
            if( dNum <= 10000 ) visited[dNum] = true;
        } // for

        for(int i = 1 ; i <= 10_000; i++) if(!visited[i]) System.out.println(i);
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
