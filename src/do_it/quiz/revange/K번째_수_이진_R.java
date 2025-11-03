package do_it.quiz.revange;

import java.io.*;

public class K번째_수_이진_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long start = 1;
        long end = K;
        long result = 0;

        while(start <= end){
            // 중앙 값 인덱스가 아닌 실제 값
            long mid = (start + end) / 2;
            // 중앙 값보다 작거나 같은 개수
            int count = 0;

            // 각 행의 중앙 값보다 작은 개수 확인
            for(int i = 1 ; i <= N ; i++){
                count += Math.min( mid / i, N );
            } // for

            if(count < K){
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            } // if - else

        } // while

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}
