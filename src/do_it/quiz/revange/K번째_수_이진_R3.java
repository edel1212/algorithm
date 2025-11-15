package do_it.quiz.revange;

import java.io.*;

public class K번째_수_이진_R3 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long start = 1;
        long end = N * N;

        long result = 0;
        while(start<=end){
            // 중앙 값
            long mid = (start + end) / 2;
            // 같거나 작은 개수
            int count = 0;
            for(int i = 1; i<=N ;i++){
                count += Math.min(mid / i , N);
            } // for

            if(K > count){
                start = mid + 1;
            } else {
                end = mid - 1;
                result = mid;
            } // else

        } // while

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
