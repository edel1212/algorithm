package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 타임머신_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // city count
        int N = Integer.parseInt(st.nextToken());
        // bus count
        int M = Integer.parseInt(st.nextToken());

        // 최단 거리를 저장할 배열
        long[] distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;

        // 간선 정보를 갖는 graph
        List<Edge> graph = new ArrayList<>();
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            // 간선 데이터 insert
            graph.add(new Edge(start, end ,time));
        } // for

        // 간선 최대 개수만큼 Loop
        for(int i = 0 ; i < N - 1; i++){
            for(int j = 0 ; j < M ; j++){
                Edge next = graph.get(j);
                if( distance[next.startNode] != Long.MAX_VALUE
                        && distance[next.endNode] > distance[next.startNode] + next.time ){
                    distance[next.endNode] = distance[next.startNode] + next.time;
                } // if
            } // for
        } // for

        boolean hasINFCycle = false;

        for(int j = 0 ; j < M ; j++){
            Edge next = graph.get(j);
            if( distance[next.startNode] != Long.MAX_VALUE
                    && distance[next.endNode] > distance[next.startNode] + next.time ){
                hasINFCycle = true;
                break;
            } // if
        } // for

        StringBuilder sb = new StringBuilder();
        if(hasINFCycle){
            sb.append("-1");
        } else {
            for(int i = 2 ; i <= N ; i++){
                if(distance[i] == Long.MAX_VALUE){
                    sb.append("-1").append("\n");
                    continue;
                }// if
                sb.append(distance[i]).append("\n");
            } // for
        }// if - else

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 간선 정보를 저장할 Class
    public static class Edge{
        public int startNode;
        public int endNode;
        public int time;

        public Edge(int startNode, int endNode , int time){
            this.startNode = startNode;
            this.endNode = endNode;
            this.time = time;
        }

    }

}
