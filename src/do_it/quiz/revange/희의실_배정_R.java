package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 희의실_배정_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
            A[i][0] = s;
            A[i][1] = e;
        } // for

        Arrays.sort(A, (o1,o2)->{
            // 종료 시간이 같을 경우
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        // 회의실 카운트
        int result = 0;
        // 화의 종료시간
        int endTimeTmp = Integer.MIN_VALUE;

        // 모든 회의실 예약을 확인
        for(int i = 0 ; i < N ; i++){
            // 회의 시작 시간
            int start = A[i][0];
            // 회의 종료 시간
            int end = A[i][1];
            // 종료시간 보다 시작 시간이 클 때(회의가 가능할 때)
            if(endTimeTmp <= start){
                // 회의 종료 시간 지정
                endTimeTmp = end;
                result++;
            } // if
        }// for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
