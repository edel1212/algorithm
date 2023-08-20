package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2231 {
    /**
     * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
     * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
     * 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다.
     * 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
     *
     * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            // 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. :: 245 - > 256(=245+2+4+5)

            int N = Integer.valueOf(br.read());

            // 216   --> 198 + 18
            // 215   --> 199 +
            // TODO ::  기준을 잡고 loop를 돌면서 가장 가까운 수로 시작하자 기준은  가장 작은 N이기에 0부터 시작하는걸로한다.

            for(int i = 0 ; i < N; i ++ ){

            }

       } catch (Exception ex){
           ex.printStackTrace();
       }
    }
}
