package do_it.quiz;

import java.io.*;

public class 신기한_소수 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받은 자릿수의 값
        N = Integer.parseInt(br.readLine());

        // 시작 값
        String[] startPrimeNum = {"2", "3", "5", "7"};

        for(String s : startPrimeNum){
            dfs(s);
        } // for

        bw.flush();
        bw.close();
    }

    public static void dfs(String num){
        if(num.length() > N) return;
        if(!isPrime(Integer.parseInt(num))) return;
        if(num.length() == N){
            System.out.println(num);
        } // if
        for(int i = 0 ; i < 10; i++){
            dfs(num + i);
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
