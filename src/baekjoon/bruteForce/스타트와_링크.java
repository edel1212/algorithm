package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 스타트와_링크 {
    // 최소 능력차이를 저장 할 변수 ( 결과 )
    static int minDiff = Integer.MAX_VALUE;
    // 팀의 능략치를 저장할 배열
    static int [][] team;
    // 중복 방문을 제외 하기위한 배열
    static boolean[] visited;
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            // 배열 크기 저장
            team = new int[N][N];
            // 방문 배열 초기 크키 저장
            visited = new boolean[N];

            // team 초기 정의
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    team[i][j] = Integer.parseInt(line[j]);
                } // for
            } // for

            dfs(0, 0, N);

            // result
            bw.write(String.valueOf(minDiff));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void dfs(int depth, int idx, int N){
        // 팀 완성이 반/반으로 완성 될 경우
        if(depth == N / 2){
            calculateAbility(N);
            return;
        } // if

        // 팀 생성 - 재귀를 통해 모든 경우의 수로 만듬 - visited를 활용하여 팀을 나눈 것
        for(int i = idx ; i < N ; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth + 1, i + 1, N);
                visited[i] = false;
            } // if
        } // for
    }


    // 능력치 확인
    public static void calculateAbility(int N){
        // 스타티 팀 능럭치
        int startTeam = 0;
        // 링크 팀 능력치
        int linkTeam = 0;

        for(int i = 0 ; i < N - 1; i++){

            for(int j = i + 1 ; j < N ; j++){

                if(visited[i] && visited[j]){
                    startTeam += team[i][j] + team[j][i];
                } else if(!visited[i] && !visited[j]){
                    linkTeam += team[i][j] + team[j][i];
                } // if - else

            } // for

        } // for
        int diff = Math.abs(startTeam - linkTeam);
        minDiff = Math.min(minDiff, diff);
    }

}
