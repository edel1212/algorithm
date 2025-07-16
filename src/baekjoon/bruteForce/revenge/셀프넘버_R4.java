package baekjoon.bruteForce.revenge;

public class 셀프넘버_R4 {
    public static void main(String[] args) {
        boolean[] visited = new boolean[10_001];
        for(int i = 1 ; i <= 10_000 ; i ++){
            int num = d(i);
            if( num <= 10_000 ) visited[num] = true;
        } // for

        for(int i = 1 ; i <= 10_000 ; i ++){
            if(!visited[i]) System.out.println(i);
        }
    }
    public static int d(int num){
        int result = num;
        while( 0 < num ){
            result += num%10;
            num /= 10;
        } // whiles
        return result;
    }
}
