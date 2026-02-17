package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] A = {4,2,3,7,1,5,6};
        mergeSort(A, 0 , A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    private static void mergeSort(int[] A, int left, int right){
        // left와 겹쳐질 경우 종료
        if(left >= right) return;

        // 중앙 index값
        int mid = (left + right) / 2;

        // left group
        mergeSort(A, left, mid);
        // right group
        // ✅ 병합 정렬의 정석 오른쪽 그룹에서 'mid + 1' 필요 : 배열의 값이 3개 있을 때 생각해보면 알 수 있다
        //    그냥 mid 사용 시 무한 루프에 빠짐
        mergeSort(A, mid + 1, right);

        // 병합
        merge(A, left, mid, right);
    }

    private static void merge(int[] A, int left, int mid, int right){
        // 임시 배열 생성
        int[] tmp = new int[ right - left + 1 ];

        // 왼쪽 그룹 시작 index
        int i = left;
        // 오른쪽 그룹 시작 index
        int j = mid + 1;
        // 임시 배열 인덱스
        int k = 0;

        // 두 그룹이 범위내에 있을 시 비교하여 tmp 배열에 값 주입ㄴ
        while( i <= mid && j <= right ){
            // 왼쪽 그룹의 값이 더 작을 경우
            if( A[i] <= A[j] ){
                tmp[k] = A[i];
                i++;
                k++;
            } else {
                // 오른쪽 그룹이 더 작을 경우
                tmp[k] = A[j];
                j++;
                k++;
            } // if - else
        } // while

        // 왼쪽 그룹 납은 값 정리
        while(i <= mid){
            tmp[k] = A[i];
            k++;
            i++;
        } // while

        // 오른쪽 그룹 남은 값 정리 (섞여있는 값 먼저 정리 후 남은 값 처리)
        while(j <= right){
            tmp[k] = A[j];
            k++;
            j++;
        } // while

        // tmp 배열 -> 원본 배열에 주입
        for(int t = 0 ; t < tmp.length ; t++){
            A[left + t] = tmp[t];
        } // for

    }
}
