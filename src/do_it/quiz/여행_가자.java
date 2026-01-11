package do_it.quiz;

import java.io.*;
import java.util.*;

public class 여행_가자 {
    // 부모 배열
    static int[] parent;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시 개수
        int N = Integer.parseInt(br.readLine());
        // 여행 계획에 속한 도시 수
        int M = Integer.parseInt(br.readLine());

        // parent init
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)  parent[i] = i; // 처음에는 자기 자신이 부모(대표)임

        // 인접 행열을 읽으면서 도시 연결하기 (union) - 인접행열을 바로 읽어 union 처리함
        for(int i = 1 ; i <= N ; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            // 연결 관계 확인
            for(int j = 1; j <= N; j++){
                // 0일 땐 이어지지 않음 , 1일 땐 이어짐
                int isConnected = Integer.parseInt(stringTokenizer.nextToken());
                if (isConnected == 1) {
                    // i번 도시와 j번 도시가 연결되어 있다면 한 그룹으로 합침
                    union(i, j);
                }
            } // for
        } // for

        // 여행 계획 확인하기
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 여행 계획에 속한 도시
        int[] travelPlan = new int[M];
        // init
        for(int i = 0 ; i < M ; i++){
            travelPlan[i] = Integer.parseInt(st.nextToken());
        } // for

        // 여행 계획의 첫번째를 기준점으로 대표 노드를 가져옴
        int root = find(travelPlan[0]); // 비교를 하기위해 먼저 가져옴 (기준점)
        boolean isPossible = true;

        for(int i = 1; i < M ; i ++){
            if(root != find(travelPlan[i])){
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
        // 대표가 서로 다를 경우 다른 경로 하나를 하나로 이어 붙여줌
        if(rootA != rootB) parent[rootA] = rootB;
    }

    public static int find(int i){
        if(i == parent[i]) return i;
        // 경로 압축
        return parent[i] = find(parent[i]);
    }

}
