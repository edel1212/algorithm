package programmers.brute_force.revenage;

public class 피로도_R2{
    int answer = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        bfs(0, k, dungeons);
        return answer;
    }

    public void bfs(int dept, int stress, int[][] dungeons){
        for( int i = 0 ; i < dungeons.length; i++ ){
            if(!visited[i] && dungeons[i][0] <= stress ){
                visited[i] = true;
                bfs(dept + 1, stress - dungeons[i][1], dungeons);
                visited[i] = false;
            }// if
        } // for
        answer = Math.max(answer, dept);
    }
}
