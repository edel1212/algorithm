package do_it.quiz;

import java.io.*;

public class K번째_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // N * N 수
        int N = Integer.parseInt(br.readLine());
        // 지정 배열번째 수
        int K = Integer.parseInt(br.readLine());

        // 1번부터 시작한다는 전제 조건
        long start = 1;
        // 배열의 최대 값일 지정 문제에서 요구하는 건 K번째이기에 K까지만 진행
        long end = K;
        // 결과
        long result = 0;

        while( start <= end ){
            // 중간값 (현재 탐색 중인 값)
            long middle = (start + end) / 2;
            // 중간 값 이하를 카운트
            long count = 0;

            // 각행 마다 중앙 값 기준이하의 개수를 카운트
            for(int i = 1; i <= N; i++){
                count += Math.min( middle / i , N );
            } // for

            if(count < K){
                start = middle + 1;
            } else {
                result = middle;
                end = middle -1;
            } // if - else
        } // while

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
