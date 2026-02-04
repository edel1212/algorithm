package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class 링크와_스타트 {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            } // for
        } // for

        dfs(0,0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }


    private static void dfs(int player, int startTeamSize){
        // 1. 모든 사람(N명)의 팀 배정이 완료된 경우
        if(N == player){
            // 1명 이상의 팀에 속해 있을 경우
            if(startTeamSize > 0 && startTeamSize < N){
                calc();
            } // if
            return;
        } // if

        /**
         * 이진 선택 DFS 방식임
         * - 두 가지 선택지(예/아니오)"를 줌
         */

        // 스타트 팀이로 갈 경우
        visited[player] = true;
        dfs(player + 1, startTeamSize + 1);

        // 링크 팀으로 갈 경우
        visited[player] = false;
        dfs(player + 1, startTeamSize); // 팀원 수 유지!
    }

    private static void calc(){
        int startScore = 0;
        int linkScore = 0;
        for(int i = 0 ; i < N - 1; i++){
            for(int j = i + 1 ; j < N; j++){
                // 둘 다 스타트 팀일 때만
                if (visited[i] && visited[j]) {
                    startScore += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkScore += S[i][j] + S[j][i];
                } // if - else if
            }//for
        } // for

        int diff = Math.abs(startScore - linkScore);

        if(diff == 0){
            System.out.println("0");
            System.exit(0);
        }// if

        result = Math.min(diff, result);
    }
}
