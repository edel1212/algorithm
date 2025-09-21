package do_it.quiz.revange;

import java.util.Arrays;

public class Sort_R {
    public static void main(String[] args) {
        //int[] arr = {10,200,402,1,3};
        int[] arr = {3,4,5,7};
        //bobbleSort(arr);
        //selectedSort(arr);
        //insertSort(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 대상 값과 다음 값을 비교해가며, 정렬하는 기법
     * N제곱
     * @param arr the base arr
     */
    public static void bobbleSort(int[] arr){
        for(int i = 0 ; i < arr.length - 1; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[j] < arr[i]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                } // if
            } // for
        } // for
    }

    /**
     * 정렬되지 않은 값 중 가장 크거나 작은 값을 찾은 후 값을 바꿔주는 정렬 방식
     * N제곱ㄴ
     * @param arr thr base arr
     */
    public static void selectedSort(int[] arr){
        for(int i = 0 ; i < arr.length; i ++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                } // ir
            } // for
            // 최고 값이 바뀌었을 경우
            if(i != minIndex){
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }//if
        } // for
    }

    /**
     * 현재 위치의 원소를 선택한 후 정렬된 위치의 값을 삽입 하는 방법 삽입 대상의 오른쪽 대상의 위치 값은 쉬프트 시킨다.
     *
     * @param arr the base arr
     */
    public static void insertSort(int[] arr){

        // i가 1부터 시작하는 이유는 가장 첫 Index(0)부터 비교 대상으로 늘려가기 위해서임
        for(int i = 1 ; i < arr.length; i++){
            // 선택 값
            int key = arr[i];
            int sortedLastIndex = i - 1;
            // 하나씩 줄어가며 확인함
            while( sortedLastIndex >= 0 && key < arr[sortedLastIndex] ){
                arr[sortedLastIndex + 1] = arr[sortedLastIndex];
                sortedLastIndex--;
            } // while

            // 상단 while에서 - 되었기에 원래 위치를 찾기위해 +1 을 진행
            arr[sortedLastIndex + 1 ] = key;
        } // for

    }

    /**
     * 피벗 위치를 두고 그룹을 나눠가며 정렬하는 방식
     * nlogn ~ n제곱
     * @param arr the base arr
     * @param left start index
     * @param right last index
     */
    public static void quickSort(int arr[], int left, int right){
        // 재귀 종료 조건 ( = 까지 사용 이유는 성능상 이점이 있음 partition에서 이미 처리를 했기 때문에 또 검사할 필요가 X )
        if(left >= right) return;
        // 피벗의 대상
        int pivot = arr[ (left + right) /2 ];
        int index = partition(arr,left, right, pivot);

        // 왼쪽 그룹
        quickSort(arr, left, index -1);
        // 오른쪽 그룹
        quickSort(arr, index, right);
    }

    public static int partition(int arr[], int left, int right,  int pivot){
        while(left <= right){
            // >> 쉬프트
            while(arr[left] < pivot) left++;
            // << 쉬프트
            while(arr[right] > pivot) right--;

            // 피벗 값 기준으로 자리 정돈
            if(left <= right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            } //if

        } // while
        return left;
    }

}
