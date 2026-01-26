package do_it.quiz;

import java.io.*;
import java.util.*;

public class 트리의_부모_찾기 {
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // tree graph - 양방향
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++) graph.add(new ArrayList<>());

        // ✅ 간선의 개수는 N- 1개 이다, "트리" 니깐!!!!
        for(int i = 0 ; i < N - 1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            // 양방향 저장
            graph.get(S).add(E);
            graph.get(E).add(S);
        } //for

        result = new int[N + 1];
        visited = new boolean[N + 1];

        // BFS
        bfs(1, graph);

        StringBuilder sb = new StringBuilder();
        for(int i =2 ; i<= N ;i++){
            sb.append(result[i]).append("\n");
        } // for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int start, List<List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph.get(current)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    result[next] = current;
                } //if
            } // for
        } // while
    }
}
