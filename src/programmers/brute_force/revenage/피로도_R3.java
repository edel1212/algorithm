package programmers.brute_force.revenage;

public class 피로도_R3 {

    boolean[] visited;
    int count;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        bfs(0,k, dungeons);

        return count;
    }

    public void bfs( int dept, int k, int[][] dungeons ){
        for( int i = 0 ; i < dungeons.length; i++ ){
            if( dungeons[i][0]  <= k ){
                if(!visited[i]){
                    visited[i] = true;
                    bfs( dept +1, k - dungeons[i][1], dungeons );
                    visited[i] = false;
                } // if
            }
        } //for

        count = Math.max(dept, count);
    }

}
