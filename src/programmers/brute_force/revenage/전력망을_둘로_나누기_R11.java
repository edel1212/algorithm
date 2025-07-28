package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기_R11 {
    public static void main(String[] args) {
        int n = 7;
        int[][] wires = {
                {1, 2},
                {2, 7},
                {3, 7},
                {3, 4},
                {4, 5},
                {6, 7}
        };
        new 전력망을_둘로_나누기_R11().solution(n, wires);
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        // 송전탑이어진 graph 형태의 배열을 초기화 및 준비
        // 각각의 경우가 같을 경우를 끊어줌
        // 값을 확인하여 진행
        for(int i = 0 ; i < wires.length ; i++){
            List<List<Integer>> graph = new ArrayList<>();
            // 송전탑은 1번부터 시작하기에 1로 초기화
            for(int j = 0 ; j <= n ; j++) graph.add(new ArrayList<>());

            for(int j = 0 ; j < wires.length; j++){
                // 전선을 끊음 - 배열을 스킵함
                if(i == j) continue;
                int tower1 = wires[j][0];
                int tower2 = wires[j][1];
                graph.get(tower1).add(tower2);
                graph.get(tower2).add(tower1);
            } // for

            int cutTower = bfs(1,n, graph);
            int diff = Math.abs ( n - 2 * cutTower );
            answer = Math.min(diff, answer);

        }// for
        return answer;
    }

    public static int bfs(int start,int n, List<List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[n + 1];
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

    public static int dfs(int node,boolean[] visited, List<List<Integer>> graph){
        int count = 1;
        visited[node] = true;
        for(int next : graph.get(node)){
            if(!visited[next]){
                visited[next] = true;
                count += dfs(next, visited, graph);
            } // if
        } // for
        return  count;
    }
}
