package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_수의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        } // for

        // 정렬
        Arrays.sort(arr);

        int target = Integer.parseInt(br.readLine());
        // 시작 포인터 위치
        int startIndex = 0;
        // 종료 포인터 위치
        int endIndex = N-1;
        // 개수
        int count = 0;

        // 시작 포인터가 종료 포인터를 넘지 않을 때까지
        while(startIndex < endIndex) {
            int sum = arr[startIndex] + arr[endIndex];

            if(sum == target) {
                count++;
                // 두 수를 사용했으므로 둘 다 이동
                startIndex++;
                endIndex--;
            } else if(sum < target) {
                startIndex++;   // 합이 작으면 왼쪽 포인터 증가
            } else {
                endIndex--;     // 합이 크면 오른쪽 포인터 감소
            } // if - else
        }

        System.out.println(count);
    }
}
