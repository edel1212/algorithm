package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class K번째_수R {
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

        insertSort(arr);

        bw.write(String.valueOf(arr[M-1]));
        bw.flush();
        bw.close();

    }


    public static void insertSort(int[] arr){
        for(int i = 1 ; i < arr.length ; i++){
            int key = arr[i];
            int range = i - 1;
            while(0 <= range && arr[range] > key){
                arr[range +1] = arr[range];
                range--;
            } // while
            arr[range + 1] = key;
        } // for
    } //for

}
