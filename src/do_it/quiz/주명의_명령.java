package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주명의_명령 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(strToken.nextToken());
        // 정렬
        Arrays.sort(arr);

        int leftPointer = 0;
        int rightPointer = N -1;
        int count = 0;

        while(leftPointer < rightPointer){
            int sum = arr[leftPointer] + arr[rightPointer];
            if(sum == M){
               count++;
               leftPointer++;
               rightPointer--;
            } else if(sum < M){
                leftPointer++;
            } else {
                rightPointer--;
            } // if - else
        } // while

        bw.write(String.valueOf(count));
        bw.flush();
    }
}

