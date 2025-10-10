package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 나머지_합_R2 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        long[] S = new long[N];
        S[0] = Integer.parseInt(tokenizer.nextToken());
        for(int i = 1 ; i < N ; i++) S[i] = S[i-1] + Integer.parseInt(tokenizer.nextToken());

        int[] remainder = new int[M+1];
        for(int i = 0 ; i < N ; i ++){
            int remainderIdx = (int) (S[i] % M) ;
            remainder[remainderIdx]++;
        } // for

        long result = remainder[0];

        for( int r = 0 ; r < remainder.length; r++ ){
            if(remainder[r] >= 2 ){
                //result += remainder[r] * (remainder[r - 1]/2);
                result += (long) remainder[r] * (remainder[r] - 1) /2;
            } // if
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
