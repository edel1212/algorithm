package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 플로이드_R {
    public static int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시 수
        int N = Integer.parseInt(br.readLine());
        // 버스 노선 수
        int M = Integer.parseInt(br.readLine());

        int[][] dist = new int[N + 1][ N + 1];

        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j <= N ; j++){
                if(i == j){
                    dist[i][j] = 0;
                    continue;
                } // if
                dist[i][j] = INF;
            } // for
        } // for

        for(int i = 0 ; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            if(dist[S][E] > W){
                dist[S][E] = W;
            } // if
        } // for

        for(int K = 1 ; K <= N ; K++){
            for(int S = 1 ; S <= N ; S++){
                for(int E = 1 ; E <= N ; E++){
                    dist[S][E] = Math.min(dist[S][E], dist[S][K] + dist[K][E] );
                }//for
            }//for
        }//for

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                if(dist[i][j] == INF){
                    sb.append("0").append(" ");
                    continue;
                }// if
                sb.append(dist[i][j] + " ");
            } // for
            sb.append("\n");
        } // for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
