package do_it.quiz.revange;

import java.io.*;

public class 소수_팰린드롬_R {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 시작 값
        int N = Integer.parseInt(br.readLine());
        // ☠️ 함정 - N의 범위가 "1,000,000"인거지 소수의 최대 범위는 1,000,000일 경우 소수의 최대 범위를 구해야한는 것이다.
        final int LIMIT_RANGE = 2_000_000;

        boolean[] isNotPrime = new boolean[LIMIT_RANGE + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        // 1. 소수를 찾음
        int limit = (int) Math.sqrt(LIMIT_RANGE);
        for(int i = 2 ;  i <= limit ; i++){
            // 제거되지 않은 첫번째 수 일 경우
            if(!isNotPrime[i]){
                // 성능 항샹을 위해 제곱값으로 더해가며 수 제거
                for(int j = i * i ; j <= LIMIT_RANGE ; j += i){
                    isNotPrime[j] = true;
                } // for
            } // if
        } // for

        // 2. 소수 내 팰린드롬를 찾음
        for(int i = N ; i <= LIMIT_RANGE ; i++){

            // 소수 일 경우
            if(!isNotPrime[i]){
                // 문자열로 변경
                String primeStr = String.valueOf(i);

                // 투 포인터를 이용해서 값 비교
                int start = 0;
                int end = primeStr.length() - 1;

                // 팰린드롬 일경우
                boolean isPalindrome = true;
                // 앞뒤 비교
                while(start <= end){
                    char front = primeStr.charAt(start);
                    char back = primeStr.charAt(end);
                    // 앞뒤 비교가 다를 경우
                    if(front != back){
                        isPalindrome = false;
                      break;
                    }  // if

                    // 포인터 이동
                    start++;
                    end--;
                } // while

                // 팰랜드롬일 경우
                if(isPalindrome){
                    // 최솟 값 소수 & 팰린드롬 출력
                    bw.write(String.valueOf(i));
                    break;
                } // if

            } // if

        } // for

        bw.flush();
        bw.close();
        br.close();
    }
}
