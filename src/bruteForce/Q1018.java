package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
            int N = Integer.parseInt(stringTokenizer.nextToken());
            // 가로
            int M = Integer.parseInt(stringTokenizer.nextToken());
            
            // 보드 생성
            String[][] board = new String[M][N];
            for(int row = 0 ; row < M ; row++){
                String input = br.readLine();
                for(int col = 0 ; col < N ; col++){
                    board[row][col] = String.valueOf(input.charAt(col));
                }// for
            }// for

            // 8 * 8 경우의 수 비교 ( 받아온 수의 7을 빼면 최대 횟수 )
            int N_cases_row = N - 7;
            int M_cases_col = M - 7;

            // 모든 경우의 수 loop
            for (int i = 0; i < N_cases_row; i++) {
                for (int j = 0; j < M_cases_col; j++) {
                } // for
            }// for

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
