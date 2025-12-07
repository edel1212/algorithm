package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 거의_소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 소수는 B의 제곱근까지만 찾으면 된다.
        int maxPrimeLimit = (int) Math.sqrt(B);

        // 소수를 판별한 배열
        boolean[] isPrime = new boolean[maxPrimeLimit + 1];

        // 2부터 maxPrimeLimit까지 true로 초기화
        for (int i = 2; i <= maxPrimeLimit; i++) {
            isPrime[i] = true;
        } // for

        // 소수의 배수들은 합성수로 표시 (지우기)
        for (int i = 2; i * i <= maxPrimeLimit; i++) {
            // 이미 합성수로 지워진 수는 건너뜀
            if (!isPrime[i]) continue;

            // i의 배수들을 지움 (i*i부터 시작하는 최적화)
            for (int j = i * i; j <= maxPrimeLimit; j += i) {
                isPrime[j] = false;
            } // for
        } // for

        // '거의 소수' 개수 카운트
        long count = 0;

        for (int i = 2; i <= maxPrimeLimit; i++) {
            // 합성수는 스킵
            if (!isPrime[i]) continue;

            // 소수 P
            long P = i;
            // 임시 변수 (제곱 값)
            long tempP = P;

            // 제곱 계산
            // 오버플로우 방지를 위해 역산 계산 수학적 동치 ==> ( tempP * p >= B )
            while (tempP <= B / P) {
                // P^N 계산
                tempP *= P;

                // 범위 A <= P^N <= B 조건을 만족하면 카운트
                if (tempP >= A) {
                    count++;
                } // if

            } // while

        } // for

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
