package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 나머지_합_R3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 수열의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 나눌 수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // 합 배열
        int[] S = new int[N];
        stringTokenizer = new StringTokenizer(br.readLine());
        S[0] = Integer.parseInt(stringTokenizer.nextToken());
        for(int i = 1 ; i < N ; i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());;
        } // for

        // 나머지 개수
        int[] R = new int[M];
        for(int i = 0 ; i < N ; i++){
            R[ (int) S[i] % M] ++;
        } // for

        long result = R[0];

        for(int i = 0 ; i < R.length; i++){
            if(R[i] > 1){
                result += (long) R[i] * (R[i] - 1) / 2;
            } // if
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}
