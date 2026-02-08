package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 다리_놓기 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 질의 횟수
        int T = Integer.parseInt(br.readLine());

        int[][] D = new int[30+1][30+1];

        // DP init
        for(int i = 0 ; i <= 30 ;i++){
            // 아무것도 안 뽑을 경우 = 1
            D[i][0] = 1;
            // 자기 자신을 뽑을 경우 = 1
            D[i][i] = 1;
            // i를 1번씩 뽑을 경우 는 i
            D[i][1] = i;
        } // for

        for(int i = 2; i <= 30 ;i++){
            for(int j = 1; j < 30 ;j++){
                D[i][j] = D[i-1][j -1] + D[i-1][j];
            } // for
        } // for

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < T ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(D[M][N]);
            sb.append("\n");
        }// for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
