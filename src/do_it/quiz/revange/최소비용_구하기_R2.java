package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 최소비용_구하기_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시 번호 (1 ~ N)
        int N = Integer.parseInt(br.readLine());
        // 버스 운행 수
        int M = Integer.parseInt(br.readLine());

        // 거리 최대 값 init
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // graph init
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++) graph.add(new ArrayList<>());
        for(int i = 0 ; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        } // for

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 시작 도시
        int startCity = Integer.parseInt(st.nextToken());
        // 도착 도시
        int endCity = Integer.parseInt(st.nextToken());

        distance[startCity] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작점은 비용 및 총 소모 비용은 0
        pq.offer(new Node(startCity, 0 ));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int now = current.node;
            int nowTotalCost = current.cost;

            // 🌟 핵심
            // 큐에서 꺼낸 누적 비용이 이미 기록된 최저 비용보다 비싸다?
            // = 볼 가치도 없는 옛날 정보(뒷북)이므로 버림! (이게 없으면 메모리 터짐)
            if(nowTotalCost > distance[now]) continue;

            for(Node next : graph.get(now)){

                // (지금까지 쓴 총액) + (다음 도시로 가는 통행료)
                int nextTotalCost = nowTotalCost + next.cost;

                // 🌟 다음 노드의 비용을 비교하여 진행
                if(distance[next.node] > nextTotalCost){
                    // 최저가 갱신!
                    distance[next.node] = nextTotalCost;
                    pq.offer(new Node(next.node, nextTotalCost)); // 큐에 '새로운 누적 비용'으로 탑승!
                } // if
            } // while

        } // while

        bw.write(String.valueOf(distance[endCity]));
        bw.flush();
        bw.close();
    }

    private static class Node implements Comparable<Node>{
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
