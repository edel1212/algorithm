package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.MIN_VALUE;

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            int score = Integer.parseInt(stringTokenizer.nextToken());
            arr[i] = score;
            M = Math.max(M, score);
        } // for

        double[] doubleArr = new double[N];

        for(int i = 0 ; i < N ; i++){
            doubleArr[i] = (double) arr[i] / M * 100;
        } // for

        double total = Arrays.stream(doubleArr).reduce((a,b)->a+b)
                .getAsDouble();

        bw.write(String.valueOf(total / N));
        bw.flush();
    }
}
