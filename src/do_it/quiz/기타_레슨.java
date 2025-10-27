package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class 기타_레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 곡의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 블루레이 CD의 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // 블루레이의 최소 크기 : 가장 긴 길이의 강의 ( 강의 하나만 넣어도 다 들어가야 하기 떄문 )
        int start = 0;
        // 블루레이의 최대 크기 : ( 모든 강의를 한 장에 넣을 경우를 생각 )
        int end = 0;
        int[] A = new int[N];
        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
            end += A[i];
            start = Math.max(start, A[i]);
        } // for

        // 이진 탐색 시작
        while(start <= end){
            // 현재 가정한 블루레이 용량
            int middle = (start + end) / 2;
            int sum = 0;
            int count = 0;

            // 각각 레슨을 블루레이어 넣어가며 확인
            for(int i = 0 ; i < N; i++) {
                // 블루레이 용량을 넘어 섰을 경우
                if (sum + A[i] > middle) {
                    // CD 추가
                    count++;
                    // 용량 초기화
                    sum = 0;
                } // if
                // sum에 레슨 값 누적
                sum += A[i];
            } // for

            // 혹시나 남은 용량은 신규 CD 반영
            if(sum != 0) count++;

            if(count > M){
                // 너무 작아서 더 많은 블루레이 필요 → 크기 늘리기
                start = middle + 1;
            } else {
                // 충분히 들어감 → 더 줄일 수 있음
                end = middle - 1;
            } // if - else

        } // while

        bw.write(String.valueOf(start));
        bw.flush();
        bw.close();
    }
}
