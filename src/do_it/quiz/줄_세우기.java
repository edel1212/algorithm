package do_it.quiz;

import java.io.*;
import java.util.*;

public class 줄_세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 학생의 수
        int N = Integer.parseInt(st.nextToken());
        // 키 비교 횟수
        int M = Integer.parseInt(st.nextToken());

        // 인접 그래프 init
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++) graph.add(new ArrayList<>());

        // 진입 차수 배열 생성 ( 위상 정렬 핵심 )
        int[] inDegree = new int[N + 1];

        // 인접행렬 저장 + 진입 차수 정보 주입
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            // 시작 노드
            int S = Integer.parseInt(st.nextToken());
            // 끝노드
            int E = Integer.parseInt(st.nextToken());

            // 그래프 저장
            graph.get(S).add(E);
            // 진입 차수 저장
            inDegree[E]++;

        } // for

        // 위상 정렬 수행
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= N ; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            } // if
        }// for

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now + " ");

            // 그래프의 다음 값 확인
            for(int next : graph.get(now)){
                // 값 감소
                inDegree[next]--;
                // 0일 경우 정렬 계산 대상 추가
                if(inDegree[next] == 0){
                    queue.offer(next);
                } // if
            }// for
        } // WHILE

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
