package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 스타트와_링크_R3 {
    static int minDiff = Integer.MAX_VALUE;
    static int[][] team;
    static boolean[] visited;
    public static void main(String[] args) {
        // 2차원 배열 만들고
        // loop 돌면서 최소 값을 찾아서 반환하면 끝 아님?
        // s[i][j] - s[j][i]
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            team = new int[N][N];
            for(int i = 0 ; i < N ; i++){
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    team[i][j] = Integer.parseInt(line[j]);
                } // for
            } // for

            // 팀구조를 나누기 위함 [T,T,F,F]
            visited = new boolean[N];

            bw.write(String.valueOf(minDiff));
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void dfs(int depth, int idx, int N){
        // depth가 반이면 인원수가 반반으로 나눠진 1차원배열 을 얻음
        if(depth == N/2){
            calc(N);
            return;
        }

        // 사람 선택 ( 2: 2를 만드는 구조)
        for(int i = idx ; i < N ; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, i+1, N);
                visited[i] = false;
            } // if
        } // for
    }

    public static void calc(int N){
        int starTeam = 0;
        int linkTeam = 0;
        // 첫 배열의 범위거 N-1 인 이유는 2중 for문에서 i+1을 시작하기 때문임
        for(int i = 0 ; i < N - 1 ;i++){
            for(int j = i+1 ; j < N; j++){
                if(visited[i] && visited[j]){
                    starTeam += team[i][j] + team[j][i];
                } else if(!visited[i] && !visited[j]){
                    linkTeam += team[i][j] + team[j][i];
                } // if - else if
            } // for
        } // for
        int abs = Math.abs(starTeam - linkTeam);
        minDiff = Math.min(minDiff, abs);
    }

}
