package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 효율적인_해킹_R2 {
    static boolean[] visited;
    static int N;
    // 시간 초과 문제로 인한 graph 구조
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // pc number (1 ~ N)
        N = Integer.parseInt(st.nextToken());
        // link count
        int M = Integer.parseInt(st.nextToken());

        // visited init
        visited = new boolean[N + 1];

        // graph init
        graph = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }// for

        // add link A -> B
        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // A -> B 신용하기에 B를 읽으면 A를 해킹 할 수 있도록 해야함
            graph[B].add(A);
        } // for

        // 각 PC 별 해킹 값을 저장할 배열
        int[] hackingCountArray = new int[N+1];
        // 최대 해킹 카운트
        int MAX_HACKING_COUNT = Integer.MIN_VALUE;

        // DFS Search
        for(int i = 1 ; i <= N ; i++ ){
            // 방문 배열 초기화
            Arrays.fill(visited, false);
            int hackingCount = bfs(i);

            hackingCountArray[i] = hackingCount;
            MAX_HACKING_COUNT = Math.max(MAX_HACKING_COUNT, hackingCount);
        } // for

        StringBuilder sb = new StringBuilder();
        for(int idx  = 1 ; idx <= N ; idx++){
            if(hackingCountArray[idx] == MAX_HACKING_COUNT){
                sb.append(idx).append(" ");
            } // if
        } // for

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    // ❌ 사용 시 시간초과
    private static int dfs(int node){
        visited[node] = true;
        int count = 1;
        for(int next : graph[node]){
            if(!visited[next]){
                count += dfs(next);
            } // if
        } //for
        return count;
    }

    // 👌 해당 방식 사용 필요
    private static int bfs(int node){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;
        int hackingCount = 1;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    hackingCount++;
                }// if
            } // for
        } //while
        return hackingCount;
    }
}
