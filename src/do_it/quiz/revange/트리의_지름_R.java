package do_it.quiz.revange;

import java.io.*;
import java.util.*;

/**
 * 5
 * 1 3 2 -1
 * 2 4 4 -1
 * 3 1 2 4 3 -1
 * 4 2 4 3 3 5 6 -1
 * 5 4 6 -1
 */
public class 트리의_지름_R {
    static int N;
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        // graph init
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        } // for

        // add graph data
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int targetNode = Integer.parseInt(st.nextToken());
            while(true){
                // 정점 번호
                int n = Integer.parseInt(st.nextToken());
                // -1 일 경우 종료
                if(n == -1) break;
                // 정점까지의 거리
                int w = Integer.parseInt(st.nextToken());
                graph.get(targetNode).add(new Node(n,w));
            } // while
        } // for

        // 기준이 될 노드
        int baseNode = bfs(1, true);

        // 끝 노드 기반으로 지름을 구함
        int result = bfs(baseNode,false);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int bfs(int startNode, boolean isGetNode){
        boolean[] visited = new boolean[N + 1];
        Queue<Node> queue = new ArrayDeque<>();
        visited[startNode] = true;
        queue.offer(new Node(startNode, 0));

        // 가장 먼 노드의 번호
        int farthestNode = startNode;
        // 가장 먼 거리 (이전 코드의 totalLength를 대체)
        int maxDistance = 0;

        while(!queue.isEmpty()){
            Node current = queue.poll();

            // ✅ 가장 마지막에 queue에 존재하는 노드 및 거리가 아닌 현재 값 기준으로 찾아야한다.
            if(current.w > maxDistance) {
                maxDistance = current.w;    // 최고 거리 갱신
                farthestNode = current.n;   // 그때의 노드 번호 갱신
            } // if

            for(Node next : graph.get(current.n)){
                int nextNode = next.n;
                int weight = next.w;
                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    // 이전 노드에서 현재 노드까지의 이동 거리
                    int totalDistance = current.w + weight;
                    // 큐에 주입
                    queue.offer(new Node(nextNode, totalDistance));
                } // if
            } // for
        } // while

        if(isGetNode){
            return farthestNode;
        } // if
        return maxDistance;
    }

    private static class Node{
        // 노드 번혼
        int n;
        // 길이
        int w;
        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }
    }
}
