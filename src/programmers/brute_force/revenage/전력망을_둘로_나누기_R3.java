package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기_R3 {
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {
                {1, 3}, {2, 3}, {3, 4}, {4, 5},
                {4, 6}, {4, 7}, {7, 8}, {7, 9}
        };

        전력망을_둘로_나누기_R3 solver = new 전력망을_둘로_나누기_R3();
        int result = solver.solution(n, wires);
        System.out.println("최소 차이: " + result);  // 기대값: 3
    }

    public int solution(int n, int[][] wires) {
        // 값 비교를 위한 변수
        int minDiff  = Integer.MIN_VALUE;

        for(int i = 0 ; i < wires.length; i++){

            // graph init 1부터 시작
            List<List<Integer>> graph = new ArrayList<>();
            for(int j = 0 ; j <= n ;j ++) graph.add(new ArrayList<>());

            for(int j = 0 ; j < wires.length; j++){
                // continue의 역할은 선을 끊는 것
                if ( i == j ) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                // 인접한 번호를 배열에 추가
                graph.get(a).add(b);
                graph.get(b).add(a);
            } // for

            int count = bfs(1, n, graph);
            // 두 송전탑의 차이의 수를 절대값으로 가져오는 것
            int diff = Math.abs((n - count) - count);
            minDiff = Math.min(minDiff, diff);

        } // for

        return minDiff;
    }

    public int bfs(int start, int n, List<List<Integer>> graph){
        // n + 1 이유는 1부터 시작하기 때문임
        boolean[] visited = new boolean[n + 1];
        // bfs를 사용가이 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        // 시작 값 주입
        queue.offer(start);
        // 첫번 째 방문
        visited[start] = true;
        // 첫번째 시작으로 인한 count 1
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
