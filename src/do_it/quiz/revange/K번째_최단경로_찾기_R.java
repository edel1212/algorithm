package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class K번째_최단경로_찾기_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시
        int N = Integer.parseInt(st.nextToken());
        // 도로 수
        int M = Integer.parseInt(st.nextToken());
        // 원하는 K 번째 도로 수
        int K = Integer.parseInt(st.nextToken());

        // graph init
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++) graph.add(new ArrayList<>());
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Node(B, C));
        } // for

        // 각 도시별 최단 거리 init
        PriorityQueue<Integer>[] allCityDistance = new PriorityQueue[N + 1];
        // 내림차순으로 정렬하는 이유는 뒤에서 부터 삭제해야 앞의 순번 데이터를 유실하지 않고 보유 할 수 있기 때문임
        for(int i = 0 ; i <= N ; i++) allCityDistance[i] = new PriorityQueue<>(Comparator.reverseOrder());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 다익스트리 알고리즘 init
        pq.offer(new Node(1, 0));
        allCityDistance[1].offer(0);

        while(!pq.isEmpty()){

            Node current = pq.poll();

            for(Node next : graph.get(current.node)){

                // 다음 까지 가는 비용
                int nextCost = current.weight + next.weight;

                // 진행하고자 하는 길이 탐색된게 적다면
                if(allCityDistance[next.node].size() < K){
                    // 최단 거리 값 갱신
                    allCityDistance[next.node].add(nextCost);

                    // 우선 순위 큐 추가
                    pq.offer(new Node(next.node, nextCost));

                } else if(allCityDistance[next.node].peek() > nextCost){ // 신규 갱신 값이 있다면 업데이트
                    // 늦은값 제거
                    allCityDistance[next.node].poll();
                    // 최단 거리 값 갱신
                    allCityDistance[next.node].add(nextCost);

                    // 우선 순위 큐 추가
                    pq.offer(new Node(next.node, nextCost));
                } // if else

            } // for

        }// while
        StringBuilder sb = new StringBuilder();

        // 결과값 출력
        for(int i = 1; i<= N ; i++){
            // K번째 최단 거리를 찾았을 경우
            if(allCityDistance[i].size() == K){
                // PriorityQueue 의 가장 앞에 있는 값이 찾고자하는 K번째 최단 거리임
                sb.append(allCityDistance[i].peek()).append("\n");
                continue;
            }// if
            sb.append("-1").append("\n");
        }// for


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();



    }

    // allCityDistance를 어떻게 초기화 할지 기억해내지 못함... (MAX값을 넣어줄 필요가 없어)
    // allCityDistance는 Node로 할 필요가 없어 그냥 각 도시별 최단 거리만 우선순위 큐 형식으로 저장하면 되는거야
    public static class Node implements Comparable<Node>{
        int node;
        int weight;
        public Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            // 가중치 오름 차순
            return Integer.compare(this.weight, o.weight);
        }
    }
}
