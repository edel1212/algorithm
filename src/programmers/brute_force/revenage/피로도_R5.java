package programmers.brute_force.revenage;

public class 피로도_R5 {
    boolean[] visited;
    int result = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return result;
    }

    public void dfs(int clearCount, int stress, int[][] dungeons){

        for(int i = 0 ; i < dungeons.length; i++){
            // 해당 던전을 방문하지 않았으며, 최소 피로도가 허용 범위 내
            if(!visited[i] && dungeons[i][0] <= stress ){
                visited[i] = true;
                dfs(clearCount + 1,stress - dungeons[i][1], dungeons );
                visited[i] = false;
            } //if
        } // for
        result = Math.max(result, clearCount);
    }
}
