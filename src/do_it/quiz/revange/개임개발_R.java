package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 개임개발_R {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 건물의 종류 수
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        } // for

        // 진입차수
        int[] inDegree = new int[N + 1];
        // 건물이 지어지는 시간
        int[] buildTime = new int[N + 1];

        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 건물이 지어지는 시간
            int weight = Integer.parseInt(st.nextToken());

            // 건물이 지어지는 시간 할당
            buildTime[i] = weight;

            while(true){
                // 선행 건물
                int prevBuild = Integer.parseInt(st.nextToken());

                // 선행 건물이 없을 경우 종료
                if(prevBuild == -1 ) break;

                // 선행 건물이 있을 경우 대상 건물의 진입 차수 증가
                inDegree[i]++;

                // 배럭 -> 팩토리 구조라면 팩토리가 (i)임
                graph.get(prevBuild).add(i);
            } // while

        }// for


        Deque<Integer> queue = new ArrayDeque<>();
        // 진입 차수가 0인 값은 초기 위상 정렬 값 추가
        for(int i = 1; i <= N ; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            } // if
        } // for

        // 1. 총 소요 시간을 저장할 배열 추가
        int[] result = new int[N + 1];
        for(int i = 1; i <= N; i++){
            // 초기값은 자기 자신의 건물 짓는 시간
            result[i] = buildTime[i];
        } // for

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int next : graph.get(current)){
                // 2. 동시 건축 처리 (더 오래 걸리는 선행 건물의 시간으로 업데이트!)
                // result[current] = 현재까지의 총 누적 소요 시간
                result[next] = Math.max(result[next], result[current] + buildTime[next]);

                inDegree[next]--;
                if(inDegree[next] == 0){
                    queue.offer(next);
                } // if
            } // for
        } // while

        // 3. 1번 건물부터 N번 건물까지 순서대로 정답 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(result[i]).append("\n");
        } // for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}
