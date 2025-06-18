package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기_R2 {
    List<List<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] wires) {

        // 비교를 위함
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0 ; i < wires.length; i++){
            // 그래프로 사용될 Array 생성
            List<List<Integer>> graph = new ArrayList<>();
            // 그래프 생성 노드의 개수 만큼 추가인데 "<=" 조건인 이유는 노드의 시작이 1부터 이기 떄문임 ( 0번은 생성은 하지만 사용 하지 않음 )
            for(int j = 0 ; j <= n ; j++)  graph.add(new ArrayList<>());

            for(int j = 0; j < wires.length ; j++){
                if (i == j) continue; // 해당 부분이 중간에 전선을 끊는 로직
                int firstNode  = wires[j][0];
                int secondNode = wires[j][1];
                // 인접한 연관 관계를 그래프로 만듬
                graph.get(firstNode).add(secondNode);
                graph.get(secondNode).add(firstNode);
            } // for

            int count = bfs(1, n, graph);
            // 두 전력망의 송전탑 수의 차이를 구하기 위함 ( 오른쪽 송전탑, 왼쪽 송전탑 )
            int diff = Math.abs((n - count) - count);
            // 가장 차이가 적은 것을 구함
            minDiff = Math.min(minDiff, diff);
        } // for

        return minDiff;
    }

    private int bfs(int start, int n, List<List<Integer>> graph){
        boolean[] visited = new boolean[n+1];
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        // 첫번째 노드 추가
        queue.offer(start);
        // 첫번째 노드 방문 구분 변경
        visited[start] = true;

        int count = 1;

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
