package do_it.quiz;

import java.io.*;
import java.util.*;

public class 수_정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열의 범위
        int N = Integer.parseInt(br.readLine());
        // 배열 초기화
        int[] arr = new int[N];
        for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(br.readLine());

        // 기수 정렬 진행
        radixSort(arr);

        for(int i : arr){
            bw.write(String.valueOf(i));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void radixSort(int[] arr) {
        // 배열 내 최대 값을 구함 (가장 큰수를 기반으로 자릿수를 지정하여 loop 하기 위함)
        int max = Arrays.stream(arr).max().getAsInt();
        // 자릿수 초기화 "1"부터 시작
        int exp = 1;
        // 베열의 크기
        int n = arr.length;
        // 정렬된 배열을 담을 임시 배열
        int[] tmp = new int[n];

        // 반복문 가장 낮은 자릿수 부터 확인 ( 170 / exp -> 170, 17, 1   )
        while(max / exp > 0){
            // 자릿수를 카운드할 배열 ( 0 ~ 9 까지의 자릿수 )
            int[] count = new int[10];

            // 1. 자릿수별 카운트 [ 단순 빈도 정보만 저장 ]
            for(int i = 0 ; i < n ; i++){
                // %10 까지 해주면 원하던 마지막 자릿수만 얻을 수있음
                int digit = arr[i / exp] % 10;
                // 지정 위치의 카운트 ++
                count[digit]++;
            } // for

            // 2 . 누적 합 [위치 정보]
            // 1 ~ 10까지  [ 해당 digit에서 나보다 믿에 지수 개수를 알 수 있음 ]
            for (int i = 1; i < 10; i++) {
                // 누적 합 공식 S[i] + S[i - 1]
                count[i] += count[i - 1];
            } // for

            // 3 . tmp 배열에 역순으로 채우기 (안정 정렬 보장)
            for (int i = n - 1; i >= 0; i--) {
                // 현재의 자릿수
                int digit = (arr[i] / exp) % 10;
                int realIndex = --count[digit];
                tmp[ realIndex ] = arr[i];
            }

            // 4 .  깊은 복사
            for(int i = 0 ; i < n; i++){
                arr[i] = tmp[i];
            }

            exp *= 10; // 다음 자릿수
        } // while

    }

}
