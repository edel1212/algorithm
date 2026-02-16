package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] A = {4,2,3,7,1,5,6};
        selectSort(A);
        System.out.println(Arrays.toString(A));
    }

    public static void selectSort(int[] A){
        for(int i = 0 ; i < A.length; i++){
            // 가장 왼쪽에 정렬된 값이 위치하기에 값이 아닌 인덱스를 넣어줌
            int minIndex = i;
            for(int j = i + 1 ; j < A.length; j++){
                // 2. 훑어보면서 나보다 더 작은 애가 있으면?
                if(A[minIndex] > A[j]){
                    // 3. "값"을 바꾸지 않고 "위치(인덱스)"만 갱신하여 진행
                    minIndex = j;
                } // if
            } // for

            // minIndex가 바뀌었다면 정렬될 값이 있단 의미
            // 4. 내부 루프가 다 끝나면, 그때 딱 한 번만 바꿈 (Swap)
            if(minIndex != i){
                int tmp = A[i];
                A[i] = A[minIndex];
                A[minIndex] = tmp;
            }// if

        } // for
    }
}
