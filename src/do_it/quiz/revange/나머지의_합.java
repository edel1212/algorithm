package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 나머지의_합 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사용자 입력값
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        // 수열의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 나눠 떨어져야하는 값
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // 수열을 사용자에게 입력 받음
        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        // 합 배열 값의 범위가 int를 넘어서기에 long으로 선언
        long[] sumArr = new long[N];
        // 합배열[0] == baseArr[0]
        sumArr[0] = Integer.parseInt(stringTokenizer.nextToken());
        // 합배열 init
        for(int i = 1 ; i < N ; i++) sumArr[i] = sumArr[i-1] + Integer.parseInt(stringTokenizer.nextToken());

        // 나누어 떨어저지는 개수르 배열을 선언
        // - 배열의 범위는 나누는 값의 범위 ( 나누는 값의 크기를 넘을 수 업음 )
        int[] C = new int[M];
        for(int i = 0 ; i < N ; i++){
            int remainder = (int) sumArr[i] % M ;
            // 음수 보정
            if( remainder < 0) remainder += M;
            // 나머지 개수 ++
            C[remainder]++;
        } // for

        // 0으로 나누어 떨어진 개수 카운트
        long answer = C[0];
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                // 콤비네이션 공식 사용 0 이상의 같은 수가 있을 때 조합 개수를 더해 줌
                // 즉,
                answer += (long) C[i] * (C[i] - 1) / 2;
            } // if
        } // for

        bw.write(String.valueOf(answer));
        bw.flush();




    }
}
