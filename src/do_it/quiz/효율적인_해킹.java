package do_it.quiz;

import java.io.*;
import java.util.*;

public class 효율적인_해킹 {
    // 신뢰를 하는 PC의 개수 카운팅
    static int[] linkCounts;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 컴퓨터 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 연결 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // distance init
        linkCounts = new int[N + 1];

        // graph init
        List<Integer>[] graph = new ArrayList[N+1];
        for(int i = 0 ; i <= N ;i++) graph[i] = new ArrayList<>();
        for(int i = 0 ; i < M ;i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(stringTokenizer.nextToken());
            int E = Integer.parseInt(stringTokenizer.nextToken());
            //graph[S].add(E);
            graph[E].add(S);
        } // for

        int maxCount = Integer.MIN_VALUE;

        visited = new boolean[N + 1];
        // 모든 PC 기준으로 검사하여 신뢰를 가장 많이 받는 PC를 카운팅
        for(int i = 1 ; i <= N ;i++){
            // 초기화
            Arrays.fill(visited,false);
            int pcLinkCount = bfs(graph, i);
            maxCount = Math.max(maxCount, pcLinkCount);
            linkCounts[i] = pcLinkCount;
        } // for

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (maxCount == linkCounts[i]) sb.append(i).append(" ");
        } // for
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    public static int bfs(List<Integer>[] graph, int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        int result = 1;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    // 나를 신뢰하는 PC가 있는거이므로 카우늩
                    result++;
                } // if
            } // for
        } // while

        return result;
    }

}
