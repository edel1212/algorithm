package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class ATM_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        } // for

        selectedSort(arr);

        int result = 0;

        int[] S = new int[N + 1];
        for(int i = 1 ; i <= arr.length; i++){
            S[i] = S[i-1] + arr[i-1];
        }//for

        for(int s : S){
            result += s;
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

    public static void selectedSort(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1; j < arr.length ; j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                } //if
            } //for
        } //for
    }

}
