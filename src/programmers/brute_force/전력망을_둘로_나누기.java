package programmers.brute_force;

import java.util.ArrayList;
import java.util.List;

public class 전력망을_둘로_나누기 {

    /**
     * goal : 하나의 연결을 끊어서 가장 비슷한 전력망 나누기
     *
     * */
    public int solution(int n, int[][] wires) {
        // 두 전력망의 송전탑 개수 차이의 최소값을 구해야 하기에 최대 값으로 init
        int minDiff = Integer.MAX_VALUE;

        // 전선의 개수 만큼 loop
        for( int i = 0; i < wires.length; i++ ){

            // 그래프 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            // i번째 wire를 제외하고 그래프 구성
            for( int j = 0 ; j < wires.length; j++ ){
                // 해당 조건문은 전선을 끊었을 경우를 의미
                if( i == j ) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            } // for

            boolean[] visited = new boolean[n + 1];

            // 한 쪽 네트워크의 송전탑 개수 구하기
            int count = dfs(1, graph, visited);

            // 두 네트워크의 송전탑 개수 차이 계산
            int diff = Math.abs(n - count - count);
            minDiff = Math.min(minDiff, diff);

        } // for

        return minDiff;
    }

    private int dfs(int node, List<List<Integer>> graph, boolean[] visited ){
        visited[node] = true;
        int count = 1;

        for(int neighbor : graph.get(node)){
            if( !visited[neighbor] ) count += dfs(neighbor, graph, visited);
        } // for

        return count ;
    }


}
