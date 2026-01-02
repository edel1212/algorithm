package do_it.quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 칵테일 {

    // 그래프
    static ArrayList<Node>[] adj;
    // 각 재료의 양
    static long[] ans;
    // 방문 여부
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 재료의 개수
        int N = Integer.parseInt(br.readLine());

        // 그래프 초기화
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        // 방문 여부 초기화
        visited = new boolean[N];
        // 각 재료들의 양 초기화
        ans = new long[N];

        // 모든 비율들의 최소 공배수 초기값
        long lcmValue = 1;

        // 각각의 재료 비율울 저장
        for(int i = 0 ; i < N - 1 ; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int p = Integer.parseInt(stringTokenizer.nextToken());
            int q = Integer.parseInt(stringTokenizer.nextToken());

            // 각각의 관계 저장
            adj[a].add(new Node(b,p,q));
            adj[b].add(new Node(a,q,p));

            // 분모가 될 수 있는 값드르이 최소 공배수를 미리 저장
            lcmValue *= (p * q / gcd(p, q));
        } // for

        // 이건 왜 해주는거야?
        ans[0] = lcmValue;
        dfs(0);

        long totalGcd = ans[0];
        for (int i = 1; i < N; i++) {
            totalGcd = gcd(totalGcd, ans[i]);
        }

        // 전체를 최대공약수로 나누어 가장 작은 정수비로 만듦
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i] / totalGcd).append(" ");
        }
        System.out.println(sb.toString().trim());

    }

    // 최대공약수 (유클리드 호제법)
    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void dfs(int current){
        visited[current] = true;
        for(Node node : adj[current]){
            if(!visited[node.next]){
                ans[node.next] = (ans[current] * node.q) / node.p;
                // 재귀
                dfs(node.next);
            } // if
        } // for
    }

    // 비율 관계를 저장할 class
    public static class Node{
        // 현재 재료와 연결된 상대방 재료의 번호입니다.
        int next;
        // 현재 재료의 비율
        int p;
        // 연결된 상대 재료 비율
        int q;

        public Node(int next, int p , int q){
            this.next = next;
            this.p = p;
            this.q =q;
        }

    }

}
