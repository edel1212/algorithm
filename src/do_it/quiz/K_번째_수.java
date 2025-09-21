package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class K_번째_수 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        // 수열의 범위
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 찾으려 하는 수의 위치 1 ~ N
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] arr = new int[N];
        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        
        quickSort(arr,0,N-1);

        bw.write(String.valueOf(arr[K-1]));
        bw.flush();
        bw.close();
    }


    /**
     * Quick sort.
     *
     * @param arr   the 배열
     * @param left  the 시작 index
     * @param right the 끝 index
     */
    public static void quickSort(int arr[], int left, int right){
        // 재귀 종료 조건
        if(left >= right) return;

        // 배열의 중앙 값을 피봇값으로 둠
        int pivot = arr[ (left + right) /2 ];
        int index = partition(arr, left, right, pivot);

        quickSort(arr, left, index - 1);  // pivot보다 작은 쪽
        quickSort(arr, index, right);     // pivot보다 큰 쪽

    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        // right 가 더 큰 값일 경우
        while(left <= right){
            // left 의 값이 피벗보다 작을 경우 >> 쉬프트
            while(arr[left] < pivot) left++;
            // right 의 값이 피벗보다 클경우 << 쉬프트
            while(arr[right] > pivot) right--;
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        } // while
        return left;
    }

}
