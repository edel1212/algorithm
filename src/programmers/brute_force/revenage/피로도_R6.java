package programmers.brute_force.revenage;

public class 피로도_R6 {
    int answer = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        dfs(0,k, new boolean[dungeons.length], dungeons);
        return answer;
    }

    public void dfs(int depth, int k, boolean[] visited, int[][] dungeons){
        for(int i = 0 ; i < dungeons.length ; i++){
            if(dungeons[i][0] <= k && !visited[i]){
                visited[i] = true;
                dfs(depth + 1 , k - dungeons[i][1], visited, dungeons);
                visited[i] = false;
            } // for
        } // for
        answer = Math.max(answer, depth);
    }
}
