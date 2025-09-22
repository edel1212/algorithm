package do_it.quiz;

import java.io.*;

public class 수_정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 개수
        int N = Integer.parseInt(br.readLine());
        // 배열 초기화
        int[] arr = new int[N];
        // 배열 init
        for(int i = 0 ; i < arr.length; i++) arr[i] = Integer.parseInt(br.readLine());

        mergeSort(arr, 0 , arr.length - 1);

        for(int i = 0 ; i < arr.length ; i++){
            bw.write(String.valueOf(arr[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    /**
     * 병합 정렬 - 배열의 요소룰 최대한 나눈 후 각각읠 정렬 한 후 병합 하여 정렬하는 방식
     *
     * @param arr the base arr
     * @param left the partition left element
     * @param right the partition right element
     */
    public static void mergeSort(int[] arr, int left, int right){
        // 재귀 종료 조건 : 더 이상 나눌 수 없을 경우
        if(left >= right) return;

        // 분할 기준이 될 가운데 Index
        int mid = (left + right) / 2;

        // 왼쪽 절반 정렬
        mergeSort(arr, left, mid);
        // 오른쪽 절반 정렬
        mergeSort(arr, mid + 1, right);

        // 병합 및 정렬
        merge(arr, left, mid, right);

    }

    /**
     * 재귀로 넘어온 각각의 요소를을 정렬 후 병함
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr, int left, int mid, int right){
        // 임시 배열의 크기 가장 끝 Index 와 시작하는 인덱스를 뺀 후 +1을 해주면 필요한 배열의 길이를 알 수 있음
        int[] tmp = new int[right - left + 1];

        // 왼쪽의 시작 인덱스
        int i = left;
        // 오른쪽의 시작 인덱스
        int j = mid + 1;
        // 임시 베열 인덱스
        int k = 0;

        // 두 배열(i, j)을 비교하면서 작은 값부터 temp 주입
        while( i <= mid && j <= right ){
            // 오른쪽 기준 요소가 클 경우
            if( arr[i] <= arr[j] ){
                // tmp에는 오름차순으로 정렬하기에 작은 요소인 i를 삽임
                tmp[k] = arr[i];
                i++;
                k++;
            } else{
                tmp[k] = arr[j];
                j++;
                k++;
            } // if - else
        } // while

        // 왼쪽 남은 값 정리 (섞여있는 값 먼저 정리 후 남은 값 처리)
        while(i <= mid){
            tmp[k] = arr[i];
            k++;
            i++;
        } // while

        // 오른쪽 남은 값 정리 (섞여있는 값 먼저 정리 후 남은 값 처리)
        while(j <= right){
            tmp[k] = arr[j];
            k++;
            j++;
        } // while

        // 기존 배열에 값 주입
        for(int t = 0 ; t < tmp.length; t++){
            arr[left + t] = tmp[t];
        } // for

    }
}
