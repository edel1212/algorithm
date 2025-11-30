package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 회의 시간 시작과 끝을 갖는 배열
        int[][] A = new int[N][2];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
            A[i][0] = s;
            A[i][1] = e;
        }
        // 정렬
        // - 종료 시간 오름차순, 같을 경우 시작 시간 오름 차순
        Arrays.sort(A , (o1,o2)->{
            // 종료 시간이 같을 경우
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int result = 0;
        int endTime = Integer.MIN_VALUE;
        // 모든 회의실 예약을 확인
        for(int i = 0 ; i < N ; i++){
            int start = A[i][0];
            int end = A[i][1];
            if(endTime <= start){
                endTime = end;
                result++;
            } // if
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
