package do_it.quiz.revange;

import java.io.*;

public class K번째_수_이진_R4 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        // 배열 A와 B의 인덱스는 1부터 시작한다는 전제조건으로 1부터 시작
        long start = 1 ;
        // A[i][j] 의 최대 값은 N * N 값임
        long end = (long) N * N ;

        long result = 0;
        // 이진 탐색 기본 틀
        while(start <= end){
            // 중간 값을 잡음
            long mid = (start + end) / 2;
            // mid 기준 범위 내에 존재하는 배열 내 숫자 개수 확인
            long count = 0;
            // 1 ~ N 까지의 범위 내 mid 보다 작거나 같은 개수 확인
            for(int i = 1 ; i <= N ; i++){
                // 곱셈 범위를 중앙 값으로 나누면 그안의 개수를 알 수 있음 (구구단)
                // min N을 해주는 이유는 mid 값이 찾고자하는 N의 범위를 초과할 경우를 방지하기 위함
                count += Math.min( mid / i , N );
            } // for

            // 범위 내 수가 더 많고 안애 포함되어 있어
            if(count >= K){
                // 범위를 줄여야 하기에 end 값을 줄임
                result = mid;
                end = mid - 1;
            } else {
                // 범위를 늘려야 하기에 start 값을 늘림
                start = mid + 1;
            } // if - else

        } // while


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
