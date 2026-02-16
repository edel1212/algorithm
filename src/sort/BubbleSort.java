package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = {4,2,3,7,1,5,6};
        bubbleSort(A);
        System.out.println(Arrays.toString(A));
    }

    private static void bubbleSort(int[] A){
        for(int i = 1 ; i < A.length; i++){
            // 최적화 확인
            boolean isSwapped = true;
            for(int j = 0 ; j < A.length - i; j++){
                if(A[j] > A[j + 1]){
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                    // 스왑이 이뤄졌으면 바꿀 값이 더 있다는 것임
                    isSwapped = false;
                } // if
            } // for
            // 자리 바꿈이 없으면 더이상 변경 필요가 없음
            if (isSwapped) break;
        } // for
    }
}
