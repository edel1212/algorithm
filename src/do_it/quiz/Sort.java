package do_it.quiz;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};

        //bubbleSort(arr);
        //selectedSort(arr);
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 버블 정렬
    // 2중 배열을 통한 스왑 가장 오른쪽에는 크거나 작은 수가 감
    public static void bubbleSort (int[] arr){
        // 2중 반복문 안에서 +1로 조회하기에 -1로 범위 지정
        for(int i = 0 ; i < arr.length -1; i++){
            // 범위는 오른쪽에 하나씩 정렬된게 쌓여가기에 -i
            for(int j = 0 ; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                } // if
            } // for
        }// for
    }

    // 선택 정렬
    // 가장 크거나 작은 수를 찾아서 왼쪽에 정렬 시킴
    public static void selectedSort(int[] arr){
        for(int i = 0 ; i < arr.length -1; i++){
            int minIdx = i;
            for(int j = 1 + i ; j < arr.length; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                } // if
            } // for

            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }// for
    }

    // 삼입 정렬
    // 정렬되지 않은 애들을 찾아 쉬프트 시킴
    public static void insertSort(int[] arr){
        // 첫번째 부터 조사 시작
        for(int i = 1 ; i < arr.length ; i++){
            int key = arr[i];
            int range = i - 1;

            while( range >= 0 && key < arr[range] ){
                // >> 쉬프트
                arr[range + 1] = arr[range];
                // 정렬된 배열 내 조회 범위 축소
                range--;
            }// while

            // 감소된 올바른 위치에 key 삽임
            arr[range + 1] = key;

        } // for
    }

     public static void quickSort(int[] arr , int left, int right){
        // 재귀 종료 조건 left가 right 보다 커질경우
        if(right <= left) return;

        // 피벗 대상
        int pivot = arr[ (left + right) / 2 ];
        // 나눠진 그룹의 대상이 될 값
        int baseIndex = partition(arr, left, right, pivot);
        
        // 왼쪽 그룹
        quickSort(arr, left, baseIndex -1);
        // 오른쪽 그룹
        quickSort(arr, baseIndex, right);
    }

    public static int partition(int[] arr , int left, int right, int pivot){
        while(left <= right){
            // left >> 쉬프트
            while(arr[left]< pivot) left++ ;
            // right << 쉬프트
            while(arr[right] > pivot) right--;

            if(left <= right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                // 서로 교환 했기에 각자 포인터를 다음 타자로 쉬프트
                left++;
                right--;
            }
        }// if
        // 가장 왼쪽으로 정렬하기에 left를 기준으로 함
        return left;
    }
}
