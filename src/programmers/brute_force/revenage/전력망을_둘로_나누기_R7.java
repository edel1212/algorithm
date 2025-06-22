package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기_R7 {

    public static void main2(String[] args) {
        전력망을_둘로_나누기_R7 solution = new 전력망을_둘로_나누기_R7();

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

        for(int i = 0 ; i < wires.length; i ++){
            // 송전탑별 연결 된 송전탑 정보를 저장할 graph
            List<List<Integer>> graph = new ArrayList<>();
            for(int j = 0; j < n+1; j++ ) graph.add(new ArrayList<>());

            for(int j = 0; j < wires.length; j++){
                // 모든 순차별로 전력망을 끊음
                if( i == j ) continue;
                int tower1 = wires[j][0];
                int tower2 = wires[j][1];
                graph.get(tower1).add(tower2);
                graph.get(tower2).add(tower1);
            } // for

            int count = bfs(1,n, graph);

            int diffCount = Math.abs( (n - count) - count );

            diffMin = Math.min(diffMin, diffCount);
        } // for

        return diffMin;
    }

    public int bfs(int start, int n, List<List<Integer>> graph){
        // +1의 이유는 송전탑이 1부터 시작하기 때문임 "0은 사용X"
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;
        // 너비 탐색 시작
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

    public static void main(String[] args) {
        int n = 2;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        // 양방향 연결
        graph.get(1).add(2);
        graph.get(2).add(1);

        boolean[] visited = new boolean[n + 1];
        int count = dfs(1, visited, graph);
        System.out.println("Count: " + count);
    }

    public static int dfs(int node, boolean[] visited, List<List<Integer>> graph){
        int count  = 1;
        // 해당 부분에서 방문 괸련 확인 해야함
        visited[node] = true;

        for( int next : graph.get(node) ){
            if(!visited[node]){
                count += dfs( next, visited,graph );
            } // if
        } // for

        return count;
    }

}
