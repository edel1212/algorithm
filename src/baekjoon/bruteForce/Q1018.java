package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1018 {
    /**
     * MN개의 단위 정사각형으로 나누어져있는  M×N 크기의 보드가 있다.
     * 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.
     * 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
     * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.
     * 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고,
     * 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
     * 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다. -- 시작은 검 or 흰 임
     * 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. -  8 x 8 로 자른다
     *  당연히 8*8 크기는 아무데서나 골라도 된다. 단 ! 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
     *
     * ℹ️ 입력
     *    첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다.
     *    둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다.
     *    B는 검은색이며, W는 흰색이다.
     *      => N 세로, M 가로
     *
     *  👍 출력
     *      첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
     * */

    // 8 * 8 - 전부 흰 or 전부 검 일 재 색칠 경우
    public static int MAX_DRAW_CNT = 64;

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // N 과 M 의 값을 받음
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(stringTokenizer.nextToken()); // 세로
            int M = Integer.parseInt(stringTokenizer.nextToken()); // 가로
            
            // 보드 생성
            String[] chessboard = new String[N];
            for(int i = 0; i < N; i++) chessboard[i] = br.readLine();
            br.close();

            // 8 * 8 경우의 수 비교 ( 받아온 수의 7을 빼면 최대 보드 자를 수 있는 칸의 횟수 )
            int N_cases_row = N - 7;
            int M_cases_col = M - 7;

            // 가장 낮은 값을 비교하기 위한 초기값 지정
            int drawCount = Integer.MAX_VALUE;

            // 가능한 경우의 수를 Loop
            for(int row = 0; row < N_cases_row ; row++){

                // 한칸씩 오른쪽으로 가면서 비교 시작 (👍 포인트는 8칸 씩 움직인가 생각하는 것임)
                for(int col = 0; col < M_cases_col ; col++){
                    int resultCount = Q1018.getMinCost(row, col, chessboard);
                    if(drawCount > resultCount) drawCount = resultCount;
                }// for

            } // for

            bw.write(drawCount + "\n");
            bw.flush();
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int getMinCost(int startRow, int startCol, String[] chessboard) {
        // 각각의 기본 보드 - 흰색 , 검은색  :: 각각 겹쳐서 보임
        String[] board = {"WBWBWBWB", "BWBWBWBW"};

        // 화이트를 기준으로 카운트
        int whiteChessBoardDrawCnt = 0;

        // 판을 한칸 씩 옮기며 Loop
        for(int i = 0; i < 8; i++){
            // 시작값을 더한 한칸임
            int row = startRow + i;
            // 세로 Loop 체크
            for(int j = 0; j < 8; j++){
                int col = startCol + j;

                // 정답 보드 - 흰색 체스판을 기준으로 하기에 %2로 시작
                char baseBoardPiece     = board[row % 2].charAt(j);
                // 매개변수로 받아온 보드
                char boardPiece         = chessboard[row].charAt(col);
                // 정답 보드의 피스와 같지 않다면 색칠 카운드 ++
                if( boardPiece != baseBoardPiece) whiteChessBoardDrawCnt++;
            }//  for

        }// for
        // 최소 값을 비교 해당 판의 흰색과 검은색 중 최소 확인
        // ℹ️ 흰색 or 검은색 의 색칠 수를 최대 8 * 8의 값인 64를 빼면 반대 버전의 색칠 수가 나옴
        return Math.min(whiteChessBoardDrawCnt, MAX_DRAW_CNT - whiteChessBoardDrawCnt);

    }
}
