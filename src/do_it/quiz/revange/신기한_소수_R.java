package do_it.quiz.revange;

import java.io.*;

public class 신기한_소수_R {
    static int N;
    static BufferedWriter bw;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[] base = {2, 3, 5, 7};
        for(int i = 0 ;i < base.length; i++){
            dfs(1, base[i]);
        } // for

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int v) throws IOException{
        // 깊이가 자릿수와 같다면 종료
        if(depth == N){
            bw.write(String.valueOf(v));
            bw.newLine();
            return;
        } // if

        for(int i = 0 ; i < 10 ; i++){
            // ✅ 짝수와 5는 절대 소수가 될 수 없기에 초기 제외
            if (i % 2 == 0 || i == 5) continue;

            // 합쳐진 수를 만듬
            int convert = (v * 10) + i;
            // 지금 수가 소수야?
            if(isPrime(convert)){
                dfs(depth+ 1, convert);
            } // if
        } // for
    }

    // 소수 체크
    public static boolean isPrime(int num){
        // 소수는 1보다 무조건 커야함
        if (num < 2) return false;

        // ✅ 약수가 있는지 확인 하는 로직 소수는 1과 자기 자신만 있어야하는 수이기 때문이다.
        // - 약수는 항상 작은 수 * 큰 수 로 쌍을 이루기에 반환점을 넘으면 어차피 똑같기에 2제곱 값까지만 확인 하면 된다.
        // "36"으로 예시)
        // 1 * 36
        // 2 * 18
        // 3 * 12
        // 4 * 9
        // 6 * 6 ✨(변환점)
        // 9 * 6  ❌ <<<<<<<<<<-- 궅이 또 할 필요가 없음
        // ...
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        } // for
        return true;
    }
}
