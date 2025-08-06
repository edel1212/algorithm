package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 스타트와_링크_R4 {
    static int diffMin = Integer.MAX_VALUE;
    static int[][] team;
    static boolean[] visited;
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            team = new int[N][N];
            visited = new boolean[N];
            for(int i = 0 ; i < N ; i++){
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    team[i][j] = Integer.parseInt(line[j]);
                } // for
            } // for

            // 팀구조를 나누기 위함 [T,T,F,F]
            visited = new boolean[N];

            bw.write(String.valueOf(diffMin));
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void dfs(int depth, int idx, int N){
        if(depth == N/2){
            calc(N);
            return;
        }

        for(int i = idx ; i < N ;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth + 1, i + 1, N);
                visited[i] = false;
            } //if
        } // for
    }

    public static void calc(int N){
        int starTeam = 0;
        int linkTeam = 0;
        for(int i = 0 ; i < N - 1 ; i++){
            for(int j = i +1 ; j < N ; j++){
                if(visited[i] && visited[j]){
                    starTeam += team[i][j] + team[j][i];
                } else if(!visited[i] && !visited[j]){
                    linkTeam += team[i][j] + team[j][i];
                }
            } // for
        } // for
        int abs = Math.abs(starTeam - linkTeam);
        diffMin = Math.min(diffMin, abs);
    }
}
