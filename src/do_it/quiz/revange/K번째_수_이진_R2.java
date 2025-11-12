package do_it.quiz.revange;

import java.io.*;

public class K번째_수_이진_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(br.readLine());
        long K = Integer.parseInt(br.readLine());

        long start = 1;
        long end =  N * N;
        long result = 0;
        while(start <= end){
            long mid = (start + end) / 2;
            long count = 0;

            for(int i = 1 ; i <= N ; i++){
                count += Math.min( mid / i , N );
            } // for

            if(count < K){
                start = mid + 1;
            } else {
                end = mid - 1;
                result = mid;
            } // if - else

        } // while

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
