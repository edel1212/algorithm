package do_it.quiz.revange;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 수열의 개수
        int N = Integer.parseInt(br.readLine());
        // arr init
        long[] arr = new long[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(token.nextToken());

        Arrays.sort(arr);

        int count = 0;

        // 기준 점을 잡기 위함
        for(int i = 0 ; i < N ; i++){
            int left = 0;
            int right = N -1;

            while(left < right){

                long sum = arr[left] + arr[right];

                if(arr[i] == sum){
                    // 요소가 같이 않을 경우
                    if(left != i && right != i){
                        count++;
                        break;
                    } else if(i == left){
                        left++;
                    } else {
                        right--;
                    } // if - else
                } else if (arr[i] < sum) {
                    right--;
                } else {
                    left++;
                }
            } // while

        } // for

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
