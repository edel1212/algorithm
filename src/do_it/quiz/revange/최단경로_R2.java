package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 최단경로_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수 ( 1 ~ V )
        int V = Integer.parseInt(st.nextToken());
        // 간선의 개수
        int E = Integer.parseInt(st.nextToken());
        // 정점의 시작 번호
        int T = Integer.parseInt(br.readLine());

        // graph init
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0 ; i <= V ; i++) graph.add(new ArrayList<>());

        // 최대 값으로 거리 초기화
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node( end , weight ));
        } // for

        // 그래프의 정잠 시작 번호 0으로 거리 초기화
        distance[T] = 0;

        // 일반 큐가 아닌 우선순위 큐를 사용해서 가중치가 낮은 것 부터 찾음
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(T, 0));


        while(!pq.isEmpty()){
            Node current = pq.poll();
            // 현재 노드
            int currNode = current.to;
            // 현재 거리
            int currDist = current.weight;
            // 이미 현재 거리가 이미 최단 거리일 경우 제외
            if(  distance[currNode] < currDist  ) continue;

            for(Node next : graph.get(current.to)){
                // 현재노드 ~ 다음 노드 까지의 거리
                int newDist = current.weight + next.weight;
                // 현재까지의 거리가 최단 거리일 경우
                if( newDist < distance[next.to]){
                    // 다음 노드 최단거리 저장
                    distance[next.to] = newDist;
                    // 우선순위 큐 저장
                    pq.offer(new Node( next.to, newDist ));
                } // if

            } // for
        } // while

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V ; i++){
            int val = distance[i];
            sb.append( val == Integer.MAX_VALUE ? "INF" : String.valueOf(val) ).append("\n");
        } // for

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    private static class Node implements Comparable<Node>{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
