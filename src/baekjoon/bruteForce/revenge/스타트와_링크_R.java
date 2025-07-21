package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 스타트와_링크_R {
    static int[][] team;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            int N = Integer.parseInt(br.readLine());
            visited = new boolean[N + 1];
            team = new int[N][N];

            // team-init
            for(int i = 0 ; i < N ; i++){
                String[] str = br.readLine().split(" ");
                for(int j = 0; j < str.length; j++ ){
                    team[i][j] = Integer.parseInt(str[j]);
                } // for
            } // for

            dfs(0, 0, N);

            bw.write(String.valueOf(minDiff));
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void dfs(int depth, int idx, int N){
        if(depth != N / 2){
            calculateAbility(N);
            return;
        } // if

        for(int i = idx; i < N ; i ++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth + 1 , i +1, N);
                visited[i] = false;
            } //if
        } // for
    }

    public static void calculateAbility(int N){
        int startTeam = 0;
        int linkTeam = 0;
        for(int i = 0 ; i < N - 1; i++){
            for(int j = i + 1 ; j < N ; j++){
                if(visited[i] && visited[j]){
                    startTeam += team[i][j] + team[j][i];
                } else if(!visited[i] && !visited[j]){
                    linkTeam += team[i][j] + team[j][i];
                } // if
            }// for
        } // for
        int diff = Math.abs( startTeam - linkTeam );
        minDiff = Math.min(minDiff, diff);
    }

}
