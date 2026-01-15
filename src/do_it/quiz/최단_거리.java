package do_it.quiz;

import java.io.*;
import java.util.*;

public class 최단_거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // Node Count
        int V = Integer.parseInt(st.nextToken());
        // Edge Count
        int E = Integer.parseInt(st.nextToken());
        // Start Node
        int K = Integer.parseInt(br.readLine());

        // Sort Distance
        int[] D = new int[V + 1];
        // fill to maximum value
        Arrays.fill(D, Integer.MAX_VALUE);
        // set to start node value
        D[K] = 0;

        // init graph
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= V ; i++ ) graph.add(new ArrayList<>());
        // make graph - range is E
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            // start node
            int u = Integer.parseInt(st.nextToken());
            // end node
            int v = Integer.parseInt(st.nextToken());
            // weight
            int w = Integer.parseInt(st.nextToken());

            // add graph data
            graph.get(u).add(new Node(v, w));
        } // for

        // visit array
        boolean[] visited = new boolean[V + 1];

        // 우선순위 큐를 사용하면 쉽게 D의 가장 작은 값을 찾을 수 있음!!
        PriorityQueue<Node> queue = new PriorityQueue<>();
        // add start Node
        queue.offer(new Node(K, D[K]));

        while(!queue.isEmpty()){
            Node current = queue.poll();

            // 방문한 적이 있다면 스킵
            if(visited[current.node]) continue;
            // 방문 처리
            visited[current.node] = true;

            for(Node next : graph.get(current.node)){
                int min = Math.min(D[current.node] + next.weight, D[next.node]);
                D[next.node] = min;
                // add next Node
                queue.offer(new Node(next.node, min));
            } // for
        } // while

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= V ; i++){
            // not found short distance
            if(D[i] == Integer.MAX_VALUE){
                sb.append("INF\n");
                continue;
            } //if
            // append short distance
            sb.append(D[i]);
            sb.append("\n");
        } // fo

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static class Node implements Comparable<Node>{
        int node;
        int weight;
        public Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            // 오름 차순 정렬
            return this.weight - o.weight;
        }
    }

}

