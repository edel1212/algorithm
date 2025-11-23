package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 색종이_붙이기_R {
    static final int BASE_PAPER_COUNT = 10;
    // 색종이 판
    static int[][] M = new int[BASE_PAPER_COUNT][BASE_PAPER_COUNT];
    // 1x1 ~ 5x5 까지의 색종이 수
    static int[] S = {0,5,5,5,5,5};
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 색종이 init
        for(int i = 0 ; i < BASE_PAPER_COUNT ; i ++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < BASE_PAPER_COUNT ; j ++){
                M[i][j] = Integer.parseInt(tokenizer.nextToken());
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

    // ☠️ 어떻게 체크하는지 생각조차 못함
    public static boolean check(int x, int y, int size){
        // x와 y가 넣어보려는 색종이 사이즈보다 클 경우 사용 불가 (false)
        if( x + size > 10 || y+size > 10 ) return false;
        // 입력 받은 위치에서 부터 2중 반복문을 통해
        // 범위까지 확인 가능한 부분인지 확인
        for(int i = y; i < y + size ; i++){
            for(int j = x; j < x + size ; j++){
                // 넣어보려는 곳이 0일 경우 사용 불가 (false)
                if(M[i][j] == 0) return false;
            } // for
        } // for
        return true;
    }

    public static void fill(int x , int y, int size, int fillNum){
        // check 함수에서 검증이 끝났기에 해당 값을 지정 한 값으로 채우거나 색을 제거함
        for(int i = y; i < y + size ; i++){
            for(int j = x; j < x + size ; j++){
                M[i][j] = fillNum;
            } // for
        } // for
    }

    // xy를 하나의 변수로 사용한 이유는 dfs의 간소화를 위해서임 2차원을 하나의 변수로 표현
    public static void dfs(int xy, int usedFillCount){
        // 100 일 경우 y는 10, x는0 임
        // --> 99일 경우 y는9 x는 9 (끝까지 다봄)
        if(xy == 100){
            result = Math.min(result, usedFillCount);
            return;
        } // if
        // 이미 값을 구했으면 해당 재귀는 불필요하므로 종료
        if(result <= usedFillCount) return;

        int x = xy % 10;
        int y = xy / 10;

        if(M[y][x] == 1){ // 입력 받은 좌표가 색종이를 붙있을 수 있음
            // 가장 큰 색종이부터 붙여봄 (최적화)
            for(int i = 5 ; i > 0 ; i--){
                // 잔여 색종이가 있으며, 붙을 수 있는 공간이 있을 경우
                if( S[i] > 0 && check(x,y,i) ){
                    // 색종이 사용
                    S[i] --;
                    fill(x,y,i,0);
                    // 다음 좌표 이동 후 색칠 카운트를 올려줌
                    dfs(xy+1 , usedFillCount+1);
                    // 백트래킹
                    fill(x,y,i,1);
                    S[i] ++;
                } // if
            } // for
        } else { // 입력 받은 좌표가 생종이를 붙일 수 없음
            // 좌표만 이동하고 생종이 붙인 카운트를 올리지 않음
            dfs(xy+1 , usedFillCount);
        } // if - else

    }
}
