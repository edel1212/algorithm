package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_R5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        long[] A = new long[N];
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        } // for

        //✅ start, end를 ++, -- 하려면 정렬이 되어있어야 해!!
        Arrays.sort(A);

        int result = 0;
        for(int i = 0 ; i < N ; i++){
            long base = A[i];

            int start = 0;
            // ⭐️ 모두 양수의 값이 아니니 모든 포인터 범위를 확인해야 해
            int end = N - 1;
            while(start < end){
                long sum = A[start] + A[end];
                if(base <= sum){
                    // 대상이 좋은 수 인지 검증
                    if(sum == base){
                        if(start == i){
                            start++;
                            continue;
                        }// if
                        if(end == i){
                            end--;
                            continue;
                        }// if
                        result++;
                        break;
                    }// if
                    end--;
                } else {
                    start++;
                } // if - else
            } // while

        } // if

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}
