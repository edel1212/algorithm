package programmers.brute_force;

public class 셀프넘버 {
    // 10,000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 증가하는 순서로 출력 하기 위해 선언
    static boolean[] generated = new boolean[10_001];


    public static void main(String[] args) {
        for(int i = 1; i <= 10_000; i++){
            int sum = sumOfDigits(i);
            if( sum <= 10_000 ) generated[sum] = true;
        } //for

        for (int i = 1; i <= 10000; i++) {
            if (!generated[i]) System.out.println(i);
        }
    }

    public static int sumOfDigits(int n){
        int sum = n;
        while( n > 0 ){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
