package do_it.quiz.revange;

import java.io.*;

public class 수들의_합5_R3 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int left = 1;
        int right = 1;
        int sum = 1;
        int count = 1; // 자기 자신 카운드

        while(N > left){

            if(N == sum){
                count++;
                sum -= left;
                left++;
            } else if(sum < N){
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        } // while

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }
}
