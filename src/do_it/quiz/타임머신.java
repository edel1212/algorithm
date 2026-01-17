package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 타임머신 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시의 개수
        int N = Integer.parseInt(st.nextToken());
        // 운행 버스
        int M = Integer.parseInt(st.nextToken());

        // 엣지 배열 - 간선의 개수 만큼 선언 (간선 개수 만큼 선언 N - 1)
        Edge[] edges = new Edge[M];

        for(int i = 0 ;i < M ; i++){
            st = new StringTokenizer(br.readLine());
            // 출발지
            int A = Integer.parseInt(st.nextToken());
            // 도착지
            int B = Integer.parseInt(st.nextToken());
            // 소요 시간
            int C = Integer.parseInt(st.nextToken());
            // 엣지 배열 inset
            edges[i] = new Edge(A, B, C);
        } // for

        // 최단 거리 저장 배열
        long[] distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        // 벨만-포드 알고리즘 수행
        distance[1] = 0; // 1번 도시 소요 시간 0 초

        // 노드 개수 - 1개 만큼 반복(간선의 최대 개수임)
        for(int i = 0 ; i < N - 1; i++ ){
            // 저장된 간선을 가져옴 - 모든 간선을 체크함
            for(int j = 0; j < M ; j++){
                // 현재 탐색할 간선
                Edge edge = edges[j];
                // 업데이트 조건
                // 값이 무한이 아니면서, 신규 값이 최단 거리보다 작을 경우
                if(distance[edge.start] != Long.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time ){
                    // 업데이트
                    distance[edge.end] = distance[edge.start] + edge.time;
                } // if
            } // for
        } // for

        boolean hasCycle = false;

        // 음수 사이클 확인 - 값이 업데이트 할 수 있다면 음수 또는 0이 있다는 것임
        for(int i = 0 ; i < M ;i++){
            Edge edge = edges[i];
            if(distance[edge.start] != Long.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time ){
                hasCycle = true;
            } // if
        } // for

        StringBuilder sb = new StringBuilder();

        if(hasCycle){  // 음수 사이클이 있을 경우
            bw.write("-1");
        } else {
            // 2부터 시작 이유는 문제에 "출발 도시를 제외한"이라는 전제 조건이 있음
            for (int i = 2; i <= N; i++) {
                if(distance[i] == Long.MAX_VALUE){
                    sb.append("-1").append("\n");
                    continue;
                }// if
                sb.append(distance[i]).append("\n");
            } // for
        } // if - else

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static class Edge{
        int start;
        int end;
        int time;
        public Edge(int start ,int end, int time){
            this.start = start;
            this.end = end;
            this.time = time;
        }

    }

}
