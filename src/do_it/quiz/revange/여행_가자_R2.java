package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 여행_가자_R2 {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시 개수
        int N = Integer.parseInt(br.readLine());
        // 여행 계획에 속한 도시 수
        int M = Integer.parseInt(br.readLine());

        // parent init
        parent = new int[N + 1];
        for(int i = 1; i <= N ;i++){
            parent[i] = i;
        } // for

        // 여행 경로 확인
        for(int i = 1; i <= N ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N ;j++){
                int unionFlag = Integer.parseInt(st.nextToken());
                if(unionFlag == 1) union(i,j);
            } // for
        } // for

        // 여행 계획
        int[] travelPlan = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0  ;i < M ; i++){
            travelPlan[i] = Integer.parseInt(st.nextToken());
        } // for

        boolean isPossible = true;

        // 초기 비교 대상
        int baseRoot = find(travelPlan[0]);
        for(int i = 1 ;i < M ;i++){
            if(baseRoot != find(travelPlan[i])){
                isPossible = false;
                break;
            } // if
        } // for

        bw.write(isPossible ? "YES" : "NO");
        bw.flush();
        bw.close();
    }


    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootB != rootA){
            parent[rootA] = rootB;
        } // if
    }

    // find (재귀)
    public static int find(int i){
        if(i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }
}
