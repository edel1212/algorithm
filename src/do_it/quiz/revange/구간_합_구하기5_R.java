package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 구간_합_구하기5_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        // 2차원 배열 개수
        int N = Integer.parseInt(tokenizer.nextToken());
        // 원하는 좌표 계산 개수
        int M = Integer.parseInt(tokenizer.nextToken());

        int[][] A = new int[N+1][N+1]; // 기본 배열 초기화는 0부터 시작하기에 +1 해줘야 함
        for(int i = 1 ; i <= N ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++){
                A[i][j] = Integer.parseInt(tokenizer.nextToken());
            } // for
        } // for

        int[][] S = new int[N +1][N+1];
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                S[i][j] = A[i][j] + S[i-1][j] + S[i][j-1] - S[i-1][j-1];
            } // for
        } // for


        for(int i = 0 ; i < M ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());
            int result = S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1];
            bw.write(String.valueOf(result));
            bw.newLine();
        } // for

        bw.flush();
        bw.close();
        // 구간 범위

    }
}
