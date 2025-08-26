package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 구간_합_구하기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        // 그래프
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 연산 범위
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        int[][] sumArr = new int[N + 1][N + 1];

        // 그래프 init
        for(int i = 1 ; i <= N ;i++){
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            } // for
        } // for

        // 합 그래프 init
        for(int i = 1 ; i <= N ;i++){
            for(int j = 1 ; j <= N ; j++){
                sumArr[i][j] =
                        // 대상의 좌측 + 대상의 위쪽
                        sumArr[i-1][j] + sumArr[i][j-1]
                                // 중복된 부분 제거 (겹치기 때문)
                                - sumArr[i-1][j-1]
                                // 대상의 원본 위치를 더 해줌
                                + arr[i][j];
            } // for
        } // for

        // 범위의 합 반환
        for(int i = 0; i < M ;i ++){
            stringTokenizer = new StringTokenizer(br.readLine());
            // 합 범위 좌표
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            int result =
                    // 범위 대상의 가장 끝
                    sumArr[x2][y2]
                    // 범위의 가장 윗쪽
                    - sumArr[x1-1][y2]
                    // 범위의 가장 왼쪽
                    - sumArr[x2][y1 -1]
                    // 중복으로 제거된 부분 다시 추가
                    + sumArr[x1-1][y1-1];
            bw.write(String.valueOf(result));
            bw.newLine();
        } // for
        bw.flush();
    }
}
