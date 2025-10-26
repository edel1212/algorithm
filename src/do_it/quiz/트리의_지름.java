package do_it.quiz;

import java.io.*;
import java.util.*;

public class 트리의_지름 {
    static List<List<Node>> graph;
    static boolean[] visited;
    // 거리를 담을 배열
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정점의 개수 ( 1 ~ V)
        int V = Integer.parseInt(br.readLine());

        // 연결 그래프 생성
        graph = new ArrayList<>();
        for(int i = 0 ; i <= V ; i++) graph.add(new ArrayList<>());
        for(int i = 0 ; i < V ; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            // 도착지가 "-1" 이 나올때 까지 True
            while(true){
                int to = Integer.parseInt(stringTokenizer.nextToken());
                if(to == -1) break;
                int weigh = Integer.parseInt(stringTokenizer.nextToken());
                graph.get(from).add(new Node(to, weigh));
            } // while
        } // for

        // 임의의 거리에서 구한 최대거리를 구함 ( 해당 거리가 지름의 한쪽 기준아 됨 )
        int farthestFromStart = bfs(1, true);
        // 가장 먼 거리(B)
        int diameter = bfs(farthestFromStart, false);

        bw.write(String.valueOf(diameter));
        bw.flush();
        bw.close();

    }


    /**
     *
     * @param start the 시작 node 값
     * @param isReturnFarthestNode 가장 먼 노드 번호 반환 여부
     * @return int
     */
    public static int bfs(int start , boolean isReturnFarthestNode){
        // 방문 여부
        visited = new boolean[graph.size()];
        // 노드별 거리를 담을 배열
        distance = new int[graph.size()];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            // 탐색할 노드 현재 노드 값
            int current = queue.poll();
            for(Node nextNode : graph.get(current)){
                if(!visited[nextNode.vertex]){
                    visited[nextNode.vertex] = true;
                    // 노드별 거리(가중치) 저장 (현재 탐색 노드까지 거리 + 다음 노드 거리)
                    distance[nextNode.vertex] = distance[current] + nextNode.weight;
                    queue.offer(nextNode.vertex);
                } // if
            }// for
        } // while


        // 가장 먼 노드 번호(정점)
        int farthestNode = start;
        // 가장 먼 거리
        int maxDistance = 0;

        // 모든 정점을 확인하며 가장 넓었던 거리를 찾음
        for (int i = 1; i < graph.size(); i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                farthestNode = i;
            } // if
        }

        return isReturnFarthestNode ? farthestNode :maxDistance ;
    }


    public static class Node{
        // 정점
        int vertex;
        // 가중지
        int weight;
        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return "vertex : " + vertex + " ---- " + "weight : " + weight;
        }
    }
}
