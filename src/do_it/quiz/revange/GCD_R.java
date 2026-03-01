package do_it.quiz.revange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCD_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받은 자연수 N (범위가 10^12 이므로 long)
        long N = Long.parseLong(br.readLine());

        // 초기 1부터 N까지 모든 수가 후보이므로 N으로 초기화 (1 ≤ k ≤ n)
        long result = N;

        // N의 값이 동적으로 줄어듬으로 제곱근을 변수로 많들지 않고 사용
        for (long k = 2; k * k <= N; k++) {

            // k가 N의 약수(소인수)인지 확인
            if(N % k == 0){

                // 현재 후보(result)에서 K의 배수들을 제거함
                result = (result - result / k);

                // N에서 방금 찾은 소인수(k)의 성분을 뿌리 뽑을 때까지 계속 나눔
                // (예: N이 12이고 k가 2라면, 2로 더 이상 안 나누어질 때까지 나눠서 N을 3으로 만듦)
                while(N % k == 0){
                    N /= k;
                } //while

            } // if

        } // for

        // 상단의 조건을 지나서도 소인수 구성이 남아 있을 경우
        // 자기 자신보다 큰 소수가 있일 경우 해당 값을 처리
        if (N > 1) {
            result = result - (result / N);
        } // if

        // 최종적으로 살아남은 '서로소'들의 개수 출력
        System.out.println(result);

    }
}
