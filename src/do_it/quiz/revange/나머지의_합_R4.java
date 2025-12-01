package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 나머지의_합_R4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 수열의 길이
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 나눌 수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        long[] S = new long[N];
        stringTokenizer = new StringTokenizer(br.readLine());
        S[0] = Long.parseLong(stringTokenizer.nextToken());
        for(int i = 1 ; i < N ;i++){
            S[i] = S[i-1] + Long.parseLong(stringTokenizer.nextToken());
        } // for

        // 나머지 개수
        long[] R = new long[M];
        for(int i = 0 ; i < S.length ; i++){
            int remainder = (int) (S[i] % M);
            R[remainder]++;
        } // for

        long result = R[0];

        for(int i = 0 ; i < R.length ; i++){
            result += R[i] * (R[i]-1)  / 2;
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
