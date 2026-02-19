package do_it.quiz.revange;

import java.io.*;

public class N_Queen_R {
    // 퀸은 * 모양으로 공격이 가능하기에 row에 1개만 둘 수 있으므로 1차원 배열로 표현
    // [가로 위치] = 세로 위치
    static int[] map;
    // 입력 받은 N
    static int N;
    // 퀸을 놓을 수 있는 카운트
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        // 체스판 초기화
        map = new int[N];

        // 0번 부터 시작하면 DFS를 통해 깊이 탐색을 시작함
        dfs(0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static void dfs(int row){
        // N 개의 퀸을 모두 놓았으니 카운트 다른 경우의 수 찾기
        if(row == N){
            count++;
            return;
        }// if

        // 세로 확인
        for(int col = 0 ; col < N ; col++){
            // 퀸을 해당 좌표에 위치 시켜 봄 ( 방문 처리 - 백트레킹 )
            map[row] = col;

            // 해당 좌표에 퀸을 위치할 수 있는지 확인
            if(possibility(row)){
                // 다음 row에 퀸을 위치 시킴
                dfs(row + 1);
            } // if

        } // for

    }


    private static boolean possibility(int row){
        // 내 윗쪽 행들을 검사 함 (아래쪽은 아직 두지 않았기에 검사할 필요가 없음)
        for(int pastRow = 0 ; pastRow < row ; pastRow++){
            // 같은 열에 퀸이 존재할 경우 위치 제외
            if(map[row] == map[pastRow]){
                return false;
            } else if(Math.abs(row - pastRow) == Math.abs(map[row] - map[pastRow]) ){
                // 대각선이 같을 경우에도 탈락
                return false;
            } // if - else if
        } // for

        return true;
    }

}
