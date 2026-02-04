package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 이항_계수_1 {
    // 자연수
    static int N;
    // 정수
    static int K;
    // DP 배열 생성
    static int[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        D = new int[N + 1][N + 1];

        for(int i = 0 ; i <= N ; i++){
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        } // for

        for(int i = 2 ; i <= N ; i++){
            for(int j = 1; j < i ; j++){
                D[i][j] = D[i - 1][j] + D[i - 1][ j - 1 ];
            } //for
        } // for

        bw.write(String.valueOf(D[N][K]));
        bw.flush();
        bw.close();

    }
}
