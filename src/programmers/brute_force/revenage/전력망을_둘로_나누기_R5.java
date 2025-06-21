package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기_R5 {
    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0 ; i < wires.length; i ++){

            List<List<Integer>> graph = new ArrayList<>();
            for(int j = 0 ; j <= n ; j++) graph.add(new ArrayList<>());

            for(int j = 0 ; j < wires.length; j++){
                if( i == j ) continue;
                int tower1 = wires[j][0];
                int tower2 = wires[j][1];
                graph.get(tower1).add(tower2);
                graph.get(tower2).add(tower1);
            } // for

            int diff = bfs(1, n , graph);
            int absTownCount = Math.abs( ( n - diff ) - diff );
            minDiff = Math.min(absTownCount, minDiff);
        } // for

        return minDiff;
    }

    public int bfs(int start , int n , List<List<Integer>> graph ){
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while(!queue.isEmpty()){
            int current  = queue.poll();
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
