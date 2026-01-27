package do_it.quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리 {
    // 방문 배열
    static boolean[] visited;
    // 인접 리스트: 부모가 자식들을 데리고 있는 형태 (Tree)
    static List<List<Integer>> graph;
    // 삭제할 노드 번호
    static int deleteNode;
    // 정답(리프 노드 개수)을 저장할 변수
    static int answer = 0;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 노드 카운트
        int N = Integer.parseInt(br.readLine());
        // 인접 리스트
        graph = new ArrayList<>();
        // init
        for(int i = 0 ; i < N ; i++) graph.add(new ArrayList<>());

        // 방문 배열 초기화
        visited = new boolean[N];

        // 루트 노드가 무엇인지 저장할 변수
        int root = -1;


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int p = Integer.parseInt(st.nextToken());

            // 루트 노드 처리
            if(p == -1){
                root = i;
                continue;
            } // if
            // 부모 -> 자식 처리
            graph.get(p).add(i);
        } // for


        // 삭제 대상 노드
        deleteNode = Integer.parseInt(br.readLine());

        // 루트 노드를 삭제 할 경우 리프노드는 없음
        if (deleteNode == root) {
            bw.write("0");
        } else{
            dfs(root);
            bw.write(String.valueOf(answer));
        } // if - else

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int node){
        visited[node] = true;

        // 자식 노드 수
        int childCount = 0;

        for(int child : graph.get(node)){

            // 자식이 삭제 대상노트가 아니면서, 방문한적이 없다면 아래로 Deep search
            if(child != deleteNode && !visited[child]){
                // 유효한 자식이 있으니 ++
                childCount++;
                // dfs
                dfs(child);
            }// if
        } // for

        // 자식 노드가 없을 경우 --> 리프 노드
        if (childCount == 0) {
            answer++; // 정답 카운트 1 증가
        } // if
    }

}
