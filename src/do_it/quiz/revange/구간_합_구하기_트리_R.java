package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 구간_합_구하기_트리_R {
    static int S;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // node count
        int N = Integer.parseInt(st.nextToken());
        // change count
        int M = Integer.parseInt(st.nextToken());
        // sum count
        int K = Integer.parseInt(st.nextToken());

        // 2의 0 제곱 값
        S = 1;
        // 2 제곱
        while(N > S){
            S *= 2;
        } // while

        tree = new long[S * 2];

        // add tree leaf node
        for(int i = 0 ; i < N ; i++){
            tree[S + i] = Long.parseLong(br.readLine());
        } // for

        // 합배열 저장
        for(int i = S - 1; i > 0 ; i--){
            tree[i] = tree[ i * 2 ] + tree[ i * 2 + 1 ];
        }// for


        // calc
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M + K ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                update(b,c);
            } else {
                sb.append(getQuery(b,c));
                sb.append("\n");
            } // if - else

        }// for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void update(int node , long value){
        int coverIndex = S + node - 1;
        tree[coverIndex] = value;

        // 부모 노드로 변경
        coverIndex /= 2;
        while(coverIndex > 0){
            // 구간의 합
            tree[coverIndex] = tree[ coverIndex * 2 ] + tree[ coverIndex * 2 + 1 ];
            coverIndex /= 2;
        }// while
    }

    private static long getQuery(int left, long right){ // right는 main에서 long c를 그대로 받으므로 long 유지
        int convertLeft = S + left -1;
        long convertRight = S + right -1;

        // [수정] 합계 변수를 long으로 변경
        long result = 0;

        while(convertRight >= convertLeft){
            if( convertLeft % 2 == 1 ){
                result += tree[convertLeft];
                convertLeft++;
            }

            if( convertRight % 2 == 0 ){
                // 인덱스는 int 범위 내이므로 캐스팅해서 사용 (이 부분은 유지)
                result += tree[(int)convertRight];
                convertRight--;
            }

            convertLeft /= 2;
            convertRight /= 2;
        }

        return result;
    }
}
