package baekjoon.twoDimensArr;

import java.io.*;
import java.util.StringTokenizer;

public class Q2738 {
    /**
     * N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.
     *
     * 첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다.
     * 이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고,
     * 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            String init = br.readLine();

            StringTokenizer strToken = new StringTokenizer(init, " ");

            // 행 개수
            int N = Integer.valueOf(strToken.nextToken());

            // 열 개수
            int M = Integer.valueOf(strToken.nextToken());

            // 반환할 배열
            int[][] result = new int[N][M];

            // 무조건 배열의 2배로 들어온다
            int loopCnt = 0;
            while(true){
                if(loopCnt == 2) break;
                loopCnt++;
                for(int i = 0; i < N ; i++){
                    strToken = new StringTokenizer(br.readLine(), " ");
                    for(int j = 0 ; j < M ; j++){
                        result[i][j] += Integer.valueOf(strToken.nextToken());
                    }//for
                }//for
            }// while

            // Print
            for(int[] oneDepth : result){
                for(int twoDepth : oneDepth){
                    bw.write(String.valueOf(twoDepth));
                    bw.write(" ");
                }//for
                bw.newLine();
            }//for

        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
