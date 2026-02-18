package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE_R {
    static boolean isOk = false;
    static final int GAOL_LINK_COUNT = 4;
    static boolean[] visited;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사람의 수 0 ~ (N -1)
        int N = Integer.parseInt(st.nextToken());
        // 관계의 수
        int M = Integer.parseInt(st.nextToken());

        // graph init
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            graph.add(new ArrayList<>());
        } // for

        // 방문 배열
        visited = new boolean[N];

        // connected link
        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int o1 = Integer.parseInt(st.nextToken());
            int o2 = Integer.parseInt(st.nextToken());
            graph.get(o1).add(o2);
            graph.get(o2).add(o1);
        }// for

        for(int i = 0 ; i < N ; i++){
            if(isOk) break;
            if(!visited[i]){
                dfs(graph, 0, i);
            } // if
        } // for

        bw.write(isOk ? "1" : "0");
        bw.flush();
        bw.close();

    }

    private static void dfs(List<List<Integer>> graph, int depth, int node){
        if(isOk) return;
        if(depth == GAOL_LINK_COUNT){
            isOk = true;
            return;
        } // if

        // 방문 처리
        visited[node] = true;

        for(int next : graph.get(node)){
            if(!visited[next]){
                dfs(graph,depth + 1, next);
            } // if
        } // for

        // 방문 해제 처리
        visited[node] = false;
    }
}
