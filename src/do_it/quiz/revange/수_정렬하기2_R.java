package do_it.quiz.revange;

import java.io.*;

public class 수_정렬하기2_R {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        } // for

        mergeSort(0,arr.length -1, arr);

        for(int i : arr){
            bw.write(String.valueOf(i));
            bw.newLine();
        } //for
        bw.flush();
        bw.close();

    }

    public static void mergeSort(int left, int right, int[] arr){
        // 재귀 종료 조건
        if(left >= right) return;

        int mid = (left + right) / 2;

        // left part
        mergeSort(left, mid , arr);
        // right part
        mergeSort(mid + 1, right, arr);

        // merge
        merge(left, mid, right, arr);
    }

    public static void merge(int left, int mid, int right, int[] arr){
        // 임시 배열 생성
        int[] tmp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int tmpIndex = 0;

        // 오른쪽 파트와 왼쪽 파트 전부다 가능할 경우
        while( i <= mid && j <= right ){
            if(arr[i] <= arr[j]){
                tmp[tmpIndex] = arr[i];
                tmpIndex++;
                i++;
            } else {
                tmp[tmpIndex] = arr[j];
                tmpIndex++;
                j++;
            } // if - else
        } // while

        while(i <= mid){
            tmp[tmpIndex] = arr[i];
            tmpIndex++;
            i++;
        } // while

        while(j <= right){
            tmp[tmpIndex] = arr[j];
            tmpIndex++;
            j++;
        } // while

        for(int t = 0 ; t < tmp.length; t++){
            arr[left + t] = tmp[t];
        } // for

    }
}
