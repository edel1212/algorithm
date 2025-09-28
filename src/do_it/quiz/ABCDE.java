package do_it.quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {

    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        // 노드의 개수
        int N = Integer.parseInt(tokenizer.nextToken());
        // 간선의 개수
        int M = Integer.parseInt(tokenizer.nextToken());

        // 무방향 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();;
        // graph init - 0부터 시작히가에 조건식은 아래와 같이 진행
        for(int i = 0 ; i < N ; i++) graph.add(new ArrayList<>());

        // 그래프 데이터 주입
        for(int i = 0 ; i < M ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int o1 = Integer.parseInt(tokenizer.nextToken());
            int o2 = Integer.parseInt(tokenizer.nextToken());
            graph.get(o1).add(o2);
            graph.get(o2).add(o1);
        } // for

        // 방문 배열
        visited = new boolean[N];

        for(int i = 0 ; i < N ; i++){
            dfs(i, graph, 1);
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void dfs(int start, List<List<Integer>> graph, int depth){
        if(result == 1) return;
        visited[start] = true;
        if(depth > 5) return;
        if(depth == 5){
            result = 1;
            return;
        }// if

        for(int next : graph.get(start)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next, graph, depth + 1);
                visited[next] = false;
            }
        } // for
        visited[start] = false;
    }

}
