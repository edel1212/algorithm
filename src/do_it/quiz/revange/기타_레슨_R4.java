package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 기타_레슨_R4 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 강의 수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 사용 가능 CD 수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // 강의를 저장할 배열
        int[] A = new int[N];
        // 시작값 (최소로 넣을 수 있는 영상의 길이 값)
        int start = 0;
        // 종료값 (최대로 넣을 수 있는 영상의 길이 값)
        int end = 0;
        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ;i++){
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
            // 동영상 길이기 가장 긴 것
            start = Math.max(start, A[i]);
            // 모든 동영상의 총 길이 합
            end += A[i];
        }// for

        while(start <= end){
            // 중앙 영상 길이 (용량)값
            int mid = (start + end) / 2;

            // 사용한 CD 개수
            int usedCdCount = 0;
            int videoSize = 0;

            for(int i = 0 ; i < A.length ; i++){
                // 비디오 사이즈가 중앙 값 보다 클 경우
                if(A[i] + videoSize > mid){
                    videoSize = 0;
                    usedCdCount++;
                } // if
                // CD에 저장할 비디오 사이즈
                videoSize += A[i];
            } // for

            // 사용 용량이 있다면 CD를 무조건 사용해서 CD를 구워야 함
            if(videoSize != 0) usedCdCount++;

            // 사용 CD가 목표 CD 보다 더 많을 경우 : 저장 용량을 늘려야 해
            if(usedCdCount > M){
                start = mid + 1;
            } else {
                end = mid - 1;
            } // if - else

        } // while

        // 가장작은 영상의 길이를 찾는 문제이기에 변경
        bw.write(String.valueOf(start));
        bw.flush();
        bw.close();
    }
}
