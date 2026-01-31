package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 구간_합_구하기_tree {
    static long[] tree;
    static int S;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 데이터의 크기
        int N = Integer.parseInt(st.nextToken());
        // 수가 변경되는 횟수
        int M = Integer.parseInt(st.nextToken());
        // 구간의 합을 구하는 횟수
        int K = Integer.parseInt(st.nextToken());

        // (2^k 값) 리프 노드 시작 Index
        S = 1;
        // 제곱된 값이 N 보다 큰 값이어야 함
        while(N > S){
            S *= 2;
        } // while

        // 전체 트리 크기는 S의 2배
        tree = new long[S * 2];

        // tree data add
        for(int i = 0 ; i < N ; i++){
            tree[S + i] = Long.parseLong(br.readLine());
        } // for

        // 합배열 저장
        // S- 1 로 시작하는 이유는 S부터 ~ S + N-1 까지가 리프노드로 값을 초기화 했기 때문임
        for(int i = S - 1; i > 0; i--){
            // 자식 노드는 : 오른쪽 자식 노드 : 부모 * 2 || 왼쪽 자식 노드 : 부모 * 2 + 1
            tree[i] = tree[i * 2 ] + tree[i * 2 + 1];
        } // for

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < K + M ; i++){
            st = new StringTokenizer(br.readLine());
            // 계산 구분 1 or 2
            int a = Integer.parseInt(st.nextToken());
            // 대상 index
            int b = Integer.parseInt(st.nextToken());
            // 바꿀 값 또는 끝날 범위 index
            long c = Long.parseLong(st.nextToken());

            // 데이터 업데이트
            if(a == 1){
                update(b, c);
            } else { // 구간 합 쿼리
                sb.append(query(b, (int) c)).append("\n");
            } // if - else
        } // for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 구간 합 구하기 함수 (L: 시작, R: 끝)
    static long query(int left, int right) {
        long sum = 0;
        // 대상 리프노드 왼쪽 인덱스
        int L = S + left - 1;
        // 대상 리프노드 오른쪽 인덱스
        int R = S + right - 1;

        // 서로 겹쳐질때까지 진행
        while(L <= R){
            // L이 홀수라면 범위의 경계에 들어가 있으므로 따로 덧셈하고 오른쪽으로 칸을 이동 시킴 (동립 노드임)
            if(L % 2 == 1){
                sum += tree[L];
                L++;
            } // if

            // R이 짝수라면 범위의 경계에 들어가 있으므로 따로 덧셈하고 왼쪽으로 칸을 이동 시킴 (동립 노드임)
            if(R % 2 == 0){
                sum += tree[R];
                R--;
            } // if

            // 층을 위로 이동 - 부모 노드로 이동
            L /= 2;
            R /= 2;
        }// while

        return sum;
    }

    // tree 값 업데이트
    private static void update(int targetNode, long value){
        // 전달 받은 index 값을 리프노드 값으로 변환
        // 중간 범위 + 대상 노드 인덱스 - 1
        int node = S + targetNode - 1;
        // 값 업데이트
        tree[node] = value;

        // 부모 노드로 이동
        node /= 2;
        while(node > 0){
            tree[node] = tree[node * 2 ] + tree[node * 2 + 1];
            // 부모 노드로 이동
            node /= 2;
        }// while
    }
}
