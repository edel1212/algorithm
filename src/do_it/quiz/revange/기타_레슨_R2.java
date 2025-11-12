package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 기타_레슨_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 강좌 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // CD 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int start = 0;
        int end = 0;
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
            start = Math.max(A[i], start);
            end += A[i];
        } // for

        // 이진 탐색 시작
        while(start <= end){
            // 사용할 용량
            int mid = (start + end) / 2;
            // 사용될 CD 개수
            int count = 0;
            // 용량
            int sum = 0;

            for(int i = 0 ; i < A.length; i++){
                if(mid < A[i] + sum){
                    count++;
                    sum = 0;
                } // if
                sum += A[i];
            } // for

            if(sum != 0) count++;


            if(count > M){  // CD를 더 많이쓴다? 줄여본다 (핵심 문제 개념)
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        } // while

        bw.write(String.valueOf(start));
        bw.flush();
        bw.close();
    }
}
