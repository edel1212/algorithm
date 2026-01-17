package do_it.quiz;

import java.io.*;
import java.util.*;

public class K번째_최단경로_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시 수
        int N = Integer.parseInt(st.nextToken());
        // 도시간 존재하는 도로
        int M = Integer.parseInt(st.nextToken());
        // 찾고자 하는 K번째 최단 경로
        int K = Integer.parseInt(st.nextToken());

        // graph init
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++) graph.add(new ArrayList<>());
        // graph data insert
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            // 인접 리스트 insert
            graph.get(S).add(new Node(E, W));
        } // for

        // 최단 거리를 저장할 heap ( 우리는 각 도시마다 **"가장 짧은 경로 K개"**를 저장하고 싶기에 모든 경우의 수 경로를 저장하기 위함 )
        PriorityQueue<Integer>[] allCityDisHeap = new PriorityQueue[N + 1];

        for(int i = 0 ; i <= N ; i++){
            // 내림차순 이유 ( 계속 값이 들어오니 순서를 유지하기 위함 오름 차순을 할 경우 비교할 ✅앞에 값이 유실됨 )
            // 각 모든 지정된 도시들의 최단 거리를 저장함
            allCityDisHeap[i] = new PriorityQueue<>(K, Collections.reverseOrder());
        } // for

        // 다익스트라용 큐 (여기는 오름차순 - 가장 빠른 경로 부터 처리)
        PriorityQueue<Node> pq = new PriorityQueue<>();

        /***
         * 해당 부분이 기존 다익스트라와 다른 부분임 원래는 우선 순위가 0이거나 원하는 도시를 지정해서 넣으나
         * 해당 문제에서는 모든 경로의 최단 거리를 확인 후 K 번째를 필터링 하기 위해서 1번 부터 시작함
         * - 방문 배열또한 사용하지 않음
         */
        // 시작점 초기화 - 첫번째 도시를 기준으로 시작함 (당연히 가중치는 0)
        pq.offer(new Node(1,0));
        // 최단 거리 배열 또한 시작점(거리 0) 등록!
        allCityDisHeap[1].offer(0);

        // 다익스트라 진행
        while(!pq.isEmpty()){
            Node current = pq.poll();

            // 일반 다익스트라와 달리 visited 체크를 하지 않음
            // - K 번째 경로까지 전부 찾아야 하기 떄문 (여러번 같은 노드를 체크함)
            for(Node next : graph.get(current.node)){

                // 다음 도시로 가는 비용 (현재 거리 비용 + 다음 거리 비용)
                int nextCost = current.cost + next.cost;

                // 전체 모든 건물을 확인하려면 1 ~ N 까지 loop 해야하는거 아니야 ??
                if(allCityDisHeap[next.node].size() < K){
                    // 해당 도시의 최단 거리 저장
                    allCityDisHeap[next.node].add(nextCost);

                    // heap 추가
                    pq.offer(new Node( next.node, nextCost ));
                } else if ( allCityDisHeap[next.node].peek() > nextCost ){ // K개가 꽉 차있으나 더 느린게 있다면 제거 후 신규 값 추가
                    // 제거
                    allCityDisHeap[next.node].poll();
                    // 신규 값 추가
                    allCityDisHeap[next.node].add(nextCost);

                    // heap 추가
                    pq.offer(new Node( next.node, nextCost ));
                } // if - else

            } // for

        } // while

        StringBuilder sb = new StringBuilder();

        // 결과값 출력
        for(int i = 1; i<= N ; i++){
            // K번째 최단 거리를 찾았을 경우
            if(allCityDisHeap[i].size() == K){
                // PriorityQueue 의 가장 앞에 있는 값이 찾고자하는 K번째 최단 거리임
                sb.append(allCityDisHeap[i].peek()).append("\n");
                continue;
            }// if
            sb.append("-1").append("\n");
        }// for


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Node implements Comparable<Node>{
        int node;
        int cost;
        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            // 가중치에 맞게 오름차순 정렬
            return Integer.compare(this.cost, o.cost);
        }
    }

}



