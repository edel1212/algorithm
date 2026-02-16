package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] A = {4,2,3,7,1,5,6};
        insetSort(A);
        System.out.println(Arrays.toString(A));
    }

    // 앞에 차곡차곡 정렬해가며 쉬프트 진행
    private static void insetSort(int[] A){
        // 첫번째 index는 이미 정렬됐다는 가정하에 두번째 요소 부터 반복시작
        // - 2번째 반복문 내애서 i - 1을 통해 요소를 지정함
        for(int i = 1 ; i < A.length; i++){

            // 이번에 정렬할 대상 (백업)
            int target = A[i];
            // 대상 바로 왼쪽 부터 비교 시작
            int j = i - 1;

            // 왼쪽을 Search 해가며 비교한다.
            // 인덱스범위가 유효하며, 대상 값보다 작은 값이 있을 경우
            while(j >= 0 && A[j] > target){
                // target 위치에 값 저장 혹은 오른쪽으로 쉬프트 (같은 말임)
                A[j + 1] = A[j];
                j --;
            } // while

            // 모든 쉬프트가 끝났다면 빈자리에 타겟을 집어 넣음(insert)
            A[j + 1] = target;
        }// for
    }
}
