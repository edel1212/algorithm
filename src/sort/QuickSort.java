package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = {4,2,3,7,1,5,6};
        quickSort(A, 0 ,A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    // 재귀를 통해 구현
    private static void quickSort(int[] A, int left , int right){
        // left와 right가 겹쳐질 경우 종료
        if(left >= right) return;

        // 배열의 중앙 값을 피봇 값으로 사용
        int pivot = A[ (left + right) / 2 ];
        // pivot 값 기준으로 그룹을 나눔
        int index = partition(A, left, right, pivot);

        // left group recursive
        quickSort(A, left, index - 1);
        // right group recursive
        quickSort(A, index, right);
    }

    private static int partition(int[] A , int left, int right, int pivot){
        // left 와 right가 겹쳐질 때까지 search
        while(left <= right){
            // A[left] 요소의 값이 피봇 값보다 작을 경우 left를 shift
            // 왼쪽 그룹에는 pivot 보다 작은 값만 존재하게 하기 위함
            while(A[left] < pivot) left++;
            // A[right] 요소의 값이 피봇 값보다 클 경우 right를 shift
            // 오른쪽 그룹에는 pivot 보다 큰 값만 유지하게 하기 위함
            while(A[right] > pivot) right--;

            // 위의 while 문 2개가 끝나고나면  각위치에 있으면 안되는 index 값을 알게된다.
            // 각 그룹의 서로 잘못된 값을 가지고 있다면 값을 서로 교환 시킴
            if(left <= right){
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            } // while

        } // while

        // 왼쪽 그룹의 경우 종료 index가 되고 오른쪽 그룹의 경우 시작 값이 된다.
        return left;
    }

}
