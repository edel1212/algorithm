package do_it.quiz;

import java.io.*;
import java.util.Arrays;

public class 소수_팰린드롬 {
    static final int LIMIT = 1_000_000;
    public static void main(String[] args)   throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int maxPrimeLimit = (int) Math.sqrt(LIMIT);
        boolean[] isPrime = new boolean[LIMIT + 1];

        // 0과 1은 소수가 아님
        for(int i = 2 ; i <= LIMIT; i++){
            isPrime[i] = true;
        } // for

        for(int i = 2 ; i <= maxPrimeLimit; i++){
            if(!isPrime[i]) continue;
            for(int j = i * i; j <= LIMIT; j += i){
                isPrime[j] = false;
            }// for
        } // for

        for(int i = N; i <= LIMIT; i++){
            int original = i;
            if( isPrime[original] && isPalindrome(original)){
                bw.write(String.valueOf(original));
                break;
            }// if
        } // for

        bw.flush();
        bw.close();
    }

    public static boolean isPalindrome(int n) {
        // 문자열로 변경
        String s = String.valueOf(n);
        // 문자의 길이를 가져옴
        int len = s.length();

        // 문자열의 시작(i)과 끝(len - 1 - i)을 비교
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false; // 불일치하면 팰린드롬이 아님
            } // if
        }
        return true; // 모두 일치하면 팰린드롬임
    }
}
