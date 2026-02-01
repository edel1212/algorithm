package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구간_곱_구하기 {
    // 2^k 값
    static int S;
    // 1차원 배열로 표현한 트리
    static long[] tree;
    static final int MOD = 1_000_000_007;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정서의 범위 1 ~ N
        int N = Integer.parseInt(st.nextToken());
        // 변경이 일어날 횟수
        int M = Integer.parseInt(st.nextToken());
        // 구간의 곱이 일어나는 횟수
        int K = Integer.parseInt(st.nextToken());

        // 제곱을 해가며 S의 값을 구함
        S = 1; // 2의 0제곱 값
        while(N > S){
            S *= 2;
        } // while

        tree = new long[S *2];
        // 구간의 곱을 구하기에 초기 값은 1로 세팅 (1은 곱하면 1임)
        Arrays.fill(tree, 1);
        // 초기 리프값 init
        for(int i = 0 ; i < N ; i++){
            tree[S + i] = Integer.parseInt(br.readLine());
        } // for

        // 구간의 곱 진행 (최종 결과 값은 "1,000,000,007로 나눈 나머지" 구하기에 MOD 연산 적용)
        // 곱셈 분배의 법칠 : (A * B) % C` 와 같다 `( A % C * B % C ) % C`
        for(int i = S - 1; i > 0 ; i--){
            //  ✅ 곱셈 분배 법칙을 이용해 값의 범위를 미리 줄임
            tree[i] =  (tree[i * 2] % MOD) *  ( tree[i * 2 + 1] % MOD )  % MOD;
        } // for

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M + K ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 1){
                update(b,c);
            } else {
                sb.append(getModQuery(b, c));
                sb.append("\n");
            } // if - else
        } // for



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void update(int node, long value){
        int index = S + node -1 ;
        tree[index] = value;
        // 부모 노드로 변경
        index /= 2;
        while(0 < index){
            // ✅ 곱셈 분배의 법칙 : ( A % C * B % C ) % C
            tree[index] = (tree[index * 2] % MOD) *  ( tree[index * 2 + 1] % MOD ) % MOD;
            index /= 2;
        } // while
    }

    public static long getModQuery(int left, int right){
        long result = 1;
        int L = S + left - 1;
        int R = S + right - 1;

        while(L <= R){
            if( L % 2 == 1 ){
                result = result * tree[L] % MOD;
                L++;
            } // if

            if( R % 2 == 0 ){
                result = result * tree[R] % MOD;
                R--;
            } // if

            L /= 2;
            R /= 2;
        } // while

        return result;
    }

}
