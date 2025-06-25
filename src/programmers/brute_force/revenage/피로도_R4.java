package programmers.brute_force.revenage;

public class 피로도_R4 {
    boolean[] visited;
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0,k, dungeons);
        return answer;
    }

    public void dfs(int clearCount, int stress, int[][] dungeons ){
        for(int i = 0 ; i < dungeons.length; i++){
            if( !visited[i] && dungeons[i][0]  <= stress ){
                visited[i] = true;
                dfs(clearCount + 1, stress - dungeons[i][1], dungeons );
                visited[i] = false;
            } // if
        } // for

        answer = Math.max(answer, clearCount);
    }
}
