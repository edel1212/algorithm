package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기_R4 {
    public int solution(int n, int[][] wires) {
        // 비교를 위한 최대 값 할당
        int diffMin = Integer.MIN_VALUE;

        // 전선의 정보 만큼 Loop
        for(int i = 0 ; i < wires.length; i ++){

            // 인접한 값들을 저장해 놓을 배열
            List<List<Integer>> graph = new ArrayList<>();
            // 그래프 초기화 1부터 시작히기에 Index 추가를 위한 "<=" 조건 사용
            for( int j = 0 ; j <= n ; j++ )  graph.add(new ArrayList<>());

            for(int j = 0 ; j < wires.length; j++){
                // 전선을 하나 끊는 로직
                if( i == j ) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            } // for

            int count = bfs(1, n, graph);

            int diff = Math.abs( (n - count) - count );

            diffMin = Math.min(diffMin, diff);

        }  // for

        return diffMin;
    }


    public int bfs(int start, int n,  List<List<Integer>> graph){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int cnt  = 1;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph.get(current)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    cnt++;
                } // if
            }
        } // while

        return cnt;
    }

}
