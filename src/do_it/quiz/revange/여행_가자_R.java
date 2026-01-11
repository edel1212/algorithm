package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 여행_가자_R {
    // 부모 노드 배열
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시 개수
        int N = Integer.parseInt(br.readLine());
        // 여행 계획에 속한 도시 수
        int M = Integer.parseInt(br.readLine());

        // 인접 행열
        int[][] city = new int[N + 1][N + 1];

        // 도시 연결 데이터 저장 (N * N) - i,j 가 각각 도시를 의미함
        for(int i = 1; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
            } // for
        } // for

        // 여행 계획 init
        int[] travelPlan = new int[M + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M ; i++){
            travelPlan[i] = Integer.parseInt(st.nextToken());
        }//for

        // parent init
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)  parent[i] = i; // 처음에는 자기 자신이 부모(대표)임

        // union 연산
        for(int i = 1 ; i <=N ; i++){
            for(int j = 1 ; j <=N ; j++){
                if(city[i][j] == 1) union(i,j);
            } // for
        } // for

        boolean isPossible = true;
        int baseRoot = find(travelPlan[0]);
        for(int i = 1 ; i< M ;i++){
            if(baseRoot != find(travelPlan[i])){
                isPossible = false;
                break;
            } //if
        } // for

        bw.write(isPossible ? "YES" : "NO");
        bw.flush();
        bw.close();
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if( rootA != rootB ){
            parent[rootA] = rootB;
        } // if
    }

    public static int find(int i){
        if(i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

}
