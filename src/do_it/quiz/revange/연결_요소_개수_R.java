package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연결_요소_개수_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());

        // node count
        int N = Integer.parseInt(token.nextToken());
        // edge count
        int M = Integer.parseInt(token.nextToken());

        // graph init
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++) graph.add(new ArrayList<>());

        // make direction
        for(int i = 0 ; i < M ; i++){
            token = new StringTokenizer(br.readLine());
            int o1 = Integer.parseInt(token.nextToken());
            int o2 = Integer.parseInt(token.nextToken());
            graph.get(o1).add(o2);
            graph.get(o2).add(o1);
        } // for

        // visit arr
        boolean[] visited = new boolean[N+1];

        int linkedNodeCount = 0;

        // every node search
        for(int i = 1 ; i <= N ; i++){
            if(!visited[i]){
                dfs(i,visited, graph);
                linkedNodeCount++;
            } // if
        } // for

        bw.write(String.valueOf(linkedNodeCount));
        bw.flush();
        bw.close();

    }

    public static void dfs(int start, boolean[] visited, List<List<Integer>> graph){
        visited[start] = true;   // 방문 처리
        for(int next : graph.get(start)){
            if(!visited[next]){
                dfs(next, visited, graph);
            } // if
        } // for
    }
}
