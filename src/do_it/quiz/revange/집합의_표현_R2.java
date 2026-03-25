package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 집합의_표현_R2 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // Node의 범위 ( 1 ~ N )
        int N = Integer.parseInt(st.nextToken());
        // 연산의 개수
        int M = Integer.parseInt(st.nextToken());

        // parent array init
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++)
            parent[i] = i;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 0 일 경우 union || 1 일 경우 find
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (flag == 0) {
                union(a, b);
            } else {
                boolean isGroup = find(a) == find(b);
                sb.append(isGroup ? "YES" : "NO").append("\n");
            } // if - else
        } // f

        bw.write(sb.toString());
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
