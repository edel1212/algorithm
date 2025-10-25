package do_it.quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의_지름 {
    static List<List<Node>> graph;
    static boolean[] visited;
    // 거리를 담을 배열
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정점의 개수 ( 1 ~ V)
        int V = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i = 0 ; i <= V ; i++) graph.add(new ArrayList<>());
        for(int i = 0 ; i < V ; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            // 도착지가 "-1" 이 나올때 까지 True
            while(true){
                int to = Integer.parseInt(stringTokenizer.nextToken());
                if(to == -1) break;
                int weigh = Integer.parseInt(stringTokenizer.nextToken());
                graph.get(from).add(new Node(to, weigh));
            } // while
        } // for

        System.out.println(graph);

    }

    static class Node{
        // 정점
        int vertex;
        // 가중지
        int weight;
        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return "vertex : " + vertex + " ---- " + "weight : " + weight;
        }
    }
}
