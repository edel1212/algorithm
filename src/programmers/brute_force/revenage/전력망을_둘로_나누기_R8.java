package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기_R8 {
    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0 ; i < wires.length; i++){
            List<List<Integer>> graph = new ArrayList<>();
            for( int j = 0 ; j < n + 1 ; j++ ) graph.add(new ArrayList<>());

            // 모든 경우의 수 사용해서 graph를 만듬
            for( int j = 0 ; j < wires.length; j++ ){
                if( i == j ) continue;
                int tower1 = wires[j][0];
                int tower2 = wires[j][1];
                // 서로 연관된 애들끼리 모아 줌
                graph.get(tower1).add(tower2);
                graph.get(tower2).add(tower1);
            } // for

            int count = bfs(1, n, graph);
            int diffAbs = Math.abs( (n - count) - count );

            minDiff = Math.min(minDiff, diffAbs);

        } // for

        return minDiff;
    }

    public int bfs(int start ,int n, List<List<Integer>> graph){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int next : graph.get(current)){
                if( !visited[next] ){
                    visited[next] = true;
                    count++;
                    queue.offer(next);
                } // if
            } // for

        } // while

        return count;
    }


    public int dfs(int node, boolean[] visited, List<List<Integer>> graph){
        int count = 1;
        visited[node] = true;
        for( int next : graph.get(node) ){
            if( !visited[next] )  count += dfs(next, visited, graph);
        } // for

        return count;
    }
}
