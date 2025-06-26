package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기_R9 {

    public static void main(String[] args) {
        전력망을_둘로_나누기_R9 solution = new 전력망을_둘로_나누기_R9();

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
    }

    public int solution(int n, int[][] wires) {

        int diffMin = Integer.MAX_VALUE;

        for(int i = 0; i < wires.length; i++){
            List<List<Integer>> graph = new ArrayList<>();
            for(int j = 0; j <= n ; j++ ) graph.add(new ArrayList<>());

            for(int j = 0 ; j < wires.length; j++){
                // 전선을 끊을 경우
                if( i == j ) continue;
                int tower1 = wires[j][0];
                int tower2 = wires[j][1];
                // 서로 교차하며 주입하여 인접 송전탑읍 주입
                graph.get(tower1).add(tower2);
                graph.get(tower2).add(tower1);
            } // for

            int dffCount = bfs(1, n, graph);
            int abs = Math.abs( (n - dffCount) - dffCount);
            diffMin = Math.min(abs, diffMin);
        } // for

        return diffMin;
    }

    private int bfs(int node, int n, List<List<Integer>> graph){
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        int count     = 1;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph.get(current)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                } // if
            } // for
        } // while

        return count;
    }
}
