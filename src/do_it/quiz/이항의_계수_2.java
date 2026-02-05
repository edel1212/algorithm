package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 이항의_계수_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] D = new int[N + 1][N + 1];

        for(int i = 0 ; i <= N ; i++){
            // 아무것고 안고를 경우 1
            D[i][0] = 1;
            // 전부다 고를 떄는 1번
            D[i][i] = 1;
            // 각각 한번씩 고를 때는 1번
            D[i][1] = i;
        } // for

        // 점화식
        for(int i = 2 ; i <= N ;i++){
            for(int j = 1 ; j< i ; j++ ){
                D[i][j] = D[i - 1][ j  - 1] + D[i-1][j];
                D[i][j] = D[i][j] % 10_007;
            } // for
        } // for

        bw.write(String.valueOf(D[N][K]));
        bw.flush();
        bw.close();
        br.close();
    }
}
