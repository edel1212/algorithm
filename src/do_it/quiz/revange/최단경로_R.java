package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 최단경로_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0 ; i <= V ; i++) graph.add(new ArrayList<>());

        // target
        int K = Integer.parseInt(br.readLine());

        int[] D = new int[V + 1];
        Arrays.fill(D, Integer.MAX_VALUE);
        D[K] = 0;

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        } // for

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, D[K]));

        boolean[] visited = new boolean[V + 1];

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Node c = pq.poll();

            if(visited[c.n]) continue;
            visited[c.n] = true;

            for(Node next : graph.get(c.n)){
                if( D[next.n] > D[c.n] + next.w ){
                    D[next.n] = D[c.n] + next.w;
                    pq.offer(new Node(next.n, D[next.n]));
                } // if
            } // for

        }// while

        for(int i = 1; i <= V ; i++){
            if(D[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
                continue;
            } // if
            sb.append(D[i]).append("\n");
        }// for


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static class Node implements Comparable<Node>{
        public int n;
        public int w;
        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
