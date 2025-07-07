package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.List;

public class 전력망을_둘로_나누기_R10 {
    public int solution(int n, int[][] wires) {
        int diffMin = Integer.MAX_VALUE;

        for(int i = 0 ; i < wires.length; i++){
            List<List<Integer>> graph = new ArrayList<>();
            for(int j = 0 ; j <= n; j++) graph.add(new ArrayList<>());

            for(int j = 0 ; j < wires.length; j++){
                if( i == j ) continue;
                int tower1 = wires[j][0];
                int tower2 = wires[j][1];
                graph.get(tower1).add(tower2);
                graph.get(tower2).add(tower1);
            }// for

            boolean[] visited = new boolean[n+1];
            int dfsCount = dfs(wires[i][0], visited, graph); // 수정
            int abs = Math.abs( (n - dfsCount) - dfsCount );
            diffMin = Math.min(abs, diffMin);
        } // for

        return diffMin;
    }

    public int dfs(int node, boolean[] visited ,List<List<Integer>> graph){
        visited[node] = true;
        int count = 1;
        for(int next : graph.get(node)){
            if(!visited[next]){
                count += dfs(next, visited, graph);
            } // if
        } // for
        return count;
    }// for
}
