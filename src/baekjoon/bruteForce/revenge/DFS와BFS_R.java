package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class DFS와BFS_R {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");
            // 정점의 개수
            int N = Integer.parseInt(strToken.nextToken());
            // 간선의 개수
            int S = Integer.parseInt(strToken.nextToken());
            // 탐색을 시작할 번호
            int V = Integer.parseInt(strToken.nextToken());

            // graph init
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0 ; i <= N; i++) graph.add(new ArrayList<>());

            for(int i = 0 ; i < S; i++){
                StringTokenizer line = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(line.nextToken());
                int b = Integer.parseInt(line.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            } // for

            // 👍 DFS, BFS에서 정렬하지 말고 여기서 미리 정렬을 해주자
            for(int i = 0 ; i <= N; i++) Collections.sort(graph.get(i));

            // DFS
            boolean[] visited = new boolean[N+1];
            dfs(V, visited, graph, bw);
            bw.newLine();
            // BFS
            bfs(V,N, graph, bw);
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void dfs(int node, boolean[] visited ,List<List<Integer>> graph, BufferedWriter bw) throws Exception{
        bw.write(node + " ");
        visited[node] = true;
        // ☠️ 성능상 해당 방법 보다는 main Method 내에서 미리 정렬하고 진행하는것이 훨씬 효율적임
        graph.get(node).sort(Comparator.naturalOrder());
        for(int next : graph.get(node) ){
            if(!visited[next]){
                visited[next] = true;
                dfs(next, visited, graph, bw);
            } // if
        } // for
    }

    public static void bfs(int start, int N,List<List<Integer>> graph, BufferedWriter bw)throws Exception{
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            bw.write(current + " ");
            // ☠️ 성능상 해당 방법 보다는 main Method 내에서 미리 정렬하고 진행하는것이 훨씬 효율적임
            graph.get(current).sort(Comparator.naturalOrder());

            for(int next : graph.get(current) ){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                } // if
            } // for
        } // while
    }
}
