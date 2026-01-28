package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리_R {
    static int N;
    static boolean[] visited;
    static List<List<Integer>> tree;
    static int leafNodeCount = 0;
    static int deleteNode = 0;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 노드의 개수
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) tree.add(new ArrayList<>());

        int rootNode = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ;i++){
            int p = Integer.parseInt(st.nextToken());
            if(p == -1){
                rootNode = i;
                continue;
            } // for
            // 부모 노드에 연결된 자식들
            tree.get(p).add(i);
        }// for

        // 삭제 대상 노드
        deleteNode = Integer.parseInt(br.readLine());

        visited = new boolean[N];

        dfs(rootNode);

        if(deleteNode == rootNode){
            bw.write("0");
        } else {
            bw.write(String.valueOf(leafNodeCount));
        } // if - else

        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int node){
        int childNodeCount  = 0;
        // 방문 처리
        visited[node] = true;

        for(int next : tree.get(node)){
            if(!visited[next] && deleteNode != next){
                childNodeCount++;
                dfs(next);
            } // if
        } // for

        // 자식이 없을 경우
        if(childNodeCount == 0) leafNodeCount++;
    }

}
