package do_it.quiz;

import java.io.*;
import java.util.*;

public class 이분_그래프 {
    static int[] colors;
    // 이분 그래프 여부 판단 플래그
    static boolean isBipartite;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 개수
        int K = Integer.parseInt(br.readLine());

        // 테스트 케이스 만큼 loop
        for(int i = 0 ; i < K ; i++){
            // 정점 간선 개수를 받음
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            // 정점 개수
            int V = Integer.parseInt(stringTokenizer.nextToken());
            // 간선 개수
            int E = Integer.parseInt(stringTokenizer.nextToken());
            // graph init
            List<Integer>[] graph = new ArrayList[V + 1];
            for(int j = 0 ; j <= V ; j++) graph[j] = new ArrayList<>();
            for(int j = 0 ; j < E ; j++){
                stringTokenizer = new StringTokenizer(br.readLine());
                // 시작 노드
                int start = Integer.parseInt(stringTokenizer.nextToken());
                // 끝 노드
                int end = Integer.parseInt(stringTokenizer.nextToken());
                // "두 정점이 연결되어 있다"로 되어있기에 무방향 그래프임
                graph[start].add(end);
                graph[end].add(start);
            } // for
            // 이분 그래프 확인 배열 (0 : 색을 칠하지 않음, 1 : 붉은색, 2 : 푸른색)
            colors = new int[V + 1];

            // ✅ 그래프가 쪼개져 있을 경우를 생각해야 함 따라서 모든 노드 체크
            isBipartite = true; // 노드가 하나일 때는 이분 그래프임
            for(int j = 1; j <= V; j++) {
                if(colors[j] == 0) { // 방문하지 않은 노드라면 탐색 시작
                    if(!bfs(graph, j)) {
                        isBipartite = false;
                        break;
                    } // if
                }// if
            } // for

            // 이분 그래프 flag를 기준으로 처리함
            bw.write(isBipartite ? "YES" : "NO");
            bw.newLine();

        } // for

        bw.flush();
        bw.close();
    }

    public static boolean bfs(List<Integer>[] graph, int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        // 시작점은 1번 색(빨강)으로 칠함
        colors[start] = 1;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph[current]){
                // 색이 칠해져 있지 않을 경우에만 확인
                if(colors[next] == 0){
                    colors[next] = (colors[current] == 1) ? 2 : 1;
                    queue.offer(next);
                } else{
                    if( colors[next] == colors[current] ) return false;
                } // if - else
            } // for
        }// while
        return true;
    }

}
