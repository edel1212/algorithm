package baekjoon.bruteForce;

public class 셀프넘버 {
    public static void main(String[] args) {
        // 문제의 범위가 1 ~ 10000 이기에 + 1을 해줌으로 써 index 숫자를 맞춰 줌
        boolean[] visited = new boolean[10000 + 1];

        for(int i = 1 ; i <= 10000; i++){
            int sum = functionD(i);
            if(sum <= 1_0000) visited[sum] = true;
        } // for

        for (int i = 1; i <= 10000; i++) {
            if(!visited[i]) System.out.println(i);
        } // for

    }

    public static int functionD(int num){
        int result = num;
        while(num > 0){
            result = result + num %10;
            num /= 10;
        } // while
        return result;
    }


}
