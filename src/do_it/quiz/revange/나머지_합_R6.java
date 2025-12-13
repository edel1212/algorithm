package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 나머지_합_R6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        // 수열의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 나누어야 하는 값
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // 합 배열
        long[] S = new long[N];
        stringTokenizer = new StringTokenizer(br.readLine());
        // 초기 합배열 Index 지정
        S[0] = Long.parseLong(stringTokenizer.nextToken());
        // 1부터 시작 이유는 0번 인덱스의 값을 주입해 주었기 때문이다.
        for(int i = 1 ; i < N ; i++){
            S[i] = S[i - 1] + Long.parseLong(stringTokenizer.nextToken());
        } // for

        // 나눈 나머지 개수는 M을 넘을 수 없다
        long[] R = new long[M];
        for(int i = 0 ; i < S.length; i++){
            R[ (int) (S[i] % M)] ++;
        } // for

        // 딱 떨어지는 개수 주입
        long result = R[0];

        for(int i = 0 ; i < R.length ; i++){
            // 2개 이상인 경우 에만
            if(R[i] > 1){
                result += R[i] * (R[i]-1) / 2;
            } // if
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
