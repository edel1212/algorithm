package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연결_요소의_개수_R2 {
    private static boolean[] visited;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // node (1 ~ N)
        int N = Integer.parseInt(st.nextToken());
        // edge count
        int M = Integer.parseInt(st.nextToken());

        // graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        } // for

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int o1 = Integer.parseInt(st.nextToken());
            int o2 = Integer.parseInt(st.nextToken());
            graph.get(o1).add(o2);
            graph.get(o2).add(o1);
        } // for

        // 방문 확인
        visited = new boolean[N + 1];

        int connectedComponent = 0;
        for(int i = 1 ; i <= N ; i++){
            // 방문한적이 없어야 시작 노드로지정
            if(!visited[i]){
                dfs(graph, i);
                // 연결 요소 카운트
                connectedComponent++;
            } // if
        } // for

        bw.write(String.valueOf(connectedComponent));
        bw.flush();
        bw.close();
    }

    private static void dfs(List<List<Integer>> graph, int node){
        // 들어오자마자 체크! "이렇게 구현 하는 편이 코드의 가독성이 높음" (함수가 자기 할 일을 완벽하게 책임지는 구조)
        // - 망문처리를 하는 부분이 2군대로 쪼개져 있으면 좋지 못함
        visited[node] = true;
        for(int next : graph.get(node)){
            // 하위 노드는 여기서 한번더 체크 함
            if(!visited[next]){
                dfs(graph, next);
            } // if
        } // for
    }
}
