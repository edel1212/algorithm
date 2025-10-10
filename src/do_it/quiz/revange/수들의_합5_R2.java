package do_it.quiz.revange;

import java.io.*;

public class 수들의_합5_R2 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int sum = 1;
        int result = 0;

        while (left <= N) {
            if (sum == N) {
                result++;
                sum -= left;
                left++;
            } else if (sum < N) {
                right++;
                sum += right;
            } else { // sum > N
                sum -= left;
                left++;
            } // if - else
        } // while

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}
