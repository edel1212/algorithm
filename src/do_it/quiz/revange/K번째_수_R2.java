package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class K번째_수_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] arr = new int[N];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        } // for

        quickSort(0, arr.length -1, arr);

        bw.write(String.valueOf(arr[M-1]));
        bw.flush();
        bw.close();
    }

    public static void quickSort(int left, int right, int[] arr){
        // 재귀 종료 조건
        if(left >= right) return;

        int pivot = arr[ (left + right) / 2 ];
        int partitionIndex = partition(arr,left, right, pivot);

        quickSort(left, partitionIndex -1, arr);
        quickSort(partitionIndex, right, arr);

    }

    public static int partition(int arr[], int left, int right, int pivot){
        while(left <= right){
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;

            if(left <= right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            } //it
        }

        return left;
    }

}
