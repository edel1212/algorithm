package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 경로_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] dist = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
            }// for
        }// for

        for(int K = 0 ; K < N ; K++){
            for(int S = 0 ; S < N ; S++){
                for(int E = 0 ; E < N ; E++){
                    if( dist[S][K] == 1 && dist[K][E] == 1 ) dist[S][E] = 1;
                } // for
            } // for
        } // for

        StringBuilder sb = new StringBuilder();
        for(int S = 0 ; S < N ; S++){
            for(int E = 0 ; E < N ; E++){
                sb.append(dist[S][E] + " ");
            } // for
            sb.append("\n");
        } // for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
