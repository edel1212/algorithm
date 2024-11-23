package recursiveFunction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10870 {
    /**
     * - 피보나치 수
     * 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
     * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
     * n=17일때 까지 피보나치 수를 써보면 다음과 같다.
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
     * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
     *
     * 입력
     * 10
     *
     * 출력 55
     *
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            Long n = Long.valueOf(br.readLine());

            bw.write(String.valueOf(fibonacci(n)));

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /***
     *  Ex)
     * fibonacci(0) = 0
     * fibonacci(1) = 1
     * fibonacci(2) = fibonacci(1) + fibonacci(0) = 1 + 0 = 1
     * fibonacci(3) = fibonacci(2) + fibonacci(1) = 1 + 1 = 2
     * fibonacci(4) = fibonacci(3) + fibonacci(2) = 2 + 1 = 3
     */
    public static Long fibonacci(Long n){
        if (n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
