package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 버블소트_R2 {
    static long count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        mergeSort(arr, 0, N - 1);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    public static void mergeSort(int[] arr, int left, int right){
        if( left >= right ) return;
        int mid = (left + right) / 2;

        // left part
        mergeSort(arr, left, mid);
        // right part
        mergeSort(arr, mid + 1, right);

        merge(arr,left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] tmp = new int[right - left  + 1];
        int tmpIndex = 0;
        int leftStartIndex = left;
        // 정확한 위치를 지정하기 위함
        int rightStartIndex = mid + 1;

        while(leftStartIndex <= mid && rightStartIndex <= right){
            if(arr[leftStartIndex] <= arr[rightStartIndex]){
                tmp[tmpIndex] = arr[leftStartIndex];
                leftStartIndex++;
            } else {
                tmp[tmpIndex] = arr[rightStartIndex];
                rightStartIndex++;

                count += mid - leftStartIndex + 1;
            }// if - else
            tmpIndex++;
        } // while

        while(leftStartIndex <= mid){
            tmp[tmpIndex] = arr[leftStartIndex];
            tmpIndex++;
            leftStartIndex++;
        } // while

        while(rightStartIndex <= right){
            tmp[tmpIndex] = arr[rightStartIndex];
            tmpIndex++;
            rightStartIndex++;
        } // while

        for(int i = 0 ; i < tmp.length ; i++){
            arr[left + i] = tmp[i];
        } // for
    }

}
