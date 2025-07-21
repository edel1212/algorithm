package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 스타트와_링크_R2 {

    static int[][] team;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int N = Integer.parseInt(br.readLine());

            // team 초기 정의
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    team[i][j] = Integer.parseInt(line[j]);
                } // for
            } // for

            team = new int[N][N];
            visited = new boolean[N];

            dfs(0,0,N);
            bw.write(String.valueOf(minDiff));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void dfs(int depth, int idx, int N){
        if(depth == N/2){
            calculationAbility(N);
            return;
        }

        for(int i = idx ; i < N  ; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth + 1, i + 1,  N);
                visited[i] = false;
            } // if
        } //for
    }

    public static void calculationAbility(int N){
        int starTeam = 0;
        int linkTeam = 0;

        for(int i = 0 ; i < N -1 ; i++){
            for(int j = i+1; j <N ; j++){
                if(visited[i] && visited[j]){
                    starTeam += team[i][j] + team[j][i];
                } else if(!visited[i] && !visited[j]){
                    linkTeam += team[i][j] + team[j][i];
                }
            } // for
        } // for

        int abs = Math.abs(starTeam - linkTeam);
        minDiff = Math.min(minDiff, abs);
    }
}
