package baekjoon.recursiveFunction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10872 {
    /**
     * 팩토리얼을 구하시오 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
     * 출력
     * 첫째 줄에 N!을 출력한다.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            Integer N = Integer.parseInt(br.readLine());

            int result = factorial(N);

            bw.write(String.valueOf(result));

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static int factorial(int n){
        // 수가 1이 됐을 경우 1 반환 좀료
        if (n <= 1) return 1;
        return n * factorial(n-1);
    }

}
