package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 최소비용_구하기_R {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ;i++) graph.add(new ArrayList<>());

        for(int i = 0 ; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            graph.get(S).add(new Node(E, W));
        } //for


        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[N + 1];

        // 다익스트라
        PriorityQueue<Node> pq= new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.node]) continue;
            visited[now.node] = true;

            for(Node next : graph.get(now.node)){
                dist[next.node] = Math.min(dist[next.node], dist[now.node] + next.weight);

                pq.offer(new Node(next.node, dist[now.node] + next.weight));
            } // for
        } // while


        bw.write(String.valueOf(dist[end]));
        bw.flush();
        bw.close();
    }

    public static class Node implements Comparable<Node> {
        int node;
        int weight;
        public Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
