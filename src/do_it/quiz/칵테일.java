package do_it.quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 칵테일 {

    // 각 재료의 연결 관계(비율)을 저장할 그래프
    static ArrayList<Node>[] recipeGraph;
    // 최종적으로 계산될 각 재료의 양
    static long[] ingredientAmounts;
    // 방문 여부
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 재료의 개수
        int N = Integer.parseInt(br.readLine());

        // 그래프 초기화
        recipeGraph = new ArrayList[N];
        for (int i = 0; i < N; i++) recipeGraph[i] = new ArrayList<>();
        // 방문 여부 초기화
        visited = new boolean[N];
        // 각 재료들의 양 초기화
        ingredientAmounts = new long[N];

        // 모든 비율들의 최소공배수 (나눗셈 시 소수점이 나오지 않게 하려는 '여유분'으로 1을 지정)
        long baseMultiplier = 1;

        // 각각의 재료 비율울 저장
        for(int i = 0 ; i < N - 1 ; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            // 재료 A
            int ingredientA = Integer.parseInt(stringTokenizer.nextToken());
            // 재료 B
            int ingredientB = Integer.parseInt(stringTokenizer.nextToken());
            // 비율 A
            int ratioA = Integer.parseInt(stringTokenizer.nextToken());
            // 비율 B
            int ratioB = Integer.parseInt(stringTokenizer.nextToken());

            // 각각의 관계 저장 (A:B = ratioA:ratioB 관계 저장)
            recipeGraph[ingredientA].add(new Node(ingredientB, ratioA ,ratioB));
            recipeGraph[ingredientB].add(new Node(ingredientA, ratioB ,ratioA));

            // 모든 비례식의 숫자들의 최소공배수를 미리 구해둠 (가장 안전하게 모든 분모를 커버하기 위해서)
            baseMultiplier *= ratioA * ratioB / gcd(ratioA, ratioB);
        } // for

        // 첫 번째 재료의 양을 아주 넉넉한 값(최소공배수)으로 초기 설정
        ingredientAmounts[0] = baseMultiplier;
        dfs(0);

        // 최소 정수를 구하는 작업
        long commonDivisor = ingredientAmounts[0];
        for (int i = 1; i < N; i++) {
            // totalIngredients에는 dfs를 통해 값이 들어가 있음
            commonDivisor = gcd(commonDivisor, ingredientAmounts[i]);
        }

        // 전체를 최대공약수로 나누어 가장 작은 정수비로 만듦
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ingredientAmounts[i] / commonDivisor).append(" ");
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
        for(Node node : recipeGraph[current]){
            if(!visited[node.next]){
                ingredientAmounts[node.next] = (ingredientAmounts[current] * node.q) / node.p;
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
