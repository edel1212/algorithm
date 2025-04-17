package baekjoon.recursiveFunction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q27433 {
    /***
     * 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
     *
     * 입력
     * 0
     *
     * 출력 1
     *
     */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int N = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(factorial(N)));
            bw.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // ℹ️ 해당 문제의 포인트는 N의 범위가 20까지라는 것이다.
    //     일반 Integer를 사용할 경우 범위를 초과하기에 오답이 나옴
    public static Long factorial(int n){
        if(n <= 1) return 1L;
        return n * factorial(n-1);
    }
}
