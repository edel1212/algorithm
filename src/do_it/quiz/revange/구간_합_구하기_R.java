package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구간_합_구하기_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        // N×N  배열
        int N = Integer.parseInt(tokenizer.nextToken());
        // 찾아야하는 범위 개수
        int M = Integer.parseInt(tokenizer.nextToken());

        int[][] box = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++){
                box[i][j] = Integer.parseInt(tokenizer.nextToken());
            } // for
        } // for

        // 합배열 생성
        int[][] prefixSumBox = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                prefixSumBox[i][j] = prefixSumBox[i-1][j] + prefixSumBox[i][j-1] - prefixSumBox[i-1][j-1] + box[i][j];
            } // for
        } // for

        // 구간의 합
        for(int i = 0 ; i < M ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());

            int rangeSum = prefixSumBox[x2][y2] - prefixSumBox[x1-1][y2] - prefixSumBox[x2][y1-1] + prefixSumBox[x1-1][y1-1];

            bw.write(String.valueOf(rangeSum));
            bw.newLine();
        } // for
        bw.flush();
        bw.close();
    }
}
