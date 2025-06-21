package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.List;

public class 전력망을_둘로_나누기_R6 {

    public static void main(String[] args) {
        전력망을_둘로_나누기_R6 solution = new 전력망을_둘로_나누기_R6();

        int n = 7;
        int[][] wires = {
                {1, 2},
                {2, 7},
                {3, 7},
                {3, 4},
                {4, 5},
                {6, 7}
        };

        int result = solution.solution(n, wires);
        System.out.println("최소 송전탑 차이: " + result);
    }

    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0 ; i < wires.length; i++){
            List<List<Integer>> graph = new ArrayList<>();
            for(int j = 0; j <= n ; j++) graph.add(new ArrayList<>());

            for( int j = 0 ; j < wires.length; j++ ){
                if( i == j ) continue;
                int tower1 = wires[j][0];
                int tower2 = wires[j][1];
                graph.get(tower1).add(tower2);
                graph.get(tower2).add(tower1);
            } // for

            // DFS로 한 쪽 송전탑 개수 계산
            boolean[] visited = new boolean[n + 1];
            int count = dfs(1, graph, visited);

            // 두 전력망 차이 계산 및 최솟값 갱신
            int diff = Math.abs((n - count) - count);
            minDiff = Math.min(minDiff, diff);
        }// for

        return minDiff;
    }

    public int dfs(int node, List<List<Integer>> graph, boolean[] visited){
        visited[node] = true;
        int count = 1;

        for(int next : graph.get(node)){
            if( !visited[next] ) count += dfs( next, graph, visited );
        } // for

        return count;
    }

}
