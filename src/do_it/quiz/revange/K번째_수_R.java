package do_it.quiz.revange;

import java.io.*;

public class K번째_수_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 해당 문제는 N^2을 사용하면 제한 시간내 풀이가 불가능하기에 이진 탐색 알고리즘을 사용함

        // N * N의 대상이 될 변수 - 1부터 시작
        int N = Integer.parseInt(br.readLine());
        // 결과 도출을 위한 배열 내 K번째 수 - 1번 부터 시작
        int K = Integer.parseInt(br.readLine());

        // 시작 값은 1로 지정
        long start = 1;
        // 종료 값은 최대 조회 범위 K로 지정
        long end = K;
        // 배열 내 K 번째 값
        long result = 0;

        // 이분 탐색 시작
        while(start <= end){
            // 이분 탐색에 기준이 될 중앙 인덱스 값
            long middle = (start + end) / 2;
            // A[K] 값보다 작거나 같은 수의 개수
            long count = 0;

            // 각각의 행 i ~ N 까지의 기준 값(middle)값 보다 작거나 같은 개수를 카운트
            for(int i = 1; i <= N ;i++){
                // 만약 middle이 너무 크면 i=3일 때 middle / i = "333" 이지만 N이 10이라면 불필요한 큰 값이기 - Math.min( min, "N")을 사용  N개까지만 카운트 하는것
                count += Math.min( middle / i, N);
            } // for

            // middle 이하에는 K번째 수가 아직 없음 → middle이 너무 작다
            if(count < K){
                start = middle + 1;
            } else {
                // middle 이하에 K번째 수가 있다 (혹은 초과함)
                result = middle;
                end = middle -1;
            } // if - else
        } // while

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
