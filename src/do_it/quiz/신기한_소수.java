package do_it.quiz;

import java.io.*;

public class 신기한_소수 {
    static int N;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받은 자릿수의 값
        N = Integer.parseInt(br.readLine());

        // 시작 값
        int[] startPrimes = {2, 3, 5, 7};

        for (int prime : startPrimes) {
            dfs(prime, 1);  // (숫자, 현재 자릿수)
        } // for

        bw.flush();
        bw.close();
    }

    public static void dfs(int num, int depth) throws IOException{
        // 소수가 아닐 경우 제외
        if (!isPrime(num)) return;

        // 원하는 자릿수의 소수면 출력
        if (depth == N) {
            bw.write(num + "\n");
            return;
        } // if

        // 뒤에 소수가 가능한 범위인 {1, 3, 7, 9}을 사용하는 방법 또한 있음
        for(int i = 0 ; i < 10; i++){
            dfs(num * 10 + i, depth + 1);
        } // for

    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;     // 1 이하 정수는 소수 아님
        if (num == 2) return true;      // 2는 소수
        if (num % 2 == 0) return false; // 짝수는 소수 아님

        // √num 까지만 검사 (효율성)
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }

}
