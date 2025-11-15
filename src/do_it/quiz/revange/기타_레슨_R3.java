package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 기타_레슨_R3 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 강의 수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 사용 가능 CD 수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] A = new int[N];
        int start = 0;
        int end = 0;
        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ;i++){
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
            start = Math.max(start, A[i]);
            end += A[i];
        }// for

        while(start <= end){
            // 시도해볼 용량
            int mid = (start + end) /2;

            int cdCount = 0;
            int sum = 0;
            for(int i = 0 ; i < A.length ; i++){
                if( A[i] + sum > mid ){
                    sum = 0;
                    cdCount++;
                }//if
                sum += A[i];
            } // for

            if(sum != 0) cdCount++;

            if(cdCount > M){
                start = mid + 1;
            } else {
                end = mid - 1;
            } //if - else

        } // while

        // start를 반환하는 이유는 가장 작은 사용 용량을 확인하기 위함임
        bw.write(String.valueOf(start));
        bw.flush();
        bw.close();
    }
}

