package do_it.quiz;

import java.io.*;
import java.util.*;

public class 최소비용_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시의 개수 ( 1 ~ N)
        int N = Integer.parseInt(br.readLine());
        // 버스의 개수
        int M = Integer.parseInt(br.readLine());

        // graph init
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++) graph.add(new ArrayList<>());

        // 최단 거리를 저장할 배열
        int[] D = new int[N + 1];
        Arrays.fill(D,Integer.MAX_VALUE);

        // graph data init
        for(int i = 0 ; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 시작 버스
            int S = Integer.parseInt(st.nextToken());
            // 도착 버스
            int E = Integer.parseInt(st.nextToken());
            // 비용
            int cost = Integer.parseInt(st.nextToken());

            // graph data init
            graph.get(S).add(new Node(E, cost));
        } // for

        // 찾고자 하는 버스 정보
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 시작 버스
        int S = Integer.parseInt(st.nextToken());
        // 도착 버스
        int E = Integer.parseInt(st.nextToken());

        // 최단 거리 init
        D[S] = 0;
        // 방문 배열
        boolean[] visited = new boolean[N + 1];

        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.offer(new Node(S, D[S]));


        while(!heap.isEmpty()){

            Node current = heap.poll();

            if(visited[current.bus]) continue;
            visited[current.bus] = true;

            for(Node next : graph.get(current.bus)){

                // "지금 찾은 길이 기존 길보다 더 빠를 때만!" PQ에 저장!!(메모리 최적화)
                if(D[next.bus] > D[current.bus] + next.cost ){

                    // 비교 대상은 다음 최단거리 , 현재 버스 + 가는데 가중치
                    D[next.bus] = D[current.bus] + next.cost;

                    // 누적 총 비용을 넣어야함 (목적지 경유지가 있는데 다 합쳐서 정산해야지!)
                    heap.offer(new Node(next.bus, D[next.bus]));

                }// if

            } // for
        } // while

        bw.write(String.valueOf(D[E]));
        bw.flush();
        bw.close();
    }


    public static class Node implements Comparable<Node>{
        public int bus;
        public int cost;

        public Node(int bus, int cost){
            this.bus = bus;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            // 비용이 낮은순으로 오름차순 정렬
            return this.cost - o.cost;
        }
    }
}
