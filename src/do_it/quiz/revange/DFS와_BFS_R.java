package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class DFS와_BFS_R {
    static List<List<Integer>> graph = new ArrayList<>();
    static Integer N;
    static Integer M;
    static BufferedWriter bw;

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 노드의 개수
        N = Integer.parseInt(stringTokenizer.nextToken());
        // 간선의 개수
        M = Integer.parseInt(stringTokenizer.nextToken());
        visited = new boolean[N+1];
        // 탐색 시작 노드
        int V = Integer.parseInt(stringTokenizer.nextToken());

        // graph init
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        } // for
        for(int i = 0 ; i < M ;i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int o1 = Integer.parseInt(stringTokenizer.nextToken());
            int o2 = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(o1).add(o2);
            graph.get(o2).add(o1);
        } // for
        // 정렬 [정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문]
        for(List<Integer> i : graph )i.sort(Comparator.naturalOrder());

        dfs(V);
        bw.newLine();
        bfs(V);

        bw.flush();
        bw.close();
    }

    public static void dfs(int node) throws IOException{
        visited[node] = true;
        bw.write(node + " ");
        for(int next : graph.get(node)){
            if(!visited[next]){
                dfs(next);
            } // if
        } // for
    }

    public static void bfs(int node) throws IOException{
        boolean[] v = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        v[node] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            bw.write(current + " ");
            for(int next : graph.get(current)){
                if(!v[next]){
                    v[next] = true;
                    queue.offer(next);
                } // if
            } // for
        } // while
    }
}
