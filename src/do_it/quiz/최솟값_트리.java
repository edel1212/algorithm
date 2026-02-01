package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최솟값_트리 {
    // 2^k 값
    static int S;
    // 1차원 배열로 표현한 트리
    static long[] tree;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정서의 범위 1 ~ N
        int N = Integer.parseInt(st.nextToken());
        // a b의 쌍 개수 ( 찾고자 하는 범위 )
        int M = Integer.parseInt(st.nextToken());

        // 제곱을 해가며 S의 값을 구함
        S = 1; // 2의 0제곱 값
        while(N > S){
            S *= 2;
        } // while

        tree = new long[S * 2];
        // ✅ 0으로 초기화 되면 Min 값이 없는 리프 노드여도 최솟 값 대상이 되기에 최대값으로 초기화 필요
        Arrays.fill(tree, Long.MAX_VALUE);

        // tree data add
        for(int i = 0 ; i < N ; i++){
            tree[S + i] = Integer.parseInt(br.readLine());
        } // for

        // 최솟 값을 찾는 로직 시작
        // data 값 위치 부터 root 노드까지 진행
        // ✅ 해당 부분 틀림 내가 찾고자하는건 부모인덱스 기준 하나하나 채워가야하는건데 나는 값이 있는 애 기준으로 /2를 통해 부모를 지정하려 함
        for(int i = S - 1; i > 0 ; i--){
            // 부모 노드에 양쪽 자식 노드의 값중 최소 값을 주입
            tree[i] = Math.min( tree[i * 2], tree[i * 2 + 1] );
        } // for

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(getMinQuery(start, end));
            sb.append("\n");
        } // for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long getMinQuery(int left, int right){
        // ✅ 비교 방법이 잘못됐음 각각 노드가 최소 값인지 비교를 해야지 이건 하위 리프 노드 둘만 비교함
        long minValue = Long.MAX_VALUE;
        int L = S + left - 1;
        int R = S + right - 1;

        // 교차 될 때까지 진행 ✅(같은 값도 겹쳐지잖아!)
        while(L <= R){
            if(L % 2 == 1){
                minValue = Math.min(minValue, tree[L]) ;
                // ✅ 왼쪽은 증감
                L++;
            } // if

            if(R % 2 == 0){
                minValue = Math.min(minValue, tree[R]) ;
                // ✅ 오른쪽은 감소
                R--;
            } // if

            // 부모 노드로 이동
            L /= 2;
            R /= 2;
        } // while

        return minValue;
    }

}
