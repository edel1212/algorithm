package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;

public class 소트인사이드_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] c = br.readLine().toCharArray();

        int[] arr = new int[c.length];
        for(int i = 0 ; i < c.length ;i++){
            arr[i] = c[i] - '0';
        } // for

        bubbleSort(arr);

        bw.write(Arrays.toString(arr));
        bw.flush();
        bw.close();

    }

    public static void bubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length - 1; i ++){
            for(int j = 0 ; j < arr.length - 1 - i; j ++){
                if(arr[j] < arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }// if
            } //for
        } //for
    }

}
