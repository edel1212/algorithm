package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class DFS와BFS {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            // 정점의 개수
            int N = Integer.parseInt(stringTokenizer.nextToken());
            // 간선의 개수
            int M = Integer.parseInt(stringTokenizer.nextToken());
            // 탐색 시작 번호
            int V = Integer.parseInt(stringTokenizer.nextToken());

            // 정점과 간선의 데이터를 기반으로 graph를 생성함
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0 ; i <= N; i++ ) graph.add(new ArrayList<>());
            for(int i = 0; i < M ; i++){
                stringTokenizer = new StringTokenizer(br.readLine() , " ");
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            } //for

            // 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문 해당 문구로 인해 정렬이 필요함
            for (int i = 1; i <= N; i++) Collections.sort(graph.get(i));

            boolean[] visited = new boolean[N+1];
            // dfs 내 출력
            dfs(V, graph, visited, bw);
            bw.newLine();
            // bfs 내 출력
            bfs(V, graph, N,bw);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited,BufferedWriter bw) throws Exception{
        visited[node] = true;
        bw.write(node + " ");
        for(int next : graph.get(node)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next, graph, visited, bw);
            } // if
        } // for
    }

    public static void bfs(int start, List<List<Integer>> graph, int N,BufferedWriter bw) throws Exception{
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            bw.write(current + " ");
            for(int next : graph.get(current)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                } // if
            } // for
        } // while
    }

}
