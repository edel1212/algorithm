package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소_스패닝_트리 {

    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // Node Count ( 1 ~ N );
        int N = Integer.parseInt(st.nextToken());
        // Edge Count
        int M = Integer.parseInt(st.nextToken());

        // graph init
        Edge[] graph = new Edge[M];
        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // add edge data
            graph[i] = new Edge(s,e,w);
        } // for

        // 가중치 기준 오름차순 정렬
        Arrays.sort(graph);

        // union find에 사용될 상위 노드 배열 선언
        parent = new int[N + 1];
        for(int i = 0 ; i <= N ; i++){
            parent[i] = i;
        }// for

        int result = 0;      // 가중치의 합 (최소 비용)
        int edgeCount = 0;   // 연결된 간선의 개수

        // 모든 간선의 횟수만큼 Loop
        for(int i = 0; i < M ; i++){
            Edge current = graph[i];
            int endNode = current.endNode;
            int startNode = current.startNode;

            if(find(startNode) != find(endNode)){
                // 연결
                union(startNode, endNode);
                result += current.weight;

                // 연결되지 않은 것을 연결 하였으므로 카운트 추가
                edgeCount++;

                // MST는 간선이 N-1개 모이면 완성되므로 조기 종료 (성능 최적화)
                if (edgeCount == N - 1) break;
            } //if


        } //for


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // recursive method
    public static int find(int i){
        if(parent[i] == i) return i;
        // ✅ 반환시 그냥 find(i)로 하면 안된다. 자기 자신을 한번도 찾은 값으로 주입해야한다 당연한 것 이였던것 ..
        return parent[i] = find(parent[i]);
    }

    public static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        // 이미 같은 집합이면(대표 노드가 같으면) 연결하지 않음 -> false 반환
        if (rootA == rootB) return false;

        // 값이 다를 때 union
        if(rootA != rootB){
            // ✅ 대표끼리 합쳐줘야한다  ( ❌ parent[a] = rootB )
            parent[rootA] = rootB;
        } // if

        return true;
    }


    public static class Edge implements Comparable<Edge>{
        int startNode;
        int endNode;
        int weight;
        public Edge(int startNode, int endNode, int weight){
            this.startNode = startNode;
            this.endNode = endNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            // 가중치 기준 오름차순 정렬
            return Integer.compare(this.weight, o.weight);
        }
    }
}
