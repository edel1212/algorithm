package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 기타_레슨_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 강의 수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // CD 수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // 이진 탐색 변수 할당
        int start = 0;
        int end = 0;
        int[] A = new int[N];
        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
            end += A[i];
            start = Math.max(start, A[i]);
        } // for

        while(start <= end){
            // 이진 탐색 기준 저장할 강의 용량
            int mid = (start+ end) / 2;
            int sum = 0;
            int count = 0;

            // 각각의 강의를 확인하며 용량 체크
            for(int i = 0 ; i < N ; i++){
                // 기준 제한 용량보다 강의 용량이 클 경우
                if(A[i] + sum > mid){
                    // 사용 CD 개수 추가
                    count++;
                    sum = 0;
                } // if
                // 용량에 여유가 있으므로 값 누적
                sum += A[i];
            } // for

            // 용량이 남아있으면 추가 CD 필요
            if(sum != 0) count++;

            // 필요한 CD가 더 많을 경우
            if(count > M){
                start = mid + 1;
            } else {
                end = mid - 1;
            } // else

        } // while

        bw.write(String.valueOf(start));
        bw.flush();
        bw.close();

    }
}
