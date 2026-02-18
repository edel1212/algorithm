package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_R {
    static boolean arrive = false;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사람의 수 0 ~ (N -1)
        int N = Integer.parseInt(st.nextToken());
        // 관계의 수
        int M = Integer.parseInt(st.nextToken());

        // graph init
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        } // for

        // 방문 배열
        visited = new boolean[N];

        // connected link
        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }// for

        for(int i = 0 ; i < N ; i++){
            // depth 1부터 시작
            dfs(i, 1);

            // 재귀 호출 후 찾았으면 찾기위해 호출 전이 아닌 호출 후에 체크
            if(arrive) break;
        } // for

        bw.write(arrive ? "1" : "0");
        bw.flush();
        bw.close();

    }

    private static void dfs(int node, int depth){

        // [기저 조건] 깊이가 5가 되면 성공
        if (depth == 5) {
            arrive = true;
            return;
        } // if

        // 방문 처리
        visited[node] = true;

        for(int next : graph[node]){
            if(!visited[next]){
                // recursive
                dfs(next,depth + 1);
                // 재귀에서 돌아왔는데 정답을 찾았으면 성능 향상을 위해 종료
                if (arrive) return;
            } // if
        } // for

        // 방문 해제 처리
        visited[node] = false;
    }
}
