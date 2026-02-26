package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전0_R2 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 동전의 숫자
        int N = Integer.parseInt(st.nextToken());
        // 찾고자 하는 수
        int K = Integer.parseInt(st.nextToken());

        // A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수 [ 조건으로 인하여 그리디 성립 ]

        int[] A = new int[N];
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(br.readLine());
        } // for

        // 동전 자체가 오름차순으로 주어진다 하였기에 정렬 불필요
        // 큰수부터 확인
        for(int i = N - 1 ; i >= 0 ; i--){
            if(K >= A[i]){
                // 사용 카운트
                count += K / A[i];
                K %= A[i];
            } // if
        } // for

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
