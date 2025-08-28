package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 나머지의_합_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        long[] sumArr    = new long[N];

        // 합 배열 생성
        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        // 초기 값 생성
        sumArr[0] = Integer.parseInt(stringTokenizer.nextToken());
        for(int i = 1 ; i < N ;i++){
            sumArr[i] =  sumArr[ i - 1 ] + Integer.parseInt(stringTokenizer.nextToken());
        }// for

        // 나누어 떨어지는 구간의 합 개수
        // 나눈 수의 나머지는 나눈 수 클 수 없기에 배열 사이즈를 M으로 선언
        int[] C = new int[M];
        for (int i = 0; i < N; i++) {
            int remainder = (int) (sumArr[i] % M);
            if (remainder < 0) remainder += M; // ✅ 음수 보정
            C[remainder]++;
        } // for

        long answer = C[0]; // 나머지 0인 경우 카운트
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                // 콤비네이션 공식 사용 0 이상의 같은 수가 있을 때 조합 개수를 더해 줌
                answer += (long) C[i] * (C[i] - 1) / 2;
            } // if
        } // for

        bw.write(String.valueOf(answer));
        bw.flush();

    }
}
