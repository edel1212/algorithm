package do_it.quiz;

import java.io.*;
import java.util.*;

public class 특정_거리의_도시_찾기 {
    public static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 노드의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 간선의 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());
        // 찾고자하는 최단거리
        int K = Integer.parseInt(stringTokenizer.nextToken());
        // 시작 노드
        int X = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 0 ;i <= N ; i++) graph[i] = new ArrayList<>();

        for(int i = 0 ; i < M ; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
            // 단방향 그래프임
            graph[s].add(e);
        } //for

        bfs(graph,N,K,X);

        if(result.isEmpty()){
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        }  // if

        for(int i : result){
            bw.write(String.valueOf(i));
            bw.newLine();
        }// for
        bw.flush();
        bw.close();
    }

    public static void bfs(List<Integer>[] graph, int N, int K, int X){
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 거리
        int[] distance = new int[N + 1];
        // 초기 값을 -1로 지정 ( 방문한 적이 없다면  -1 )
        Arrays.fill(distance, -1);

        // 초기 방문 값 init
        queue.offer(X);
        // 시작점의 거리를 0으로 지정
        distance[X] = 0;

        while(!queue.isEmpty()){
            int current = queue.poll();

            // 현재 저장되어 있는 거리가 K 보다 크면 탐색 X (탐색 최적화)
            if(distance[current] > K) break;

            for(int next : graph[current]){
                // 방문하지 않았던 노드라면
                if(distance[next] == -1){
                    // 다음 방향이 이동 거리 저장 ( 현위치와 다음 갈 위치가 연결 되어 있단 의미니깐!! )
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                } // if
            } // for
        } // while

        for(int i = 1 ; i <= N ;i++){
            // 지정 도시까지의 거리가 K와 같을 경우 도시 저장
            if(distance[i] == K) result.add(i);
        } // for

    }

}
