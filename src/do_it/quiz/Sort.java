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

}
