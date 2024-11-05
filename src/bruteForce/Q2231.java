package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class Q2231 {
    /**
     * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
     * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
     * 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다.
     * 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
     *
     * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
     *
     * Input : 216   // Out Put : 198
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int M = Integer.parseInt(br.readLine());
            int result = 0;
            for(int i =  1; i <= M ; i++){
                String numStr = String.valueOf(i);
                int length = numStr.length();
                int[] digits = new int[length];
                // 받아온 숫자각각의 배열에 저장
                for (int o = 0; o < length; o++) {
                    digits[o] =Character.getNumericValue(numStr.charAt(o));
                }// for
                int arrSum =  Arrays.stream(digits).reduce(Integer::sum).getAsInt();
                int sumArg = i + arrSum;
                if(M == sumArg) {
                    result = i;
                    break;
                }// if
            } // for
            bw.write(String.valueOf(result));
            bw.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

