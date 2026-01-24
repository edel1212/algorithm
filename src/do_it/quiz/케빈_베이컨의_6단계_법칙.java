package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 케빈_베이컨의_6단계_법칙 {
    static final int INF = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // node count
        int N = Integer.parseInt(st.nextToken());
        // edge count
        int M = Integer.parseInt(st.nextToken());

        // init arr
        int[][] A = new int[N + 1][N + 1];
        // ✅ 초기값 추가
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                // 이유는 내 자신은 이미 나와 연결되어 있으니까
                if( i == j) A[i][j] = 0;
                // 무한대로 설정
                else A[i][j] = INF;
            } //for
        } //for

        // add array by edge data
        for(int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // ✅ 단방향 그래프가 아닌 양방항 그래프임
            A[s][e] = 1;
            A[e][s] = 1;
        } //for

        // 플로이드 워셜 알고리즘
        for(int K = 1 ; K <= N ; K++){
            for(int S = 1 ; S <= N ; S++){
                for(int E = 1 ; E <= N ; E++){
                    // S -> E 로 가는 길 vs K를 거쳐서 가는 길
                    A[S][E] = Math.min( A[S][E], A[S][K] + A[K][E] );
                } //for
            } //for
        } //for

        int result = -1;
        // ✅ 우리가 찾고자 하는건 낮은 케빈 베이컨의 법칙임
        int minSum = Integer.MAX_VALUE;

        for(int S = 1 ; S <= N ; S++){
            int sum = 0;
            for(int E = 1 ; E <= N ; E++){
                sum += A[S][E];
            } //for

            // 값이 작을 때 마다 변경
            if(sum < minSum){
                minSum = sum;
                result = S;
            } // if
        } //for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
