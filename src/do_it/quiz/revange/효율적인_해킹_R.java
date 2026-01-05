package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 효율적인_해킹_R {
    static boolean[] visited;
    static int[] hackingCounts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 컴퓨터 대수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 연결 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // graph init
        List<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 0 ; i <= N ; i++) graph[i] = new ArrayList<>();
        for(int i = 0 ; i < M ; i ++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(stringTokenizer.nextToken());
            int E = Integer.parseInt(stringTokenizer.nextToken());
            // E를 신용하면 S를 해킹할 수 있기 때문임
            //graph[E].add(S);
            graph[S].add(E);
        } // for

        // visited init
        visited = new boolean[N + 1];
        // hacking counts
        hackingCounts = new int[N + 1];

        // 최대 해킹 카운트가 같은 경우를 확인할 최대 해킹 카운트
        int maxHackingCount = Integer.MIN_VALUE;
        // 모든 컴퓨터를 확인
        for(int i = 1; i <= N ; i++){
            // visited 초기화
            Arrays.fill(visited, false);
            int hackingCount = bfs(graph, i);
            // 최대 해킹 횟수 확인
            maxHackingCount = Math.max(maxHackingCount, hackingCount);
            // 해당 PC의 해킹 카운트 확인
            hackingCounts[i] = hackingCount;
        } // for

        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i <= N ; i++){
            if(maxHackingCount == hackingCounts[i]) sb.append(i + " ");
        } // for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    public static int bfs(List<Integer>[] graph, int start){
        // 해킹한 PC 수 (처음 start 1대)
        int result = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    result++;
                } // if
            } // for
        } // while

        return result;
    }

}
