package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 색종이_붙이기_R2 {

    // 기본이 될 종이 칸수
    static final int PAPER_SZIE = 10;
    // 색종이 판 10 * 10 크기
    static int[][] MAP = new int [PAPER_SZIE][PAPER_SZIE];
    // 1*1 ~ 5*5 각각 색종의 남은 개수
    static int[] REMAINDER_PAPERS = {0, 5 , 5, 5 ,5, 5};
    // 사용 색종이
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 색종이 init
        for(int i = 0 ; i < PAPER_SZIE ; i ++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < PAPER_SZIE ; j ++){
                MAP[i][j] = Integer.parseInt(tokenizer.nextToken());
            } // for
        } // for

        dfs(0,0);

        if(result == Integer.MAX_VALUE ){
            bw.write("-1");
        } else {
            bw.write(String.valueOf(result));
        } // if - else
        bw.flush();
        bw.close();
    }

    // 좌료를 xy에 한번에 받아 처리
    private static void dfs(int xy, int usedPaperCount){
        // 배열의 판은 (0,0) ~ (9,9)까지의 좌표를 사용하기 떄문에 100이 들어올 경우 모든 것을 다 탐색한 것임
        if(xy == 100){
            result = Math.min(result, usedPaperCount);
            return;
        } // if

        // 최적화 - 가지치지
        if(result <= usedPaperCount) return;

        int row = xy / 10;
        int col = xy % 10;

        // 색종이를 붙일 수 있을 경우
        if( MAP[row][col] == 1 ){
            // 가장 큰 색 종이 붙어 붙일 수 있는지 확인을 함
            for(int size = 5 ; size >= 1 ; size--){
                // 색종이 사이즈 개수가 충분하고 붙일 수 있는 공간이 있을 경우
                if(REMAINDER_PAPERS[size] > 0 && isPossible(row, col, size)){
                    // 해당 사이즈 색종이 소모
                    REMAINDER_PAPERS[size]--;
                    fill(row, col, size, 0);

                    dfs(xy+1, usedPaperCount+1);

                    // 백트래킹
                    fill(row, col, size, 1);
                    REMAINDER_PAPERS[size]++;
                } // if
            } // for
        } else {
            // 색종이를 붙일 수 없을 경우 다음 좌표로 이동과 사용 색종이 카운팅을 하지 않음
            dfs(xy + 1, usedPaperCount);
        } // if - else

    }

    private static void fill(int row , int col, int size, int fillNum){
        for(int i = row; i < row + size ; i++){
            for(int j = col; j < col + size ; j++){
                MAP[i][j] = fillNum;
            } // for
        } // for
    }

    private static boolean isPossible(int row, int col, int size){
        // 10 * 10 종이의 범위를 초과할 경우 불가능
        if( row + size > PAPER_SZIE || col + size > PAPER_SZIE  ) return false;

        // 붙이려는 색종이 범위 내 0이 존재 하는지 확인
        for(int i = row; i < row + size ; i++){
            for(int j = col; j < col + size ; j++){
                if(MAP[i][j] == 0) return false;
            } // for
        } // for

        return true;
    }

}
