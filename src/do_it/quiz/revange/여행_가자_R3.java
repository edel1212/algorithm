package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 여행_가자_R3 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시의 수 ( 1 ~ N )
        int N = Integer.parseInt(br.readLine());
        // 연결 횟수
        int M = Integer.parseInt(br.readLine());

        // parent array init
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++)
            parent[i] = i;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int v = Integer.parseInt(st.nextToken());
                // v가 1일 경우에만 인접행렬 구조에서 연결 된것으로 되어이음
                if (v == 1) {
                    union(i, j);
                } // if
            } // for
        } // for

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 같은 그룹 (포함 관계) 확인
        boolean isGroup = true;

        // 목표는 모든 여행 경로가 연결되어이는것(한개의 그룹)을 판단하기 위함이므로 기준점 하나로 진행 가능
        int baseCity = Integer.parseInt(st.nextToken());

        // baseCity를 제외한 나머지 체크
        for (int i = 1; i < M; i++) {
            int nextCity = Integer.parseInt(st.nextToken());
            if (find(baseCity) != find(nextCity))
                isGroup = false;
        } // for

        bw.write(isGroup ? "YES" : "NO");
        bw.flush();
        br.close();
        bw.close();

    }

    // recursive를 통한 find 작업
    // find를 진행하면서 최적화 진행
    private static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        // 이미 같은 그룹일 경우 false
        if (rootA == rootB) {
            return false;
        } //

        // union 진행
        parent[rootA] = rootB;

        return true;
    }
}
