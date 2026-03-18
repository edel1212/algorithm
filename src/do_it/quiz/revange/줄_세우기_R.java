package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 줄_세우기_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 학생의 수
        int N = Integer.parseInt(st.nextToken());
        // 키 비교 횟수
        int M = Integer.parseInt(st.nextToken());

        // 사이클이 없는 인접 배열 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i <= N; i ++) graph.add(new ArrayList<>());

        // 진입 차수 배열 생성
        int[] inDegree = new int[N + 1];

        // 인접 배열 및 진입차수 값 저장
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            // 시작 노드
            int start = Integer.parseInt(st.nextToken());
            // 끝노드
            int end = Integer.parseInt(st.nextToken());

            // 사이클이 없도록 저정
            graph.get(start).add(end);
            // 진입차수 저장
            inDegree[end]++;
        } //for

        // 위상 정렬 시작
        Deque<Integer> queue = new ArrayDeque<>();
        // 노드들을 순회
        for(int i = 1; i <= N ; i++){
            // 노드의 인접 행렬 값이 0 일 경우 큐에 저장
            if(inDegree[i] == 0){
                queue.offer(i);
            } // if
        } // for

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int current = queue.poll();
            sb.append(current + " ");
            for(int next : graph.get(current)){
                // 다음 대상 인접행렬 값 --
                inDegree[next]--;
                // 인접 행렬이 0 일 경우 큐애 추가
                if(inDegree[next] == 0){
                    queue.offer(next);
                } // if
            } // for
        } // while
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
