package do_it.quiz.revange;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소_스패닝_트리_R {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        // 노드 개수
        int V = Integer.parseInt(st.nextToken());
        // 간선 개수
        int E = Integer.parseInt(st.nextToken());

        parents = new int[V+1];
        for(int i = 0 ; i <= V; i++){
            parents[i] = i;
        } // for

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(s,e,w));
        } // for

        long result = 0;
        int edgeCount = 0;
        while(!pq.isEmpty()){
            Edge current = pq.poll();
            if( find(current.s) != find(current.e) ){
                union(current.s, current.e);
                result += current.w;
                edgeCount++;
                if(edgeCount == V -1) break;
            } // if
        } // while

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    // recursive function
    public static int find(int i){
        if(parents[i] == i) return i;
        return parents[i] = find(parents[i]);
    }

    public static void union(int a , int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parents[rootA] = rootB;
        } // if
    }

    public static class Edge implements  Comparable<Edge>{
        int s;
        int e;
        int w;
        public Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

}
