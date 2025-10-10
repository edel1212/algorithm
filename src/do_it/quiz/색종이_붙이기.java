package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 색종이_붙이기 {
    // 초기 색종이 판
    static int[][] M = new int[10][10];
    // 남은 색종이 수 ( 1x1 ~ 5x5 ) - 0은 인덱스 부분이므로 제외
    static int[] S = {0,5,5,5,5,5};
    static int result = Integer.MAX_VALUE;

    static final int PAPER_COUNT = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 색종이 init
        for(int i = 0 ; i < PAPER_COUNT ; i ++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < PAPER_COUNT ; j ++){
                M[i][j] = Integer.parseInt(tokenizer.nextToken());
            } // for
        } // for

        dfs(0,0);

        if(Integer.MAX_VALUE == result){
            // 값을 바꿀 수 없을 경우
            bw.write("-1");
        } else{
            bw.write(String.valueOf(result));
        } // if - else

        bw.flush();
        bw.close();
    }

    public static void dfs(int xy, int useCount){
        // xy 는 각각 x,y 좌표를 의마함
        if(xy == 100){
            result = Math.min(result, useCount);
            return;
        } // if

        // 가지치지 - 불필요한 탐색 제거 이미 최소 값보다 클 경우 탐색 불필요
        if(result <= useCount) return;

        int x = xy % 10 ;
        int y = xy / 10 ;

        // 해당 위치 좌표의 색종이가 1일 경우만 종이를 붙일 수 있음
        if(M[y][x] == 1){
            // 가장 큰 색종이 부터 매칭 확인
            for(int i = 5 ; i > 0 ; i--){
                // 색종이가 사용 가능할 만큰 수량 && 지정 좌표에 사용이 가능한 색종이 인지
                if(S[i] > 0 && check(x,y, i)){
                    S[i]--;
                    fill(x, y, i, 0);
                    dfs(xy + 1, useCount+1);
                    fill(x, y, i, 1);
                    S[i]++;
                } // if
            } // for
        } else {
            // 다음 좌표로 이동
            dfs(xy+1 , useCount);
        } // if - else

    }

    public static void fill(int x, int y, int size, int num){
        for(int i = y; i < y + size ; i++){
            for(int j = x; j < x + size ; j++){
                M[i][j] = num;
            } // for
        } // for
    }

    public static boolean check(int x, int y , int size){
        // 좌표를 초과할 경우
        if( x + size > 10 || y + size > 10 ) return false;
        // 확인 가능한 부분 전체 확인
        for(int i = y; i < y + size ; i++){
            for(int j = x; j < x + size ; j++){
                if(M[i][j] == 0) return false;
            } // for
        } // for
        return true;
    }
}
