package do_it.quiz;

import java.util.Arrays;

public class QS {
    public static void main(String[] args) {
        int[] A = {5,3,6,1};
        quickSort(A,0, A.length-1);
        System.out.println(Arrays.toString(A));
    }

    // 피벗 값 기준으로 스왑
    public static void quickSort(int[] A, int low, int high){
        // 재귀 종료 조건 ( == : 같은 곳을 포인터함 , > 정렬할 수가 없음)
        if(low>= high) return;
        int pivot = A[ (low + high) / 2 ];
        int index = partition(A, low, high, pivot);

        // left
        quickSort(A, low, index - 1);
        // right
        quickSort(A, index, high);
    }

    public static int partition(int[] A, int low, int high, int pivot){
        while(low <= high){
            while(A[low] < pivot) low++;
            while(A[high] > pivot) high--;

            if(low <= high){
                int tmp = A[low];
                A[low] = A[high];
                A[high] = tmp;
                low++;
                high--;
            } // if
        }

        return low;
    }
}
