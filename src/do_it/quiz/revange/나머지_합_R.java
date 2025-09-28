package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 나머지_합_R {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        // 수열의 개수
        int N = Integer.parseInt(tokenizer.nextToken());
        // 나누어 떨어지는 수
        int M = Integer.parseInt(tokenizer.nextToken());

        long[] sumArr = new long[N];

        // 초기 배열
        tokenizer = new StringTokenizer(br.readLine());
        sumArr[0] = Integer.parseInt(tokenizer.nextToken());

        // 합배열 init
        for(int i = 1 ; i < N ; i++) sumArr[i] = sumArr[i-1] + Integer.parseInt(tokenizer.nextToken());

        int[] C = new int[M];
        for(int i = 0 ; i < sumArr.length; i++){
            // ✅ ()를 통해 먼저 계산해 주는것이 핵심 포인트다
            int remainder = (int) (sumArr[i] % M);
            // 음수 보정
            if( remainder < 0) remainder += M;
            // 나머지 개수 ++
            C[remainder]++;
        } // for

        long result = C[0];

        for(int i = 0 ; i < M ; i++){
            // 남은 수가 2개 이상일 경우
            if(C[i] > 1){
                // 같은 수의 조합은 맞아 떨어진다.
                result += (long) C[i] * (C[i] - 1) /2;
            } // if
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
