package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 특정_거리의_도시_찾기_R {
    static List<List<Integer>> graph;
    // 이동 거리 (-1로 초기화 하여 이동하지 않음 방문여부 체크)
    static int[] distance;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // city count
        int N = Integer.parseInt(st.nextToken());
        // load count (List count)
        int M = Integer.parseInt(st.nextToken());
        // target load size
        K = Integer.parseInt(st.nextToken());
        // start city
        int X = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        // -1 로 초기화
        Arrays.fill(distance, -1);

        // 단방향 graph init
        graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        } // for

        // load init
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        } // for

        bfs(X);

        // K 와 거리가 같은 도시가 있는지 확인
        boolean isHasLengthK = false;

        StringBuilder sb = new StringBuilder();
        // 거리가 K 와 같은 것이 있는지 체크
        for(int i = 1; i <= N ; i++){
            if(K == distance[i]){
                // 거리가 같은 것이 있으므로 true
                isHasLengthK = true;
                sb.append(i).append("\n");
            }//
        } // for

        // 없을 경우 -1 출력
        if(isHasLengthK){
            bw.write(sb.toString());
        } else {
            bw.write("-1");
        } // if -else

        bw.flush();
        br.close();
        bw.close();

    }

    public static void bfs(int start){
        Deque<Integer> queue = new ArrayDeque<>();
        // 초기 자기 자신 거리는 0 (문제 전재 조건)
        distance[start] = 0;
        queue.offer(start);

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph.get(current)){
                // 방문한 적이 없을 경우
                if(distance[next] == -1){
                    // 덮어 씌우는 방식 사용 += 를 사용하면 갚을 절대 구할 수 없다 '-1'가 존재 함
                    distance[next] = distance[current] +  1;
                    queue.offer(next);
                } // if
            } // for
        } // while
    }
}
