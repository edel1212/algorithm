package do_it.quiz;

import java.io.*;

public class 부녀회장이_될테야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // DP 배열
        int[][] D = new int[15][15];

        // 상황에 맞게 초기화 ( DP의 핵심임 )
        for(int i = 0 ; i < 15 ; i++){
            // 0 층의 i호 사람 수 => 각 층마다 1명씩 산다
            D[0][i] = i;
            // i층의 1 호는 1명만 산다.
            D[i][1] = 1;
        } // for

        // 0 층은 이미 했으므로 1층부터 시작
        for(int i = 1 ; i < 15; i++){
            // 2호 부터 시작
            for(int j = 2 ; j < 15; j ++){
                // 내가 찾는 방은 = 내 전 방 + 찾는 방 바로 아래
                D[i][j] = D[i][j - 1] + D[i -1][j];
            } // for
        } // for

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호

            // 미리 계산된 테이블에서 정답만 쏙 꺼내서 출력
            bw.write(D[k][n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
