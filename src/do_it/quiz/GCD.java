package do_it.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받은 값
        long n = Long.parseLong(br.readLine());
        long result = n;

        // 제곱근 까지만 진행
        for(long p = 2 ; p <= Math.sqrt(n); p++){
            // p의 값이 소인수인지 확인
            if(n % p == 0){
                // 결과 값 업데이트
                result = result - result / p;

                while(n % p == 0){
                    n /= p;
                } //while

            } // if
        } // for

        // 소인수 구성이 남아 있을 경우
        if(n > 1){
            result = result - result / n;
        } // if

        System.out.println(result);
    }
}
