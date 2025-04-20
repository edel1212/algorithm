package timeComplexity;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        //int[] arr = {5, 3, 8, 4, 2, 7, 1, 6};
        int[] arr = {4,8,6};

        // 배열 정렬 시작
        mergeSort(arr, 0, arr.length - 1);

        // 정렬된 배열 출력
        System.out.println(Arrays.toString(arr)); // 정렬 결과 출력
    }

    /**
     * 배열을 병합 정렬하는 메서드
     *
     * @param arr 정렬할 배열
     * @param left 현재 정렬할 범위의 왼쪽 인덱스
     * @param right 현재 정렬할 범위의 오른쪽 인덱스
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { // 원소가 1개 이상이면
            int mid = (left + right) / 2;

            // 재귀 함수 - 왼쪽 반 정렬 - return 될 때까지 반복
            mergeSort(arr, left, mid);

            // 재귀 함수 - 오른쪽 반 정렬 - return 이후 스택이 올라가며 값 시작
            mergeSort(arr, mid + 1, right);

            // 병합
            merge(arr, left, mid, right);
        } // if
    }

    /**
     * 정렬된 두 배열 부분을 합치는 메서드
     *
     * @param arr 원본 배열
     * @param left 합칠 범위의 왼쪽 인덱스
     * @param mid 왼쪽과 오른쪽을 나누는 중간 인덱스
     * @param right 합칠 범위의 오른쪽 인덱스
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        // 크기에 맞는 임시 배열 생성 (크기는 현재 범위 크기만큼)
        int[] temp = new int[right - left + 1];

        int i = left;      // 왼쪽 시작 인덱스
        int j = mid + 1;   // 오른쪽 시작 인덱스
        int k = 0;         // temp 배열 인덱스

        // 왼쪽과 오른쪽 배열을 비교해서 작은 값을 temp에 복사
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            } // if - else
        } // loop

        // 왼쪽에 남은 데이터 복사
        while (i <= mid) {
            temp[k++] = arr[i++];
        } // loop

        // 오른쪽에 남은 데이터 복사
        while (j <= right) {
            temp[k++] = arr[j++];
        } // loop

        // temp 배열의 내용을 원본 배열(arr)에 복사
        for (int idx = 0; idx < temp.length; idx++) {
            arr[left + idx] = temp[idx];
        } // loop
    }
}
