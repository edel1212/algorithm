package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 이분_그래프_R {
    // 0 : 미방문 | 1 : 파랑 | 2 : 빨강
    static int[] color;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // count
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        // loop
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int link = Integer.parseInt(st.nextToken());
            // graph init
            graph = new ArrayList<>();
            for(int j = 0 ; j <= node; j++) graph.add(new ArrayList<>());

            // color init
            color = new int[node + 1];

            // make graph
            for(int j = 0 ; j < link; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end);
                // 양방향 그래프임
                graph.get(end).add(start);
            } // for

            boolean isBipartite = true;

            for(int idx = 1; idx <= node ; idx++){
                // 아직 한번도 방문한적 없는 노드 일경우
                if(color[idx] == 0){
                    isBipartite = bfs(idx);
                    if(!isBipartite) break;
                } // if
            } // for

            sb.append(isBipartite ? "YES" : "NO").append("\n");
        } // for

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    private static boolean bfs(int node){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        // 파랑
        color[node] = 1;

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int next : graph.get(current)){
                int nextColor = color[next];

                // 한번도 방문한적 없는 노드일 경우
                if(nextColor == 0){
                    // 반대의 색을 저장
                    color[next] = color[current] == 1 ? 2 : 1;
                    queue.offer(next);
                } else { // 방문 경험이 있을 경우

                    // 노드가 서로 같은 색일 경우
                    if(color[next] == color[current]) {
                        return false;
                    } // if
                } // if - els e
            } // for

        } // while

        // 이상이 없을 경우 이분 그래프임
        return true;
    }
}
