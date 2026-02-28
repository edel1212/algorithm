package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 거의_소수_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        // 시작 값
        long A = Long.parseLong(st.nextToken());
        // 종료 값
        long B = Long.parseLong(st.nextToken());

        // B의 최대 범위가 10^14 이지만 실제로 필요한 값은 제곱 범위 내 이다.
        int limit = (int) Math.sqrt(B);

        // 10^14 의 제곱 값까지가 최대 범위임
        // - A ~ B 범위의 소수를 구하는 문제가 아닌 소수들의 꼴을 구하는 문제이기에 전체를 다 구할 필요가 없다. (메모리도 터짐)
        boolean[] isNotPrime = new boolean[limit + 1];

        // 0 과 1은 소수가 아니기에 제외
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        // 에라토스테네스의 체
        // 2부터 전체 확인 시작
        for(int i = 2; i <= limit; i++){
            if(!isNotPrime[i]){
                // 범위가 크므로 i * i 의 성능을 무시하고 2배 값으로 확인 진행
                // i * i 시 Overflow 문제가 발생할 수도 있음
                for(int j = i + i ; j <= limit ; j += i){
                    isNotPrime[j] = true;
                } // for
            } // if
        } // for

        // 구해진 소수를 통해 제곱꼴을 찾음
        int result = 0;
        for(int i = 2 ; i <= limit ; i++){
            // 소수일 경우
            if(!isNotPrime[i]){
                // 현재의 소수
                long currentPrime = i;

                // B보다 작은 수
                // ✅ 오버플로우 방지 ( 기존 : currentPrime * i <= B )
                // - currentPrime 제곱하면 OverFlow가 발생할 수 있다 따라서 범위 확인은 B / i 로 줄여도 같은 수식이기에 정상 동작한다.
                while( currentPrime <= B / i ){
                    // A보다 클경우 진행
                    currentPrime *= i;
                    if (currentPrime >= A) {
                        result++;
                    } // if
                } // while
            }// if
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
