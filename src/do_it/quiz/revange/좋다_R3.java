package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_R3 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0 ; i < N ; i++) A[i] = Integer.parseInt(stringTokenizer.nextToken());
        Arrays.sort(A);
        int count = 0;

        for(int i = 0 ; i < A.length; i++){
            int base = A[i];
            int left = 0;
            int right = N - 1;

            while(right > left){
                int sum = A[left] + A[right];
                if(sum == base){
                    if(left != i && right != i){
                        count++;
                        break;
                    } else if(left == i) {
                        left++;
                    } else{
                        right--;
                    }// if - else
                } else if(sum < base){
                    left++;
                } else {
                    right--;
                } // if - else
            } // while

        }// for

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
