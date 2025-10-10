package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        } // for

        Arrays.sort(A);

        int result = 0;
        for(int i = 0 ; i < N ; i++){
            int left = 0;
            int right = N - 1;

            while(left < right){

                long sum = A[left] + A[right];

                if(A[i] == sum){
                    if(left != i && right != i){
                        result++;
                        break;
                    } else if(i == left){
                        left++;
                    } else {
                        right--;
                    } // if - else
                } else if(A[i] < sum){
                    right--;
                } else{
                    left++;
                } // if - else
            } // while

        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
