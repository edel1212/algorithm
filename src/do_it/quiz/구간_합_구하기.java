package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 구간_합_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 숫자의 개수 N을 구함
        // 구간의 합을 계산해야 하는 횟수 M을 구함
        // 기본 배열 생성
        // 합 배열 생성
        // 공식을 통해 값을 구함 S[j] - S[ i - 1];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        // 숫자의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 배열의 합 횟수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // 배열 초기화
        int[] arr = new int[N];
        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        } // for

        // 베열의 합 생성
        int[] sumArr = new int[N];
        for(int i = 0 ; i < N ; i++){
            if(i == 0){
                sumArr[i] = arr[i];
                continue;
            } // if
            sumArr[i] = sumArr[i - 1] + arr[i];
        } // for

        // 구간의 합 계산 후 반환
        for(int idx = 0 ; idx < M ; idx++){
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int j = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            if(j >= N) j = N - 1;
            if(i >= N) i = N - 1;
            int rangeSum = i <= 0 ? sumArr[j] : sumArr[j] - sumArr[i - 1];
            bw.write(String.valueOf( rangeSum  ));
            bw.newLine();
        } // for

        bw.flush();

    }
}
