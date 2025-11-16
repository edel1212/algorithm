package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] A = new int[N];
        for(int i = 0 ; i < N ;i++){
            A[i] = Integer.parseInt(br.readLine());
        }//for

        int count = 0;
        int sum = 0;
        for(int i = A.length-1; i >= 0; i--){
            if( K < A[i] || sum + A[i] > K ){
                continue;
            } //if
            while(sum + A[i] <= K){
                count++;
                sum += A[i];
            }// while
        } //

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
