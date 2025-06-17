package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기_R {
    public int solution(int n, int[][] wires) {
        // 비교를 하기 위한 최대 값을 할당
        int minDiff = Integer.MAX_VALUE;

        // 전선의 개수만큼 loop
        for(int i = 0 ; i < wires.length; i++){
            List<List<Integer>> graph = new ArrayList<>();
            // ?? 왜 하는지 모르겠고 j <= n 까지일까 왜?
            for(int j = 0 ; j <= n ; j++) graph.add(new ArrayList<>());

            // 이건 왜 loop 하고 이건 또 왜 wires.length 까지 할까
            for(int j = 0; j < wires.length; j++){
                // 해당 continue 이유는 ??
                if (i == j) continue;
                // a, b 의도 값을 알 수 없음
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            } // for

            // BFS로 한 컴포넌트 크기 구하기
            int count = bfs(1, n, graph);
            int diff = Math.abs((n - count) - count);
            minDiff = Math.min(minDiff, diff);
        } // for

        return minDiff;
    }

    private int bfs(int start, int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }

        return count;
    }
}
