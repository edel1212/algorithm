package do_it.quiz;

import java.io.*;

public class N_Queue {

    // 체스판 ( 행의 경우 Index , 열의 경우 체스의 위치를 의미함 )
    static int[] A;
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        // 첫번째 행 ( Index ) 부터 탐색 시작
        bfs(0);

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    public static void bfs(int row){
        // N-1로 하지 않는 이유는 재귀의 특성을 생각하면 된다. (메서드 마지막에 row를 ++ 하기 때문임)
        if(row == N){
            cnt++;
            return;
        } // if

        // 체스판의 지졍 row의 각 열마다 체스 배치
        for(int i = 0 ; i < N ;i++){
            // 입력 받은 행에 배치
            A[row] = i ;
            if(check(row)){
                // 해당 방식은 override를 하는 방식이기에 값을 빼주거나 할 필요가 없는 것임
                bfs(row + 1);
            } //if
        } // for

    }

    public static boolean check(int row){
        for(int i = 0 ; i < row ; i++){
            // 같은 열에 존재 하는 것을 의미함
            if( A[i] == A[row] ) return false;
            // 대각선 비교
            if(Math.abs(row - i) == Math.abs(A[row] - A[i])) return false;
        }//for
        return true;
    }

}
