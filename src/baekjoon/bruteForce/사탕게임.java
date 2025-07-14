package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 사탕게임 {
    /**
     * 상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.
     *
     * 가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다.
     * 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다.
     * 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.
     *
     * 사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.
     */
    // 사용자가 처음으로 입력한 값
    static int N = 0;
    // 초기 사탕 박스
    static String[][] box;
    // 최대 값 (반환 결과)
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            // 초기 값 세팅
            N = Integer.parseInt(br.readLine());
            box = new String[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    box[i][j] = String.valueOf(line.charAt(j));
                } // for
            } // for

            // 하나씩 위치를 바꿔가며 확인
            for(int i = 0; i < N; i++) {

                for(int j = 0 ; j < N; j++){

                    // 가로가 가능할 때 [ 옆으로 옮길 수 있는지 확인하는 것 - IndexOutOfBounds Exception  ]
                    if(j + 1 < N){
                        // 변경
                        swap(i,j,i,j+1);
                        checkMax();
                        // 복구
                        swap(i,j,i,j+1);
                    } // if

                    // 세로가 가능할 때 [ 아래로 옮길 수 있는지 확인하는 것 - IndexOutOfBounds Exception  ]
                    if (i + 1 < N) {
                        swap(i, j, i + 1, j);
                        checkMax();
                        swap(i, j, i + 1, j);
                    } // if

                } // for

            } // for

            bw.write(String.valueOf(max));

        } catch (Exception e){
            e.printStackTrace();
        } // try - catch

    }

    // 가장 긴 같은 사탕의 길이 찾기
    static void checkMax() {
        // 행 체크
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (box[i][j].equals(box[i][j - 1])) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }

        // 열 체크
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (box[i][j].equals(box[i - 1][j])) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }
    }

    public static void swap(int x1, int y1, int x2, int y2){
        String tmp = box[x1][y1];
        box[x1][y1] = box[x2][y2];
        box[x2][y2] = tmp;
    }

}
