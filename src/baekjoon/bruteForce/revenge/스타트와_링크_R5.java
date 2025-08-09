package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 스타트와_링크_R5 {
    static int diffMin = Integer.MAX_VALUE;
    static int[][] teamStatus;
    static boolean[] visited;
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            visited = new boolean[N];
            teamStatus = new int[N][N];

            for(int i = 0 ; i < N ; i++){
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    teamStatus[i][j] = Integer.parseInt(line[j]);
                } // for
            } // for

            // DFS 시작
            dfs(0, 0, N);

            bw.write(String.valueOf(diffMin));
        } catch(Exception e){
            e.printStackTrace();
        } // try - catch
    }


    public static void dfs(int depth, int idx, int N){
        if(diffMin == 0) return;
        // 2:2로 팀이 나눠졌을 경우
        if(depth == N /2 ){
            calc(N);
            return;
        } // if

        for(int i = idx ; i < N ; i++ ){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, i + 1, N);
                visited[i] = false;
            } //if
        } // for
    }

    public static void calc(int N){
        int teamLink = 0;
        int teamStart = 0;
        for(int i = 0 ; i < N - 1; i++){
            for(int j = i + 1; j < N ;j++){
                if( visited[i] && visited[j] ){
                    teamLink += teamStatus[i][j] + teamStatus[j][i];
                } else if( !visited[i] && !visited[j] ){
                    teamStart += teamStatus[i][j] + teamStatus[j][i];
                } // if - else if
            } // for
        } //for
        int abs = Math.abs( teamStart - teamLink );
        diffMin = Math.min(abs, diffMin);
    } //for

}
