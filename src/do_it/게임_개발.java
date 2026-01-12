package do_it;

import java.io.*;
import java.util.*;

public class 게임_개발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 건물의 종류
        int N = Integer.parseInt(br.readLine());

        // graph init
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++) graph.add(new ArrayList<>());

        // 진입 차수 배열
        int[] inDegree = new int[N + 1];
        // 자기 자신을 짓는데 걸리는 시간
        int[] selfBuild = new int[N + 1];

        // 건물을 짓는데 걸리는 시간과 그 건물을 짓기 위해 먼저 지어져야 하는 건물들의 번호
        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 자기 자신 생산 속도 - 각각 배열 [인뎃스 + 1]이 의미하는건 건물 번호 였다..
            selfBuild[i] = Integer.parseInt(st.nextToken());

            // 뒤에 이어지는 선행 건물 저장 "-1"이 나올 때 까지
            while(true){
                int preBuildNum = Integer.parseInt(st.nextToken());
                if(preBuildNum == -1) break;

                // 선행 빌딩은 현재 건물 을 가르킴
                graph.get(preBuildNum).add(i);
                // 진입 차수 저장
                inDegree[i]++;
            }// while
        } // for

        // 위상 정렬
        Queue<Integer> queue = new ArrayDeque<>();
        // 진입 차수가 0인 애들 큐에 저장
        for(int i = 1; i <= N ;i++){
            if(inDegree[i] == 0) queue.offer(i);
        }//for

        // 각 건물이 지어지는데 소요 되는 시간
        int[] result = new int[N + 1];

        while(!queue.isEmpty()){

            int now = queue.poll();

            for(int next : graph.get(now)){
                // 인접 리스트에 연결된 진입 차수 --
                inDegree[next]--;

                // 건물 소요 시간 계산 후 주입 ?? 이건 모르겠다 ..
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);

                if(inDegree[next] == 0){
                    queue.offer(next);
                } // if
            } // for

        } // while

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ;i++){
            // ?? 왜 더해주지??
            sb.append(result[i] + selfBuild[i]).append("\n");
        }//for

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
