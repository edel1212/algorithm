package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스 {
    /**
     * 문제 제목: 바이러스
     *
     * 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
     *
     * 예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어, 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 연결되어 있지 않으므로 영향을 받지 않는다.
     *
     * 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
     *
     * 입력
     *
     * 첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
     *
     * 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
     *
     * 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
     *
     * 출력
     *
     * 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
     *
     * 예제 입력 1
     *
     * Plaintext
     * 7
     * 6
     * 1 2
     * 2 3
     * 1 5
     * 5 2
     * 5 6
     * 4 7
     * 예제 출력 1
     *
     * Plaintext
     * 4
     *
     */
    static List<List<Integer>> graph = new ArrayList<>();
    static int N ;
    static int result ;
    static boolean[] visited ;
    public static void main(String[] args)   throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // PC count (1 ~ N)
        N = Integer.parseInt(br.readLine());
        // 쌍으로 연결된 횟수
        int M = Integer.parseInt(br.readLine());

        // graph init
        for(int i = 0 ; i <= N ;i++){
            graph.add(new ArrayList<>());
        }// for

        // add graph data
        for(int i = 0; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph.get(S).add(E);
            graph.get(E).add(S);
        } // for

        visited = new boolean[N + 1];
        dfs(1);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int node){
        visited[node] = true;

        for(int next : graph.get(node)){
            if(!visited[next]){
                result++;
                dfs( next);
            }
        } // for
    }

    // 1번 컴퓨터도 포함 하므로 결과 값에서 1을 빼줘야함
    public static int dfsVerInt(int node){
        int count = 1;
        visited[node] = true;

        for(int next : graph.get(node)){
            if(!visited[next]){
                count += dfsVerInt( next);
            }
        } // for

        return count;
    }

}
